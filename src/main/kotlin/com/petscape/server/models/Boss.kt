package com.petscape.server.models

import com.fasterxml.jackson.annotation.JsonProperty

class Boss {
    lateinit var name: String
    lateinit var file: String
    var wilderness = false
    @JsonProperty("slayer_level") var slayerLevel = 0
    lateinit var drops: List<Drop>

    fun toLiteBoss(): LiteBoss {
        val liteBoss = LiteBoss()
        liteBoss.name = name
        liteBoss.file = file
        liteBoss.wilderness = wilderness
        liteBoss.slayerLevel = slayerLevel
        return liteBoss
    }
}

class LiteBoss {
    lateinit var name: String
    lateinit var file: String
    var wilderness = false
    @JsonProperty("slayer_level") var slayerLevel = 0
}