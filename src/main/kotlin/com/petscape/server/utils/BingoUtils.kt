package com.petscape.server.utils

import com.mongodb.client.MongoDatabase
import com.petscape.server.COLLECTION_BOSSES
import com.petscape.server.models.*
import kotlin.random.Random

const val BINGO_NUM_SQUARES = 25
private const val FREE_SQUARE = 12

fun generateSquares(db: MongoDatabase, type: BingoGameType, freeSpace: Boolean): List<BingoSquare> {
    val squares = mutableListOf<BingoSquare>()
    val choices = getSquareChoices(db, type).toMutableList()

    for (i in 0 until BINGO_NUM_SQUARES) {
        val square = if (freeSpace && i == FREE_SQUARE) {
            BingoSquare.FreeSquare
        } else {
            val index = Random.Default.nextInt(choices.size)
            val choice = if (type != BingoGameType.BOSSES) choices.removeAt(index) else choices[index]
            val square = BingoSquare()

            when (type) {
                BingoGameType.BOSSES -> square.boss = choice as LiteBoss
                BingoGameType.ITEMS -> square.item = choice as Drop
                BingoGameType.COMBINED -> {
                    val pair = choice as Pair<*, *>
                    square.boss = pair.first as LiteBoss
                    square.item = pair.second as Drop
                }
                else -> Unit
            }

            square
        }

        squares.add(square)
    }

    return squares
}

private fun getSquareChoices(db: MongoDatabase, type: BingoGameType): List<Any> {
    val bosses = getBosses(db)

    return when (type) {
        BingoGameType.BOSSES -> bosses.map { it.toLiteBoss() }
        BingoGameType.ITEMS -> getItems(bosses)
        BingoGameType.COMBINED -> {
            return bosses.flatMap { boss ->
                boss.drops.map { drop ->
                    Pair(boss.toLiteBoss(), drop)
                }
            }
        }
        else -> emptyList()
    }
}

fun getBosses(db: MongoDatabase): List<Boss> {
    return db.getCollection(COLLECTION_BOSSES, Boss::class.java).find().toList()
}

fun getItems(bosses: List<Boss>): List<Drop> {
    val items = bosses.flatMap { it.drops }
    return items.distinctBy(Drop::item)
}