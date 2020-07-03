package com.petscape.server.models

import com.petscape.server.models.GameTag.*

enum class Pet(val display: String,
               val tags: List<GameTag>,
               val boss: Boss? = null,
               val dropRate: Int,
               val image: String) {

    abyssalOrphan(
        display = "Abyssal Orphan",
        tags = listOf(pvm, boss, slayer),
        boss = Boss.abyssalSire,
        dropRate = 2560,
        image = "/pets/Abyssal Orphan.gif"
    ),
    babyChinchompa(
        display = "Baby Chinchompa",
        tags = listOf(skilling),
        dropRate = 26_068_808,
        image = "/pets/Baby Chinchompa.gif"
    ),
    babyMole(
        display = "Baby Mole",
        tags = listOf(pvm, boss),
        boss = null,
        dropRate = 3000,
        image = "/pets/Baby Mole.gif"
    ),
    beaver(
        display = "Beaver",
        tags = listOf(skilling),
        dropRate = 24_975_270,
        image = "/pets/Beaver.gif"
    ),
    bloodhound(
        display = "Bloodhound",
        tags = listOf(other),
        dropRate = 1000,
        image = "/pets/Bloodhound.gif"
    ),
    callistoCub(
        display = "Callisto Cub",
        tags = listOf(pvm, boss, wildy),
        boss = Boss.callisto,
        dropRate = 2000,
        image = "/pets/Callisto Cub.gif"
    ),
    chaosElemental(
        display = "Chaos Elemental",
        tags = listOf(pvm, boss, wildy),
        boss = Boss.chaosElemental,
        dropRate = 300,
        image = "/pets/Chaos Elemental.gif"
    ),
    chompyChick(
        display = "Chompy Chick",
        tags = listOf(other),
        dropRate = 500,
        image = "/pets/Chompy Chick.gif"
    ),
    dagannothPrime(
        display = "Dagannoth Prime",
        tags = listOf(pvm, boss),
        boss = Boss.dagannothPrime,
        dropRate = 5000,
        image = "/pets/Dagannoth Prime.gif"
    ),
    dagannothRex(
        display = "Dagannoth Rex",
        tags = listOf(pvm, boss),
        boss = Boss.dagannothRex,
        dropRate = 5000,
        image = "/pets/Dagannoth Rex.gif"
    ),
    dagannothSupreme(
        display = "Dagannoth Supreme",
        tags = listOf(pvm, boss),
        boss = Boss.dagannothSupreme,
        dropRate = 5000,
        image = "/pets/Dagannoth Supreme.gif"
    ),
    darkCore(
        display = "Dark Core",
        tags = listOf(pvm, boss),
        boss = Boss.corporealBeast,
        dropRate = 5000,
        image = "/pets/Dark Core.gif"
    ),
    generalGraardor(
        display = "General Graardor",
        tags = listOf(pvm, boss),
        boss = Boss.generalGraardor,
        dropRate = 5000,
        image = "/pets/General Graardor.gif"
    ),
    giantSquirrel(
        display = "Giant Squirrel",
        tags = listOf(skilling),
        dropRate = 16_953_400,
        image = "/pets/Giant Squirrel.gif"
    ),
    hellpuppy(
        display = "Hellpuppy",
        tags = listOf(pvm, boss, slayer),
        boss = Boss.cerberus,
        dropRate = 3000,
        image = "/pets/Hellpuppy.gif"
    ),
    herbi(
        display = "Herbi",
        tags = listOf(skilling),
        dropRate = 6500,
        image = "/pets/Herbi.gif"
    ),
    heron(
        display = "Heron",
        tags = listOf(skilling),
        dropRate = 17_298_423,
        image = "/pets/Heron.gif"
    ),
    ikkleHydra(
        display = "Ikkle Hydra",
        tags = listOf(pvm, boss, slayer),
        boss = Boss.alchemicalHydra,
        dropRate = 3000,
        image = "/pets/Ikkle Hydra.gif"
    ),
    jalNibRek(
        display = "Jal-Nib-Rek",
        tags = listOf(pvm, boss),
        boss = null,
        dropRate = 100,
        image = "/pets/Jal-Nib-Rek.gif"
    ),
    krilTsutsaroth(
        display = "K'ril Tsutsaroth",
        tags = listOf(pvm, boss),
        boss = Boss.krilTsutsaroth,
        dropRate = 5000,
        image = "/pets/K'ril Tsutsaroth.gif"
    ),
    kalphitePrincess(
        display = "Kalphite Princess",
        tags = listOf(pvm, boss),
        boss = Boss.kalphiteQueen,
        dropRate = 3000,
        image = "/pets/Kalphite Princess.gif"
    ),
    kraken(
        display = "Kraken",
        tags = listOf(pvm, boss, slayer),
        boss = Boss.kraken,
        dropRate = 3000,
        image = "/pets/Kraken.gif"
    ),
    kreeArra(
        display = "Kree'arra",
        tags = listOf(pvm, boss),
        boss = Boss.kreeArra,
        dropRate = 5000,
        image = "/pets/Kree'arra.gif"
    ),
    lilZik(
        display = "Lil' Zik",
        tags = listOf(pvm, raids),
        boss = null,
        dropRate = 650,
        image = "/pets/Lil' Zik.gif"
    ),
    littleNightmare(
        display = "Little Nightmare",
        tags = listOf(pvm, boss),
        boss = Boss.nightmare,
        dropRate = 4000,
        image = "/pets/Little Nightmare.gif"
    ),
    noon(
        display = "Noon/Midnight",
        tags = listOf(pvm, boss, slayer),
        boss = Boss.grotesqueGuardians,
        dropRate = 3000,
        image = "/pets/Noon/Midnight.gif"
    ),
    olmlet(
        display = "Olmlet",
        tags = listOf(pvm, raids),
        boss = null,
        dropRate = 1765,
        image = "/pets/Olmlet.gif"
    ),
    penanceQueen(
        display = "Penance Queen",
        tags = listOf(minigame),
        dropRate = 1000,
        image = "/pets/Penance Queen.gif"
    ),
    phoenix(
        display = "Phoenix",
        tags = listOf(minigame),
        boss = null,
        dropRate = 5000,
        image = "/pets/Phoenix.gif"
    ),
    princeBlackDragon(
        display = "Prince Black Dragon",
        tags = listOf(pvm, boss),
        boss = Boss.kingBlackDragon,
        dropRate = 3000,
        image = "/pets/Prince Black Dragon.gif"
    ),
    riftGaurdian(
        display = "Rift Gaurdian",
        tags = listOf(skilling),
        dropRate = 17_591_116,
        image = "/pets/Rift Gaurdian.gif"
    ),
    rockGolem(
        display = "Rock Golem",
        tags = listOf(skilling),
        dropRate = 18_893_148,
        image = "/pets/Rock Golem.gif"
    ),
    rocky(
        display = "Rocky",
        tags = listOf(skilling),
        dropRate = 17_851_931,
        image = "/pets/Rocky.gif"
    ),
    scorpiasOffspring(
        display = "Scorpia's Offspring",
        tags = listOf(pvm, boss, wildy),
        boss = Boss.scopria,
        dropRate = 2016,
        image = "/pets/Scorpia's Offspring.gif"
    ),
    skotos(
        display = "Skotos",
        tags = listOf(pvm, boss),
        boss = null,
        dropRate = 65,
        image = "/pets/Skotos.gif"
    ),
    smokeDevil(
        display = "Smoke Devil",
        tags = listOf(pvm, boss, slayer),
        boss = Boss.thermonuclearSmokeDevil,
        dropRate = 3000,
        image = "/pets/Smoke Devil.gif"
    ),
    smolcano(
        display = "Smolcano",
        tags = listOf(minigame),
        boss = null,
        dropRate = 4000,
        image = "/pets/Smolcano.gif"
    ),
    snakeling(
        display = "Snakeling",
        tags = listOf(pvm, boss),
        boss = Boss.zulrah,
        dropRate = 4000,
        image = "/pets/Snakeling.gif"
    ),
    srarcha(
        display = "Srarcha",
        tags = listOf(pvm, boss),
        boss = Boss.sarachnis,
        dropRate = 3000,
        image = "/pets/Srarcha.gif"
    ),
    tangleroot(
        display = "Tangleroot",
        tags = listOf(skilling),
        dropRate = 60_000_000,
        image = "/pets/Tangleroot.gif"
    ),
    tzrekJad(
        display = "Tzrek-Jad",
        tags = listOf(pvm, boss),
        boss = null,
        dropRate = 100,
        image = "/pets/Tzrek-Jad.gif"
    ),
    venenatisSpiderling(
        display = "Venenatis Spiderling",
        tags = listOf(pvm, boss, wildy),
        boss = Boss.venenatis,
        dropRate = 2000,
        image = "/pets/Venenatis SPiderling.gif"
    ),
    vetionJr(
        display = "Vet'ion Jr.",
        tags = listOf(pvm, boss, wildy),
        boss = Boss.vetion,
        dropRate = 2000,
        image = "/pets/Vet'ion Jr..gif"
    ),
    vorki(
        display = "Vorki",
        tags = listOf(pvm, boss),
        boss = Boss.vorkath,
        dropRate = 3000,
        image = "/pets/Vorki.gif"
    ),
    youngllef(
        display = "Youngllef",
        tags = listOf(pvm, boss),
        boss = null,
        dropRate = 800,
        image = "/pets/Youngllef.gif"
    ),
    zilyana(
        display = "Zilyana",
        tags = listOf(pvm, boss),
        boss = Boss.commanderZilyana,
        dropRate = 5000,
        image = "/pets/Zilyana.gif"
    )

}