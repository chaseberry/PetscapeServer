package com.petscape.server.models

import com.fasterxml.jackson.annotation.JsonProperty

enum class Boss(val display: String,
                val image: String,
                val wilderness: Boolean = false,
                val slayerLevel: Int? = null,
                val drops: List<Drop>) {

    //TODO how to deal with gauntlet and its weird drop rates

    //  \{\n.*: (".*"),\n.*: (".*"),\n.*: (\d+)\n\s+\}
    //  Drop($1, $2, $3)
    abyssalSire(
        display = "Abyssal Sire",
        image = "abyssal_sire.png",
        slayerLevel = 85,
        drops = listOf(
            Drop("Abyssal Bludgeon", "abyssal_bludgeon.png", 206),
            Drop("Abyssal Dagger", "abyssal_dagger.png", 492),
            Drop("Abyssal Head", "abyssal_head.png", 1280),
            Drop("Abyssal Whip", "abyssal_whip.png", 1066),
            Drop("Clue Scroll (Elite)", "clue_scroll_elite.png", 180),
            Drop("Jar of Miasma", "jar_of_miasma.png", 984),
            Drop("Abyssal Orphan", "abyssal_orphan.png", 2560)
        )
    ),
    alchemicalHydra(
        display = "Alchemical Hydra",
        image = "alchemical_hydra.png",
        slayerLevel = 95,
        drops = listOf(
            Drop("Alchemical Hydra Heads", "alchemical_hydra_heads.png", 256),
            Drop("Brimstone Ring", "brimstone_ring.png", 180),
            Drop("Hydra Leather", "hydra_leather.png", 512),
            Drop("Hydra Tail", "hydra_tail.png", 512),
            Drop("Hydra's Claw", "hydras_claw.png", 1000),
            Drop("Clue Scroll (Elite)", "clue_scroll_elite.png", 256),
            Drop("Jar of Chemicals", "jar_of_chemicals.png", 2000),
            Drop("Ikkle Hydra", "ikkle_hydra.png", 3000)
        )
    ),
    callisto(
        display = "Callisto",
        image = "callisto.png",
        drops = listOf(
            Drop("Tyrannical Ring", "tyrannical_ring.png", 512),
            Drop("Dragon 2h Sword", "dragon_2h_sword.png", 256),
            Drop("Dragon Pickaxe", "dragon_pickaxe.png", 171),
            Drop("Clue Scroll (Elite)", "clue_scroll_elite.png", 100),
            Drop("Callisto Cub", "callisto_cub.png", 2000)
        )
    ),
    cerberus(
        display = "Cerberus",
        image = "cerberus.png",
        slayerLevel = 91,
        drops = listOf(
            Drop("Primordial Crystal", "primordial_crystal.png", 512),
            Drop("Pegasian Crystal", "pegasian_crystal.png", 512),
            Drop("Eternal Crystal", "eternal_crystal.png", 512),
            Drop("Smouldering Stone", "smouldering_stone.png", 512),
            Drop("Clue Scroll (Elite)", "clue_scroll_elite.png", 100),
            Drop("Jar of Souls", "jar_of_souls.png", 2000),
            Drop("Hellpuppy", "hellpuppy.png", 3000)
        )
    ),
    chaosElemental(
        display = "Chaos Elemental",
        image = "chaos_elemental.png",
        wilderness = true,
        drops = listOf(
            Drop("Dragon 2h Sword", "dragon_2h_sword.png", 128),
            Drop("Dragon Pickaxe", "dragon_pickaxe.png", 128),
            Drop("Clue Scroll (Elite)", "clue_scroll_elite.png", 200),
            Drop("Chaos Elemental Jr.", "chaos_elemental_jr.png", 300)
        )
    ),
    //TODO chaos Fanatic/chaos Archaeologist?
    commanderZilyana(
        display = "Commander Zilyana",
        image = "zilyana.png",
        drops = listOf(
            Drop("Saradomin Hilt", "saradomin_hilt.png", 508),
            Drop("Saradomin Sword", "saradomin_sword.png", 127),
            Drop("Armadyl Crossbow", "armadyl_crossbow.png", 508),
            Drop("Saradomin's Light", "saradomins_light.png", 254),
            Drop("Zilyana Jr.", "zilyana_jr.png", 5000),
            Drop("Clue Scroll (Elite)", "clue_scroll_elite.png", 250)
        )
    ),
    corporealBeast(
        display = "Corporeal Beast",
        image = "corporeal_beast.png",
        drops = listOf(
            Drop("Clue Scroll (Elite)", "clue_scroll_elite.png", 200),
            Drop("Arcane Sigil", "arcane_sigil.png", 1365),
            Drop("Elysian Sigil", "elysian_sigil.png", 4095),
            Drop("Holy Elixir", "holy_elixir.png", 170),
            Drop("Pet Dark Core", "pet_dark_core.png", 5000),
            Drop("Spectral Sigil", "spectral_sigil.png", 1365),
            Drop("Spirit Shield", "spirit_shield.png", 64)
        )
    ),
    dagannothPrime(
        display = "Dagannoth Prime",
        image = "dagannoth_prime.png",
        drops = listOf(
            Drop("Seers Ring", "seers_ring.png", 128),
            Drop("Mud Battlestaff", "mud_battlestaff.png", 128),
            Drop("Dragon Axe", "dragon_axe.png", 128),
            Drop("Clue Scroll (Elite)", "clue_scroll_elite.png", 750),
            Drop("Dagannoth Prime Jr.", "dagannoth_prime_jr.png", 5000)
        )
    ),
    dagannothRex(
        display = "Dagannoth Rex",
        image = "dagannoth_rex.png",
        drops = listOf(
            Drop("Warrior Ring", "warrior_ring.png", 128),
            Drop("Berserker Ring", "berserker_ring.png", 128),
            Drop("Dragon Axe", "dragon_axe.png", 128),
            Drop("Clue Scroll (Elite)", "clue_scroll_elite.png", 750),
            Drop("Dagannoth Rex Jr.", "dagannoth_rex_jr.png", 5000)
        )
    ),
    dagannothSupreme(
        display = "Dagannoth Supreme",
        image = "dagannoth_supreme.png",
        drops = listOf(
            Drop("Seercull", "seercull.png", 128),
            Drop("Archers Ring", "archers_ring.png", 128),
            Drop("Dragon Axe", "dragon_axe.png", 128),
            Drop("Clue Scroll (Elite)", "clue_scroll_elite.png", 750),
            Drop("Dagannoth Supreme Jr.", "dagannoth_supreme_jr.png", 5000)
        )
    ),
    generalGraardor(
        display = "General Graardor",
        image = "graardor.png",
        drops = listOf(
            Drop("Bandos Hilt", "bandos_hilt.png", 508),
            Drop("Bandos Boots", "bandos_boots.png", 384),
            Drop("Bandos Chestplate", "bandos_chestplate.png", 384),
            Drop("Bandos Tassets", "bandos_tassets.png", 384),
            Drop("General Graardor Jr.", "general_graardor_jr.png", 5000),
            Drop("Clue Scroll (Elite)", "clue_scroll_elite.png", 250)
        )
    ),
    //TODO Giant Mole
    grotesqueGuardians(
        display = "Grotesque Guardians",
        image = "grotesque_guardians.png",
        slayerLevel = 75,
        drops = listOf(
            Drop("Granite Gloves", "granite_gloves.png", 500),
            Drop("Granite Ring", "granite_ring.png", 500),
            Drop("Black Tourmaline Core", "black_tourmaline_core.png", 1000),
            Drop("Granite Hammer", "granite_hammer.png", 750),
            Drop("Clue Scroll (Elite)", "clue_scroll_elite.png", 230),
            Drop("Jar of Stone", "jar_of_stone.png", 5000),
            Drop("Noon", "noon.png", 3000)
        )
    ),
    kalphiteQueen(
        display = "Kalphite Queen",
        image = "kalphite_queen.png",
        drops = listOf(
            Drop("Dragon Chainbody", "dragon_chainbody.png", 128),
            Drop("Dragon 2h Sword", "dragon_2h_sword.png", 256),
            Drop("KQ Head", "kq_head.png", 128),
            Drop("Kalphite Princess", "kalphite_princess.png", 3000),
            Drop("Clue Scroll (Elite)", "clue_scroll_elite.png", 100),
            Drop("Jar of Sand", "jar_of_sand.png", 2000)
        )
    ),
    kingBlackDragon(
        display = "King Black Dragon",
        image = "king_black_dragon.png",
        drops = listOf(
            Drop("Dragon Pickaxe", "dragon_pickaxe.png", 1500),
            Drop("KBD Heads", "kbd_heads.png", 128),
            Drop("Clue Scroll (Elite)", "clue_scroll_elite.png", 450),
            Drop("Prince Black Dragon", "prince_black_dragon.png", 3000),
            Drop("Draconic Visage", "draconic_visage.png", 5000)
        )
    ),
    kraken(
        display = "Kraken",
        image = "kraken.png",
        slayerLevel = 87,
        drops = listOf(
            Drop("Kraken Tentacle", "kraken_tentacle.png", 300),
            Drop("Trident of the Seas", "trident_of_the_seas.png", 512),
            Drop("Clue Scroll (Elite)", "clue_scroll_elite.png", 500),
            Drop("Jar of Dirt", "jar_of_dirt.png", 1000),
            Drop("Pet Kraken", "pet_kraken.png", 3000)
        )
    ),
    kreeArra(
        display = "Kree'Arra",
        image = "kreearra.png",
        drops = listOf(
            Drop("Armadyl Hilt", "armadyl_hilt.png", 508),
            Drop("Armadyl Helmet", "armadyl_helmet.png", 508),
            Drop("Armadyl Chestplate", "armadyl_chestplate.png", 384),
            Drop("Armadyl Chainskirt", "armadyl_chainskirt.png", 384),
            Drop("Kree'Arra Jr.", "kree_arra_jr.png", 5000),
            Drop("Clue Scroll (Elite)", "clue_scroll_elite.png", 250)
        )
    ),
    krilTsutsaroth(
        display = "Kril Tsutsaroth",
        image = "kril_tsutsaroth.png",
        drops = listOf(
            Drop("Staff of the Dead", "staff_of_the_dead.png", 508),
            Drop("Zamorak Hilt", "zamorak_hilt.png", 508),
            Drop("Steam Battlestaff", "steam_battlestaff.png", 128),
            Drop("Zamorakian Spear", "zamorakian_spear.png", 128),
            Drop("Kril Tsutsaroth Jr.", "kril_tsutsaroth_jr.png", 5000),
            Drop("Clue Scroll (Elite)", "clue_scroll_elite.png", 250)
        )
    ),
    nightmare(
        display = "The Nightmare",
        image = "",
        drops = listOf()
    ),
    sarachnis(
        display = "Sarachnis",
        image = "sarachnis.png",
        drops = listOf(
            Drop("Jar of Eyes", "jar_of_eyes.png", 0),
            Drop("Sarachnis Cudgel", "sarachnis_cudgel.png", 0),
            Drop("Sraracha", "sraracha.png", 0),
            Drop("Clue Scroll (Elite)", "clue_scroll_elite.png", 0)
        )
    ),
    scopria(
        display = "Scoripia",
        image = "scorpia.png",
        wilderness = true,
        drops = listOf(
            Drop("Malediction Shard 3", "malediction_shard_3.png", 256),
            Drop("Odium Shard 3", "odium_shard_3.png", 256),
            Drop("Scorpia's Offspring", "scorpias_offspring.png", 2000)
        )
    ),
    //TODO skotizo?
    thermonuclearSmokeDevil(
        display = "Thermonuclear Smoke Devil",
        image = "thermonuclear_smoke_devil.png",
        slayerLevel = 93,
        drops = listOf(
            Drop("Smoke Battlestaff", "smoke_battlestaff.png", 512),
            Drop("Occult Necklace", "occult_necklace.png", 350),
            Drop("Dragon Chainbody", "dragon_chainbody.png", 2000),
            Drop("Clue Scroll (Elite)", "clue_scroll_elite.png", 500),
            Drop("Pet Smoke Devil", "pet_smoke_devil.png", 3000)
        )
    ),
    venenatis(
        display = "Venenatis",
        image = "venenatis.png",
        drops = listOf(
            Drop("Treasonous Ring", "treasonous_ring.png", 512),
            Drop("Dragon 2h Sword", "dragon_2h_sword.png", 256),
            Drop("Dragon Pickaxe", "dragon_pickaxe.png", 171),
            Drop("Venenatis Spiderling", "venenatis_spiderling.png", 2000),
            Drop("Clue Scroll (Elite)", "clue_scroll_elite.png", 100)
        )
    ),
    vetion(
        display = "Vet'ion",
        image = "vetion.png",
        drops = listOf(
            Drop("Ring of the Gods", "ring_of_the_gods.png", 512),
            Drop("Dragon 2h Sword", "dragon_2h_sword.png", 256),
            Drop("Dragon Pickaxe", "dragon_pickaxe.png", 171),
            Drop("Clue Scroll (Elite)", "clue_scroll_elite.png", 100),
            Drop("Vet'ion Jr.", "vetion_jr.png", 2000)
        )
    ),
    vorkath(
        display = "Vorkath",
        image = "vorkath.png",
        drops = listOf(
            Drop("Dragonbone Necklace", "dragonbone_necklace.png", 1000),
            Drop("Clue Scroll (Elite)", "clue_scroll_elite.png", 65),
            Drop("Jar of Decay", "jar_of_decay.png", 3000),
            Drop("Vorki", "vorki.png", 3000)
        )
    ),
    zulrah(
        display = "Zulrah",
        image = "zulrah.png",
        drops = listOf(
            Drop("Uncut Onyx", "uncut_onyx.png", 512),
            Drop("Tanzanite Fang", "tanzanite_fang.png", 512),
            Drop("Magic Fang", "magic_fang.png", 512),
            Drop("Serpentine Visage", "serpentine_visage.png", 512),
            Drop("Clue Scroll (Elite)", "clue_scroll_elite.png", 75),
            Drop("Jar of Swamp", "jar_of_swamp.png", 3000),
            Drop("Pet snakeling", "pet_snakeling.png", 4000)
        )
    )

    //TODO raids 1/2
    //TODO Wintertodt - tagged as minigame
}