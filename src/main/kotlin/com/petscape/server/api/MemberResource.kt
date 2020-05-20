package com.petscape.server.api

import com.mongodb.client.MongoDatabase
import com.petscape.server.*
import com.petscape.server.api.members.CreateMemberParameters
import com.petscape.server.models.members.ClanMember
import com.petscape.server.models.members.MemberStatus
import com.petscape.server.models.members.MinimalClanMember
import com.petscape.server.mongo.MemberReference
import com.petscape.server.mongo.PetscapeCollection
import javax.validation.Valid
import javax.validation.constraints.NotNull
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/members")
@Produces(MediaType.APPLICATION_JSON)
class MemberResource(val database: MongoDatabase) {

    @GET
    fun getAllMembers(@QueryParam("query") query: String?): Response {

        val filter = doc(
            "status" to MemberStatus.active
        )

        query?.let {
            val str = it.regexify()
            filter["\$or"] = listOf(
                doc("ign" to str),
                doc("discordName" to str)
            )
        }

        val members = database[PetscapeCollection.clanMembers].find(
            filter,
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

    @POST
    fun createMember(@Valid @NotNull params: CreateMemberParameters): Response {
        val member = ClanMember.create(params)

        //TODO clan member pets might be just a list of strings...
        database.getCollection(
            PetscapeCollection.clanMembers.name,
            ClanMember::class.java
        ).insertOne(member)

        return ok(member)
    }

    @GET
    @Path("/{id}")
    fun getMember(@PathParam("id") id: String): Response {

        val member = MemberReference.from(id).get(database) ?: return notFound("No member found matching $id")

        return ok(member)
    }

    @PUT
    @Path("/{id}/last-seen")
    fun updateLastSeen(@PathParam("id") id: String): Response {
        MemberReference.from(id).updateLastSeen(database)

        return noContent()
    }

}