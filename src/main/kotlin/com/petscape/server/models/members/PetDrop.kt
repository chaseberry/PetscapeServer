package com.petscape.server.models.members

import com.petscape.server.models.Pet
import java.util.*

class PetDrop {

    //Id of the Pet object
    lateinit var pet: Pet
        private set

    //XP or KC the pet was dropped
    var score: Int? = null
        private set

    var dropDate: Date? = null
        private set

    companion object {
        fun new(pet: Pet) = PetDrop().apply {
            this.pet = pet
        }

        fun create(pet: Pet, score: Int? = null, date: Date = Date()): PetDrop {
            return new(pet).apply {
                this.score = score
                dropDate = date
            }
        }

    }
}