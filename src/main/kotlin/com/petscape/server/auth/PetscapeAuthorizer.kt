package com.petscape.server.auth

import io.dropwizard.auth.Authorizer
import javax.ws.rs.container.ContainerRequestContext

class PetscapeAuthorizer : Authorizer<User> {

    override fun authorize(principal: User?, role: String?, requestContext: ContainerRequestContext?): Boolean {
        return true
    }

    override fun authorize(principal: User?, role: String?): Boolean {
        return true
    }
}