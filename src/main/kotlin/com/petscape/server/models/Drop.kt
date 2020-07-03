package com.petscape.server.models

import com.fasterxml.jackson.annotation.JsonProperty

data class Drop(val item: String,
                val image: String,
                val dropRate: Int) {

}