package com.petscape.server

import com.fasterxml.jackson.annotation.JsonProperty
import io.dropwizard.Configuration
import javax.validation.constraints.NotEmpty


class PetscapeConfiguration : Configuration() {
    lateinit var username: String
    lateinit var password: String
}