package com.petscape.server.models

import com.fasterxml.jackson.annotation.JsonProperty

enum class Boss(val display: String,
                val image: String,
                val wilderness: Boolean = false,
                val slayerLevel: Int? = null,
                val drops: List<Drop>) {

//TODO how to deal with gauntlet and its weird drop rates

    abyssalSire(
        display = "Abyssal Sire",
        image = "abyssal_sire.png",
        slayerLevel = 85,
        drops = listOf()
    ),
    alchemicalHydra(
        display = "Alchemical Hydra",
        image = "alchemical_hydra.png",
        slayerLevel = 95,
        drops = listOf()
    ),
    callisto(
        display = "Callisto",
        image = "callisto.png",
        drops = listOf()
    ),
    cerberus(
        display = "Cerberus",
        image = "cerberus.png",
        slayerLevel = 91,
        drops = listOf()
    ),
    chaosElemental(
        display = "Chaos Elemental",
        image = "chaos_elemental.png",
        wilderness = true,
        drops = listOf()
    ),
    //TODO chaos Fanatic/chaos Archaeologist?
    commanderZilyana(
        display = "Commander Zilyana",
        image = "zilyana.png",
        drops = listOf()
    ),
    corporealBeast(
        display = "Corporeal Beast",
        image = "corporeal_beast.png",
        drops = listOf()
    ),
    dagannothPrime(
        display = "Dagannoth Prime",
        image = "dagannoth_prime.png",
        drops = listOf()
    ),
    dagannothRex(
        display = "Dagannoth Rex",
        image = "dagannoth_rex.png",
        drops = listOf()
    ),
    dagannothSupreme(
        display = "Dagannoth Supreme",
        image = "dagannoth_supreme.png",
        drops = listOf()
    ),
    generalGraardor(
        display = "General Graardor",
        image = "graardor.png",
        drops = listOf()
    ),
    //TODO Giant Mole
    grotesqueGuardians(
        display = "Grotesque Guardians",
        image = "grotesque_guardians.png",
        slayerLevel = 75,
        drops = listOf()
    ),
    kalphiteQueen(
        display = "Kalphite Queen",
        image = "kalphite_queen.png",
        drops = listOf()
    ),
    kingBlackDragon(
        display = "King Black Dragon",
        image = "king_black_dragon.png",
        drops = listOf()
    ),
    kraken(
        display = "Kraken",
        image = "kraken.png",
        slayerLevel = 87,
        drops = listOf()
    ),
    kreeArra(
        display = "Kree'Arra",
        image = "kreearra.png",
        drops = listOf()
    ),
    krilTsutsaroth(
        display = "Kril Tsutsaroth",
        image = "kril_tsutsaroth.png",
        drops = listOf()
    ),
    nightmare(
        display = "The Nightmare",
        image = "",
        drops = listOf()
    ),
    sarachnis(
        display = "Sarachnis",
        image = "sarachnis.png",
        drops = listOf()
    ),
    scopria(
        display = "Scoripia",
        image = "scorpia.png",
        wilderness = true,
        drops = listOf()
    ),
    //TODO skotizo?
    thermonuclearSmokeDevil(
        display = "Thermonuclear Smoke Devil",
        image = "thermonuclear_smoke_devil.png",
        slayerLevel = 93,
        drops = listOf()
    ),
    venenatis(
        display = "Venenatis",
        image = "venenatis.png",
        drops = listOf()
    ),
    vetion(
        display = "Vet'ion",
        image = "vetion.png",
        drops = listOf()
    ),
    vorkath(
        display = "Vorkath",
        image = "vorkath.png",
        drops = listOf()
    ),
    zulrah(
        display = "Zulrah",
        image = "zulrah.png",
        drops = listOf()
    )

    //TODO raids 1/2
}