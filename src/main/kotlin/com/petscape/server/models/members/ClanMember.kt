package com.petscape.server.models.members

import com.petscape.server.api.members.CreateMemberParameters
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import java.util.*

class ClanMember {

    @BsonId
    lateinit var _id: ObjectId
        private set

    lateinit var ign: String
        private set

    lateinit var pastIgns: List<String>
        private set

    var discordName: String? = null
        private set

    lateinit var rank: ClanRank
        private set

    lateinit var joinDate: Date
        private set

    lateinit var lastSeen: Date
        private set

    val splits: Int = 0

    lateinit var pets: List<PetDrop>
        private set

    lateinit var status: MemberStatus

    var notes: String? = null

    //TODO skills vs totalLevel

    //TODO boss kcs vs totalKc

    //TODO clues

    companion object {
        fun create(params: CreateMemberParameters): ClanMember {
            return ClanMember().apply {
                _id = ObjectId()
                ign = params.ign
                discordName = params.discordName
                rank = ClanRank.smiley
                joinDate = Date()
                lastSeen = Date()
                pets = params.pets.map { PetDrop.new(it) }
                status = MemberStatus.active
            }
        }
    }

}