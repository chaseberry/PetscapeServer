package com.petscape.server.models.members

import com.petscape.server.models.GameTag

class Pet {

    lateinit var name: String
        private set

    lateinit var tags: List<GameTag>
        private set
}