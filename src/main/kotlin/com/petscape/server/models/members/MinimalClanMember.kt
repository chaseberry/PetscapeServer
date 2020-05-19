package com.petscape.server.models.members

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import java.util.*

class MinimalClanMember {

    @BsonId
    lateinit var _id: ObjectId
        private set

    lateinit var ign: String
        private set

    lateinit var joinDate: Date
        private set

    lateinit var lastSeen: Date
        private set

}