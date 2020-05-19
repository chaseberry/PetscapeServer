package com.petscape.server.models.members

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import java.util.*

class ClanMember {

    @BsonId
    lateinit var _id: ObjectId
        private set

    lateinit var ign: String
        private set

    lateinit var discordName: String
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

}