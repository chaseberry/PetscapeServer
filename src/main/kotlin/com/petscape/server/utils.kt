package com.petscape.server

import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import com.petscape.server.mongo.PetscapeCollection
import org.bson.Document
import javax.ws.rs.core.Response

fun ok(body: Any? = null) = Response.ok(body).build()

fun noContent() = Response.noContent().build()

fun doc(vararg elements: Pair<String, Any?>): Document {
    val d = Document()
    elements.forEach { d.put(it.first, it.second) }
    return d
}

operator fun MongoDatabase.get(collection: PetscapeCollection): MongoCollection<Document> = this.getCollection(collection.name)