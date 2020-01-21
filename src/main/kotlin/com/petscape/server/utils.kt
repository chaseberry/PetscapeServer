package com.petscape.server

import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import com.petscape.server.mongo.PetscapeCollection
import org.bson.Document

fun doc(vararg elements: Pair<String, Any?>): Document {
    val d = Document()
    elements.forEach { d.put(it.first, it.second) }
    return d
}

operator fun MongoDatabase.get(collection: PetscapeCollection): MongoCollection<Document> = this.getCollection(collection.name)