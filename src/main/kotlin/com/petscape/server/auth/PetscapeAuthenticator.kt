package com.petscape.server.auth

import com.mongodb.client.MongoDatabase
import com.petscape.server.PetscapeConfiguration
import io.dropwizard.auth.Authenticator
import io.dropwizard.auth.basic.BasicCredentials
import org.eclipse.jetty.server.Authentication
import java.util.*

class PetscapeAuthenticator(private val db: MongoDatabase,
                            private val config: PetscapeConfiguration) : Authenticator<BasicCredentials, User> {

    override fun authenticate(credentials: BasicCredentials?): Optional<User> {
        return if (config.username == credentials?.username && config.password == credentials?.password) {
            Optional.of(User("Petscape CC"))
        } else {
            Optional.empty()
        }
    }
}