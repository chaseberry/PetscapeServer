package com.petscape.server.api

import com.mongodb.client.MongoDatabase
import com.petscape.server.COLLECTION_BINGO_GAMES
import com.petscape.server.models.BingoGame
import com.petscape.server.models.BingoGameType
import com.petscape.server.models.BingoSquare
import com.petscape.server.models.CustomSquare
import com.petscape.server.utils.BINGO_NUM_SQUARES
import com.petscape.server.utils.generateSquares
import com.petscape.server.utils.getBosses
import com.petscape.server.utils.getItems
import javax.annotation.security.PermitAll
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/bingo/new_game")
@Produces(MediaType.APPLICATION_JSON)
@PermitAll
class NewBingoGameResource(private val db: MongoDatabase) {

    @POST
    fun createBingoGame(
        @QueryParam("name") @NotEmpty name: String,
        @QueryParam("type") @NotEmpty type: String,
        @QueryParam("free_space") @NotEmpty freeSpace: String,
        @QueryParam("cards_match") @NotEmpty cardsMatch: String
    ): BingoGame {
        validateType(type)

        val game = BingoGame()
        game.name = name
        game.cards = mutableListOf()
        game.type = BingoGameType.valueOf(type)
        game.freeSpace = freeSpace.toBoolean()

        if (cardsMatch.toBoolean()) {
            game.parentCard = generateSquares(db, game.type, freeSpace.toBoolean())
        }

        db.getCollection(COLLECTION_BINGO_GAMES, BingoGame::class.java).insertOne(game)
        return game
    }
}

@Path("/bingo/new_custom_game")
@Produces(MediaType.APPLICATION_JSON)
@PermitAll
class NewCustomBingoGameResource(private val db: MongoDatabase) {

    @POST
    fun createBingoGame(
        @QueryParam("name") @NotEmpty name: String,
        @NotNull squares: List<CustomSquare>
    ): BingoGame {
        val game = BingoGame()
        game.name = name
        game.cards = mutableListOf()
        game.type = BingoGameType.OTHER

        if (squares.size != BINGO_NUM_SQUARES) {
            throw WebApplicationException("Must provide 25 squares", Response.Status.BAD_REQUEST)
        }

        val bosses = getBosses(db)
        val items = getItems(bosses)

        game.parentCard = squares.map { customSquare ->
            val square = BingoSquare()
            square.boss = bosses.find { it.name == customSquare.boss }?.toLiteBoss()
            square.item = items.find { it.item == customSquare.item }
            square.task = customSquare.task

            if (square.boss != null || square.item != null || square.task != null) {
                square
            } else {
                BingoSquare.FreeSquare
            }
        }

        db.getCollection(COLLECTION_BINGO_GAMES, BingoGame::class.java).insertOne(game)
        return game
    }
}

private fun validateType(type: String) {
    val validTypes = listOf(BingoGameType.BOSSES, BingoGameType.ITEMS, BingoGameType.COMBINED)
    if (validTypes.none { it.toString() == type })
        throw WebApplicationException("type must be one of $validTypes}", Response.Status.BAD_REQUEST)
}