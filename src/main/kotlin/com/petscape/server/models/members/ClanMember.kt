package com.petscape.server.models.members

import java.util.*

class ClanMember {

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

}