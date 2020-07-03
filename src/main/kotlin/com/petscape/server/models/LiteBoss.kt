package com.petscape.server.models

import com.fasterxml.jackson.annotation.JsonProperty

class LiteBoss {
    lateinit var name: String
    lateinit var file: String
    var wilderness = false
    @JsonProperty("slayer_level") var slayerLevel = 0
}