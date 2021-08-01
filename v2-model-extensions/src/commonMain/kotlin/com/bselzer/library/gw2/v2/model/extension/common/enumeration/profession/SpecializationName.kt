package com.bselzer.library.gw2.v2.model.extension.common.enumeration.profession

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class SpecializationName
{
    // Guardian
    @SerialName("Zeal")
    ZEAL,

    @SerialName("Radiance")
    RADIANCE,

    @SerialName("Valor")
    VALOR,

    @SerialName("Honor")
    HONOR,

    @SerialName("Virtues")
    VIRTUES,

    @SerialName("Dragonhunter")
    DRAGONHUNTER,

    @SerialName("Firebrand")
    FIREBRAND,

    // Revenant
    @SerialName("Corruption")
    CORRUPTION,

    @SerialName("Retribution")
    RETRIBUTION,

    @SerialName("Salvation")
    SALVATION,

    @SerialName("Invocation")
    INVOCATION,

    @SerialName("Devastation")
    DEVASTATION,

    @SerialName("Herald")
    HERALD,

    @SerialName("Renegade")
    RENEGADE,

    // Warrior
    @SerialName("Strength")
    STRENGTH,

    @SerialName("Arms")
    ARMS,

    @SerialName("Defense")
    DEFENSE,

    @SerialName("Tactics")
    TACTICS,

    @SerialName("Discipline")
    DISCIPLINE,

    @SerialName("Berserker")
    BERSERKER,

    @SerialName("Spellbreaker")
    SPELLBREAKER,

    // Engineer
    @SerialName("Explosives")
    EXPLOSIVES,

    @SerialName("Firearms")
    FIREARMS,

    @SerialName("Inventions")
    INVENTIONS,

    @SerialName("Alchemy")
    ALCHEMY,

    @SerialName("Tools")
    TOOLS,

    @SerialName("Scrapper")
    SCRAPPER,

    @SerialName("Holosmith")
    HOLOSMITH,

    // Ranger
    @SerialName("Marksmanship")
    MARKSMANSHIP,

    @SerialName("Skirmishing")
    SKIRMISHING,

    @SerialName("Wilderness Survival")
    WILDERNESS_SURVIVAL,

    @SerialName("Nature Magic")
    NATURE_MAGIC,

    @SerialName("Beastmastery")
    BEASTMASTERY,

    @SerialName("Druid")
    DRUID,

    @SerialName("Soulbeast")
    SOULBEAST,

    // Thief
    @SerialName("Deadly Arts")
    DEADLY_ARTS,

    @SerialName("Critical Strikes")
    CRITICAL_STRIKES,

    @SerialName("Shadow Arts")
    SHAODW_ARTS,

    @SerialName("Acrobatics")
    ACROBATICS,

    @SerialName("Trickery")
    TRICKERY,

    @SerialName("Daredevil")
    DAREDEVIL,

    @SerialName("Deadeye")
    DEADEYE,

    // Elementalist
    @SerialName("Fire")
    FIRE,

    @SerialName("Air")
    AIR,

    @SerialName("Earth")
    EARTH,

    @SerialName("Water")
    WATER,

    @SerialName("Arcane")
    ARCANE,

    @SerialName("Tempest")
    TEMPEST,

    @SerialName("Weaver")
    WEAVER,

    // Mesmer
    @SerialName("Domination")
    DOMINATION,

    @SerialName("Dueling")
    DUELING,

    @SerialName("Chaos")
    CHAOS,

    @SerialName("Inspiration")
    INSPIRATION,

    @SerialName("Illusions")
    ILLUSIONS,

    @SerialName("Chronomancer")
    CHRONOMANCER,

    @SerialName("Mirage")
    MIRAGE,

    // Necromancer
    @SerialName("Spite")
    SPITE,

    @SerialName("Curses")
    CURSES,

    @SerialName("Death Magic")
    DEATH_MAGIC,

    @SerialName("Blood Magic")
    BLOOD_MAGIC,

    @SerialName("Soul Reaping")
    SOUL_REAPING,

    @SerialName("Reaper")
    REAPER,

    @SerialName("Scourge")
    SCOURGE
}