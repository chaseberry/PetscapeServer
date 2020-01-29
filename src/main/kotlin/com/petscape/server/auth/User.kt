package com.petscape.server.auth

import java.security.Principal

class User(private val username: String) : Principal {

    override fun getName(): String {
        return username
    }
}