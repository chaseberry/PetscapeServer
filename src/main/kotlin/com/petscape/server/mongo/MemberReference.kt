package com.petscape.server.mongo

import com.mongodb.client.MongoDatabase
import com.petscape.server.doc
import com.petscape.server.get
import com.petscape.server.models.members.ClanMember
import org.bson.Document
import org.bson.types.ObjectId
import java.lang.reflect.Member
import java.util.*

class MemberReference(private val ref: Reference) {

    sealed class Reference {

        abstract fun query(): Document

        class ign(val ign: String) : Reference() {
            override fun query() = doc("ign" to ign)
        }

        class _id(val _id: ObjectId) : Reference() {
            override fun query() = doc("_id" to _id)
        }

    }

    fun get(db: MongoDatabase): ClanMember? {
        return db[PetscapeCollection.clanMembers].find(ref.query(), ClanMember::class.java).firstOrNull()
    }

    fun updateLastSeen(db: MongoDatabase) {
        //TODO retry on connection issue/failure?
        //TODO what do if member does not exist?
        db[PetscapeCollection.clanMembers].findOneAndUpdate(
            ref.query(),
            doc(
                "\$set" to doc(
                    "lastSeen" to Date()
                )
            )
        )
    }

    companion object {
        fun from(str: String): MemberReference {
            val ref = try {
                Reference._id(ObjectId(str))
            } catch (e: IllegalArgumentException) {
                Reference.ign(str)
            }

            return MemberReference(ref)
        }
    }
}