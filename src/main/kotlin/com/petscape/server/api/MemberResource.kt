package com.petscape.server.api

import com.mongodb.client.MongoDatabase
import com.petscape.server.doc
import com.petscape.server.get
import com.petscape.server.models.members.MemberStatus
import com.petscape.server.models.members.MinimalClanMember
import com.petscape.server.mongo.PetscapeCollection
import com.petscape.server.noContent
import com.petscape.server.ok
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/members")
@Produces(MediaType.APPLICATION_JSON)
class MemberResource(val database: MongoDatabase) {

    @GET
    fun getAllMembers(@QueryParam("query") query: String?): Response {
        val members = database[PetscapeCollection.clanMembers].find(
            doc(
                "status" to MemberStatus.active
            ),
            MinimalClanMember::class.java
        ).projection(
            doc(
                "_id" to 1,
                "ign" to 1,
                "joinDate" to 1,
                "lastSeen" to 1
            )
        ).toList()

        return ok(members)
    }

    @GET
    @Path("/{id}")
    fun getMember(@PathParam("id") id: String): Response {

        return noContent()
    }

}