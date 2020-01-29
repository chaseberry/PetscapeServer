package com.petscape.server.models

import com.fasterxml.jackson.annotation.JsonProperty

class Drop {
    lateinit var item: String
    lateinit var file: String
    @JsonProperty(value = "drop_rate") var dropRate = 0

    override fun equals(other: Any?): Boolean {
        return other is Drop && other.item == item
    }

    override fun hashCode(): Int {
        return item.hashCode()
    }
}