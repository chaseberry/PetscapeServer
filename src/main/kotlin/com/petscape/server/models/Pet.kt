package com.petscape.server.models

import com.petscape.server.models.GameTag
import org.bson.types.ObjectId

enum class Pet(val display: String,
               val tags: List<GameTag>,
    //val boss: ?,
               val dropRate: Int,
               val image: String) {

    babyChinchompa(
        display = "Baby Chinchompa",
        tags = listOf(GameTag.skilling),
        //boss = null,
        dropRate = 26_068_808, //xp
        image = "/pets/babyChin.gif"
    )


}