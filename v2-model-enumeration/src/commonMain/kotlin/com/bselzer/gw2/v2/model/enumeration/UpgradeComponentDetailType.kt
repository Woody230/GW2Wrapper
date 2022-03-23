package com.bselzer.gw2.v2.model.enumeration

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class UpgradeComponentDetailType {
    /**
     * For infusions, jewels, and historical PvP runes/sigils
     */
    @SerialName("Default")
    DEFAULT,

    /**
     * For gemstones, crests, and doubloons
     */
    @SerialName("Gem")
    UNIVERSAL_UPGRADE,

    @SerialName("Rune")
    RUNE,

    @SerialName("Sigil")
    SIGIL,
}