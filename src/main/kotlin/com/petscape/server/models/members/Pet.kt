package com.petscape.server.models.members

import com.petscape.server.models.GameTag
import org.bson.types.ObjectId

class Pet {

    lateinit var _id: ObjectId
        private set

    lateinit var name: String
        private set

    lateinit var tags: List<GameTag>
        private set
}