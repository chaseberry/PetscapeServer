package com.petscape.server

import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import com.petscape.server.mongo.PetscapeCollection
import org.bson.Document
import java.util.regex.Pattern
import java.util.regex.PatternSyntaxException
import javax.ws.rs.core.Response

fun ok(body: Any? = null) = Response.ok(body).build()

fun noContent() = Response.noContent().build()

fun doc(vararg elements: Pair<String, Any?>): Document {
    val d = Document()
    elements.forEach { d.put(it.first, it.second) }
    return d
}

fun String.regexify() = try {
    Pattern.compile(this, Pattern.CASE_INSENSITIVE)
} catch (e: PatternSyntaxException) {
    Pattern.compile(Pattern.quote(this), Pattern.CASE_INSENSITIVE)
}

operator fun MongoDatabase.get(collection: PetscapeCollection): MongoCollection<Document> =
    this.getCollection(collection.name)