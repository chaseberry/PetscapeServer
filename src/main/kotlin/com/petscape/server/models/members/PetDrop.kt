package com.petscape.server.models.members

import org.bson.types.ObjectId

class PetDrop {

    lateinit var _id: ObjectId
        private set

    //Id of the Pet object
    lateinit var petId: ObjectId
        private set

    //XP or KC the pet was dropped
    val score: Int? = null
}