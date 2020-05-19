package com.petscape.server.api

import com.mongodb.client.MongoDatabase
import com.petscape.server.COLLECTION_BINGO_GAMES
import com.petscape.server.models.BingoCard
import com.petscape.server.models.BingoGame
import com.petscape.server.models.BingoSquare
import com.petscape.server.utils.FileUtils
import org.bson.types.ObjectId
import org.litote.kmongo.findOneById
import java.awt.Color
import java.awt.FontMetrics
import java.awt.image.BufferedImage
import java.io.ByteArrayOutputStream
import java.util.*
import javax.annotation.security.PermitAll
import javax.imageio.ImageIO
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response


@Path("/bingo/get_card")
@Produces(MediaType.APPLICATION_JSON)
@PermitAll
class GetCardResource(private val db: MongoDatabase) {

    @GET
    fun getCard(@QueryParam("game_id") @NotNull gameId: ObjectId,
                @QueryParam("username") @NotEmpty username: String): BingoCard {
        val games = db.getCollection(COLLECTION_BINGO_GAMES, BingoGame::class.java)
        val game = games.findOneById(gameId) ?: throw WebApplicationException("Game not found", Response.Status.NOT_FOUND)
        return game.cards.find { it.username == username } ?: throw WebApplicationException("Card not found", Response.Status.NOT_FOUND)
    }
}


@Path("/bingo/get_card_image")
@Produces("image/png")
@PermitAll
class GetCardImageResource(private val db: MongoDatabase) {

    private val imageSize = 600
    private val squareSize = imageSize / 5
    private val subSquareSize = squareSize / 3

    @GET
    fun getImage(@QueryParam("game_id") @NotNull gameId: ObjectId,
                 @QueryParam("username") @NotEmpty username: String): Response {
        val games = db.getCollection(COLLECTION_BINGO_GAMES, BingoGame::class.java)
        val game = games.findOneById(gameId) ?: throw WebApplicationException("Game not found", Response.Status.NOT_FOUND)
        val card = game.cards.find { it.username == username } ?: throw WebApplicationException("Card not found", Response.Status.NOT_FOUND)
        val imageData = generateImage(card)

        return Response.status(200)
                .header("Content-Length", imageData.size)
                .header("Cache-Control", "max-age=86400, public")
                .entity(imageData)
                .type("image/png")
                .encoding("image/png").build()
    }

    private fun generateImage(card: BingoCard): ByteArray {
        val image = BufferedImage(imageSize, imageSize, BufferedImage.TYPE_INT_ARGB)
        var x = 0
        var y = 0

        card.squares?.forEach { square ->
            val squareImage = generateSquareImage(square)
            image.graphics.drawImage(squareImage, x, y, squareSize, squareSize, null)

            x += squareSize
            if (x >= imageSize) {
                x = 0
                y += squareSize
            }
        }

        val baos = ByteArrayOutputStream()
        ImageIO.write(image, "png", baos)
        return baos.toByteArray()
    }

    private fun generateSquareImage(square: BingoSquare): BufferedImage {
        //todo draw extra 1 pixel border around the image
        val image = BufferedImage(squareSize, squareSize, BufferedImage.TYPE_INT_ARGB)
        image.createGraphics().apply {
            if (square.completed) {
                paint = Color(181, 58, 58)
                fillRect(0, 0, squareSize, squareSize)
            }

            color = Color.BLACK
            drawRect(0, 0, squareSize - 1, squareSize - 1)
        }

        if (square.boss != null) {
            val bossImage = ImageIO.read(FileUtils.loadBoss(square.boss!!))
            drawMainImage(bossImage, image)
            if (square.item != null) {
                val itemImage = ImageIO.read(FileUtils.loadDrop(square.item!!))
                drawSubImage(itemImage, image)
            }
        } else if (square.item != null) {
            val itemImage = ImageIO.read(FileUtils.loadDrop(square.item!!))
            drawMainImage(itemImage, image)
        } else if (square.task != null) {
            drawWrappedString(image, square.task!!, if (square.completed) Color.WHITE else Color.BLACK)
        } else {
            drawCenteredString(image, "Free Space", Color.WHITE)
        }

        return image
    }

    private fun drawMainImage(srcImage: BufferedImage, destImage: BufferedImage) {
        val scale = getScale(srcImage)
        val paddedSquareSize = squareSize - 4

        if (srcImage.height < srcImage.width) {
            val scaledHeight = (paddedSquareSize * scale).toInt()
            val offset = (squareSize - scaledHeight) / 2
            destImage.graphics.drawImage(srcImage, 2, offset, paddedSquareSize, scaledHeight, null)
        } else {
            val scaledWidth = (paddedSquareSize * scale).toInt()
            val offset = (squareSize - scaledWidth) / 2
            destImage.graphics.drawImage(srcImage, offset, 2, scaledWidth, paddedSquareSize, null)
        }
    }

    private fun drawSubImage(srcImage: BufferedImage, destImage: BufferedImage) {
        val scale = getScale(srcImage)
        if (srcImage.height < srcImage.width) {
            val scaledHeight = (subSquareSize * scale).toInt()
            val x = destImage.width - subSquareSize - 4
            val y = destImage.height - scaledHeight - 4
            destImage.graphics.drawImage(srcImage, x, y, subSquareSize, scaledHeight , null)
        } else {
            val scaledWidth = (subSquareSize * scale).toInt()
            val x = destImage.width - scaledWidth - 4
            val y = destImage.height - subSquareSize - 4
            destImage.graphics.drawImage(srcImage, x, y, scaledWidth, subSquareSize , null)
        }
    }

    private fun drawWrappedString(image: BufferedImage, text: String, textColor: Color) {
        val graphics = image.createGraphics()
        graphics.paint = textColor

        var y = graphics.fontMetrics.height
        val textLines = wrap(text, graphics.fontMetrics)
        textLines.forEach { line ->
            graphics.drawString(line, 4, y)
            y += graphics.fontMetrics.height
        }
    }

    private fun drawCenteredString(image: BufferedImage, text: String, textColor: Color) {
        image.createGraphics().apply {
            val x = (squareSize - fontMetrics.stringWidth(text)) / 2
            val y = (squareSize - fontMetrics.height) / 2 + fontMetrics.ascent
            paint = textColor
            drawString(text, x, y)
        }
    }

    private fun wrap(txt: String, fm: FontMetrics, maxWidth: Int = squareSize - 4): List<String> {
        val st = StringTokenizer(txt)
        val list: MutableList<String> = mutableListOf()

        var line = ""
        var lineBeforeAppend = ""

        while (st.hasMoreTokens()) {
            val seg = st.nextToken()
            lineBeforeAppend = line
            line += "$seg "

            val width = fm.stringWidth(line)
            line = if (width < maxWidth) {
                continue
            } else { //new Line.
                list.add(lineBeforeAppend)
                "$seg "
            }
        }

        //the remaining part.
        if (line.isNotEmpty()) {
            list.add(line)
        }

        return list
    }

    private fun getScale(image: BufferedImage): Float {
        return when {
            image.height < image.width -> image.height.toFloat() / image.width.toFloat()
            else -> image.width.toFloat() / image.height.toFloat()
        }
    }
}

@Path("/bingo/winners")
@Produces(MediaType.APPLICATION_JSON)
@PermitAll
class GetWinnersResource(private val db: MongoDatabase) {

    @GET
    fun getWinners(@QueryParam("game_id") @NotNull gameId: ObjectId): List<BingoCard> {
        val games = db.getCollection(COLLECTION_BINGO_GAMES, BingoGame::class.java)
        val game = games.findOneById(gameId) ?: throw WebApplicationException("Game not found", Response.Status.NOT_FOUND)
        return game.winners()
    }
}