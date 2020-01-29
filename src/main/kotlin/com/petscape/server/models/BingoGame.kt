package com.petscape.server.models

import com.fasterxml.jackson.annotation.JsonProperty
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

class BingoGame {
    @BsonId var id = ObjectId()
    var name: String? = null
    var cards: MutableList<BingoCard> = mutableListOf()
    var type = BingoGameType.OTHER
    var freeSpace = true

    var parentCard: List<BingoSquare>? = null //if it exists, all new cards use this as a template
}

class BingoCard {
    @BsonId var id = ObjectId()
    var username: String? = null
    var squares: List<BingoSquare>? = null
    var notes = ""
}

class BingoSquare {
    companion object {
        val FreeSquare = BingoSquare().apply {
            completed = true
        }
    }

    @BsonId var id = ObjectId()
    var boss: LiteBoss? = null
    var item: Drop? = null
    var task: String? = null
    var completed = false
}

enum class BingoGameType { BOSSES, ITEMS, COMBINED, OTHER }

class CustomSquare {
    @JsonProperty(required = false) var boss: String? = null
    @JsonProperty(required = false) var item: String? = null
    @JsonProperty(required = false) var task: String? = null
}