package com.petscape.server.api.members

import com.petscape.server.models.Pet
import javax.validation.constraints.NotNull

class CreateMemberParameters {

    @NotNull
    lateinit var ign: String

    @NotNull //TODO required for create?
    lateinit var discordName: String

    lateinit var pets: List<Pet>

}