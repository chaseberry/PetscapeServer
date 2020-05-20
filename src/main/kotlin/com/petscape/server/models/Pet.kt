package com.petscape.server.models

import com.petscape.server.models.GameTag
import org.bson.types.ObjectId

enum class Pet(val display: String,
               val tags: List<GameTag>,
    //val boss: ?,
               val dropRate: Int,
               val image: String) {

    abyssalOrphan(
        display = "Abyssal Orphan",
        tags = listOf(),
        //boss = null,
        dropRate = 2560,
        image = "/pets/Abyssal Orphan.gif"
    ),
    babyChinchompa(
        display = "Baby Chinchompa",
        tags = listOf(),
        //boss = null,
        dropRate = 26_068_808,
        image = "/pets/Baby Chinchompa.gif"
    ),
    babyMole(
        display = "Baby Mole",
        tags = listOf(),
        //boss = null,
        dropRate = 3000,
        image = "/pets/Baby Mole.gif"
    ),
    beaver(
        display = "Beaver",
        tags = listOf(),
        //boss = null,
        dropRate = 24_975_270,
        image = "/pets/Beaver.gif"
    ),
    bloodhound(
        display = "Bloodhound",
        tags = listOf(),
        //boss = null,
        dropRate = 1000,
        image = "/pets/Bloodhound.gif"
    ),
    callistoCub(
        display = "Callisto Cub",
        tags = listOf(),
        //boss = null,
        dropRate = 2000,
        image = "/pets/Callisto Cub.gif"
    ),
    chaosElemental(
        display = "Chaos Elemental",
        tags = listOf(),
        //boss = null,
        dropRate = 300,
        image = "/pets/Chaos Elemental.gif"
    ),
    chompyChick(
        display = "Chompy Chick",
        tags = listOf(),
        //boss = null,
        dropRate = 500,
        image = "/pets/Chompy Chick.gif"
    ),
    dagannothPrime(
        display = "Dagannoth Prime",
        tags = listOf(),
        //boss = null,
        dropRate = 5000,
        image = "/pets/Dagannoth Prime.gif"
    ),
    dagannothRex(
        display = "Dagannoth Rex",
        tags = listOf(),
        //boss = null,
        dropRate = 5000,
        image = "/pets/Dagannoth Rex.gif"
    ),
    dagannothSupreme(
        display = "Dagannoth Supreme",
        tags = listOf(),
        //boss = null,
        dropRate = 5000,
        image = "/pets/Dagannoth Supreme.gif"
    ),
    darkCore(
        display = "Dark Core",
        tags = listOf(),
        //boss = null,
        dropRate = 5000,
        image = "/pets/Dark Core.gif"
    ),
    generalGraardor(
        display = "General Graardor",
        tags = listOf(),
        //boss = null,
        dropRate = 5000,
        image = "/pets/General Graardor.gif"
    ),
    giantSquirrel(
        display = "Giant Squirrel",
        tags = listOf(),
        //boss = null,
        dropRate = 16_953_400,
        image = "/pets/Giant Squirrel.gif"
    ),
    hellpuppy(
        display = "Hellpuppy",
        tags = listOf(),
        //boss = null,
        dropRate = 3000,
        image = "/pets/Hellpuppy.gif"
    ),
    herbi(
        display = "Herbi",
        tags = listOf(),
        //boss = null,
        dropRate = 6500,
        image = "/pets/Herbi.gif"
    ),
    heron(
        display = "Heron",
        tags = listOf(),
        //boss = null,
        dropRate = 17_298_423,
        image = "/pets/Heron.gif"
    ),
    ikkleHydra(
        display = "Ikkle Hydra",
        tags = listOf(),
        //boss = null,
        dropRate = 3000,
        image = "/pets/Ikkle Hydra.gif"
    ),
    jalNibRek(
        display = "Jal-Nib-Rek",
        tags = listOf(),
        //boss = null,
        dropRate = 100,
        image = "/pets/Jal-Nib-Rek.gif"
    ),
    krilTsutsaroth(
        display = "K'ril Tsutsaroth",
        tags = listOf(),
        //boss = null,
        dropRate = 5000,
        image = "/pets/K'ril Tsutsaroth.gif"
    ),
    kalphitePrincess(
        display = "Kalphite Princess",
        tags = listOf(),
        //boss = null,
        dropRate = 3000,
        image = "/pets/Kalphite Princess.gif"
    ),
    kraken(
        display = "Kraken",
        tags = listOf(),
        //boss = null,
        dropRate = 3000,
        image = "/pets/Kraken.gif"
    ),
    kreeArra(
        display = "Kree'arra",
        tags = listOf(),
        //boss = null,
        dropRate = 5000,
        image = "/pets/Kree'arra.gif"
    ),
    lilZik(
        display = "Lil' Zik",
        tags = listOf(),
        //boss = null,
        dropRate = 650,
        image = "/pets/Lil' Zik.gif"
    ),
    LittleNightmare(
        display = "Little Nightmare",
        tags = listOf(),
        //boss = null,
        dropRate = 4000,
        image = "/pets/Little Nightmare.gif"
    ),
    noon(
        display = "Noon/Midnight",
        tags = listOf(),
        //boss = null,
        dropRate = 3000,
        image = "/pets/Noon/Midnight.gif"
    ),
    olmlet(
        display = "Olmlet",
        tags = listOf(),
        //boss = null,
        dropRate = 1765,
        image = "/pets/Olmlet.gif"
    ),
    penanceQueen(
        display = "Penance Queen",
        tags = listOf(),
        //boss = null,
        dropRate = 1000,
        image = "/pets/Penance Queen.gif"
    ),
    phoenix(
        display = "Phoenix",
        tags = listOf(),
        //boss = null,
        dropRate = 5000,
        image = "/pets/Phoenix.gif"
    ),
    princeBlackDragon(
        display = "Prince Black Dragon",
        tags = listOf(),
        //boss = null,
        dropRate = 3000,
        image = "/pets/Prince Black Dragon.gif"
    ),
    riftGaurdian(
        display = "Rift Gaurdian",
        tags = listOf(),
        //boss = null,
        dropRate = 17_591_116,
        image = "/pets/Rift Gaurdian.gif"
    ),
    rockGolem(
        display = "Rock Golem",
        tags = listOf(),
        //boss = null,
        dropRate = 18_893_148,
        image = "/pets/Rock Golem.gif"
    ),
    rocky(
        display = "Rocky",
        tags = listOf(),
        //boss = null,
        dropRate = 17_851_931,
        image = "/pets/Rocky.gif"
    ),
    scorpiasOffspring(
        display = "Scorpia's Offspring",
        tags = listOf(),
        //boss = null,
        dropRate = 2016,
        image = "/pets/Scorpia's Offspring.gif"
    ),
    skotos(
        display = "Skotos",
        tags = listOf(),
        //boss = null,
        dropRate = 65,
        image = "/pets/Skotos.gif"
    ),
    smokeDevil(
        display = "Smoke Devil",
        tags = listOf(),
        //boss = null,
        dropRate = 3000,
        image = "/pets/Smoke Devil.gif"
    ),
    smolcano(
        display = "Smolcano",
        tags = listOf(),
        //boss = null,
        dropRate = 4000,
        image = "/pets/Smolcano.gif"
    ),
    snakeling(
        display = "Snakeling",
        tags = listOf(),
        //boss = null,
        dropRate = 4000,
        image = "/pets/Snakeling.gif"
    ),
    srarcha(
        display = "Srarcha",
        tags = listOf(),
        //boss = null,
        dropRate = 3000,
        image = "/pets/Srarcha.gif"
    ),
    tangleroot(
        display = "Tangleroot",
        tags = listOf(),
        //boss = null,
        dropRate = 60_000_000,
        image = "/pets/Tangleroot.gif"
    ),
    tzrekJad(
        display = "Tzrek-Jad",
        tags = listOf(),
        //boss = null,
        dropRate = 100,
        image = "/pets/Tzrek-Jad.gif"
    ),
    venenatisSpiderling(
        display = "Venenatis SPiderling",
        tags = listOf(),
        //boss = null,
        dropRate = 2000,
        image = "/pets/Venenatis SPiderling.gif"
    ),
    vetionJr(
        display = "Vet'ion Jr.",
        tags = listOf(),
        //boss = null,
        dropRate = 2000,
        image = "/pets/Vet'ion Jr..gif"
    ),
    vorki(
        display = "Vorki",
        tags = listOf(),
        //boss = null,
        dropRate = 3000,
        image = "/pets/Vorki.gif"
    ),
    youngllef(
        display = "Youngllef",
        tags = listOf(),
        //boss = null,
        dropRate = 800,
        image = "/pets/Youngllef.gif"
    ),
    zilyana(
        display = "Zilyana",
        tags = listOf(),
        //boss = null,
        dropRate = 5000,
        image = "/pets/Zilyana.gif"
    )

}