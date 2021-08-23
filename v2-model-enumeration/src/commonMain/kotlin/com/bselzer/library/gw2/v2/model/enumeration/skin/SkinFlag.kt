package com.bselzer.library.gw2.v2.model.enumeration.skin

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class SkinFlag
{
    /**
     * Displayable in the account wardrobe.
     */
    @SerialName("ShowInWardrobe")
    SHOW_IN_WARDROBE,

    /**
     * A transmutation charge is not required to apply the skin.
     */
    @SerialName("NoCost")
    NO_COST,

    /**
     * The skin is hidden until it is unlocked.
     */
    @SerialName("HideIfLocked")
    HIDE_IF_LOCKED,

    /**
     * The skin overrides rarity when it is applied.
     */
    @SerialName("OverrideRarity")
    OVERRIDE_RARITY
}