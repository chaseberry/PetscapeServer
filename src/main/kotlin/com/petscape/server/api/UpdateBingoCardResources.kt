package com.petscape.server.api

import com.mongodb.client.MongoDatabase
import com.petscape.server.COLLECTION_BINGO_GAMES
import com.petscape.server.models.BingoCard
import com.petscape.server.models.BingoGame
import org.bson.types.ObjectId
import org.litote.kmongo.findOneById
import org.litote.kmongo.replaceOneById
import javax.annotation.security.PermitAll
import javax.validation.constraints.NotNull
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/bingo/complete_square")
@Produces(MediaType.APPLICATION_JSON)
@PermitAll
class CompleteSquareResource(private val db: MongoDatabase) {

    @POST
    fun updateBingoCard(@QueryParam("game_id") @NotNull gameId: ObjectId,
                        @QueryParam("card_id") @NotNull cardId: ObjectId,
                        @QueryParam("square_id") @NotNull squareId: ObjectId): BingoCard {

        val games = db.getCollection(COLLECTION_BINGO_GAMES, BingoGame::class.java)
        val game = games.findOneById(gameId) ?: throw WebApplicationException("Game not found", Response.Status.NOT_FOUND)
        val card = game.cards.find { it.id == cardId } ?: throw WebApplicationException("Card not found", Response.Status.NOT_FOUND)
        val square = card.squares?.find { it.id == squareId } ?: throw WebApplicationException("Square not found", Response.Status.NOT_FOUND)
        square.completed = true

        games.replaceOneById(gameId, game)
        return card
    }
}

@Path("/bingo/update_notes")
@Produces(MediaType.APPLICATION_JSON)
@PermitAll
class UpdateNotesResource(private val db: MongoDatabase) {

    @POST
    fun updateNotes(@QueryParam("game_id") @NotNull gameId: ObjectId,
                    @QueryParam("card_id") @NotNull cardId: ObjectId,
                    @QueryParam("notes") notes: String): BingoCard {

        val games = db.getCollection(COLLECTION_BINGO_GAMES, BingoGame::class.java)
        val game = games.findOneById(gameId) ?: throw WebApplicationException("Game not found", Response.Status.NOT_FOUND)
        val card = game.cards.find { it.id == cardId } ?: throw WebApplicationException("Card not found", Response.Status.NOT_FOUND)
        card.notes = notes

        games.replaceOneById(gameId, game)
        return card
    }
}