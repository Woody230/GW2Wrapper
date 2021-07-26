package com.bselzer.library.gw2.model.extension.common.enumerations.skill

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class SkillCategory
{
    @SerialName("Physical")
    PHYSICAL,

    @SerialName("Glyph")
    GLYPH,

    @SerialName("Signet")
    SIGNET,

    @SerialName("Shout")
    SHOUT,

    @SerialName("Well")
    WELL,

    @SerialName("Consecration")
    CONSECRATION,

    @SerialName("Meditation")
    MEDITATION,

    @SerialName("SpiritWeapon")
    SPIRIT_WEAPON,

    @SerialName("Symbol")
    SYMBOL,

    @SerialName("Virtue")
    VIRTUE,

    @SerialName("Ward")
    WARD,

    @SerialName("Legend")
    LEGEND,

    @SerialName("LegendaryAssassin")
    LEGENDARY_ASSASSIN,

    @SerialName("LegendaryCentaur")
    LEGNEDARY_CENTAUR,

    @SerialName("LegendaryDemon")
    LEGENDARY_DEMON,

    @SerialName("LegendaryDragon")
    LEGENDARY_DRAGON,

    @SerialName("LegendaryDwarf")
    LEGENDARY_DWARF,

    @SerialName("Banner")
    BANNER,

    @SerialName("Burst")
    BURST,

    @SerialName("PrimalBurst")
    PRIMAL_BURST,

    @SerialName("Rage")
    RAGE,

    @SerialName("Stance")
    STANCE,

    @SerialName("kit")
    TOOLKIT,

    @SerialName("Elixir")
    ELIXIR,

    @SerialName("Gadget")
    GADGET,

    @SerialName("Gyro")
    GYRO,

    @SerialName("Turret")
    TURRET,

    @SerialName("CelestialAvatar")
    CELESTIAL_AVATAR,

    @SerialName("Pet")
    PET,

    @SerialName("Spirit")
    SPIRIT,

    @SerialName("Survival")
    SURVIVAL,

    @SerialName("Deception")
    DECEPTION,

    @SerialName("DualWield")
    DUAL_WIELD,

    @SerialName("StealthAttack")
    STEALTH_ATTACK,

    @SerialName("Trick")
    TRICK,

    @SerialName("Venom")
    VENOM,

    @SerialName("Arcane")
    ARCANE,

    @SerialName("Cantrip")
    CANTRIP,

    @SerialName("Conjure")
    CONJURE,

    @SerialName("Overload")
    OVERLOAD,

    @SerialName("Clone")
    CLONE,

    @SerialName("Glamour")
    GLAMOUR,

    @SerialName("Manipulation")
    MANIPULATION,

    @SerialName("Mantra")
    MANTRA,

    @SerialName("Phantasm")
    PHANTASM,

    @SerialName("Corruption")
    CORRUPTION,

    @SerialName("Mark")
    MARK,

    @SerialName("Minion")
    MINION,

    @SerialName("Spectral")
    SPECTRAL,

    @SerialName("Transform")
    TRANSFORM,

    @SerialName("Kit")
    KIT,

    @SerialName("Trap")
    TRAP
}