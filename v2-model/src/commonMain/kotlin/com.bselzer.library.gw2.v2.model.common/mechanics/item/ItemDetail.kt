package com.bselzer.library.gw2.v2.model.common.mechanics.item

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ItemDetail(
    @SerialName("type")
    val type: String = "",

    // Consumable
    @SerialName("description")
    val effectDescription: String = "",

    @SerialName("duration_ms")
    val effectDuration: Long = 0, // In milliseconds

    @SerialName("color_id")
    val unlockedColorIds: Int = 0,

    @SerialName("recipe_id")
    val unlockedRecipeIds: Int = 0,

    @SerialName("extra_recipe_ids")
    val extraUnlockedRecipeIds: List<Int> = emptyList(),

    @SerialName("guild_upgrade_id")
    val guildUpgradeId: Int = 0,

    @SerialName("apply_count")
    val stacksApplied: Int = 0,

    @SerialName("name")
    val effectName: String = "",

    @SerialName("icon")
    val effectIconLink: String = "",

    @SerialName("skins")
    val unlockedSkinIds: List<Int> = emptyList(),

    // Upgrade component
    @SerialName("flags")
    val upgradableItemTypes: List<String> = emptyList(),

    @SerialName("infusion_upgrade_flags")
    val usableInfusionSlots: List<String> = emptyList(),

    @SerialName("suffix")
    val suffix: String = "",

    @SerialName("infix_upgrade")
    val infixUpgrade: InfixUpgrade = InfixUpgrade(),

    // Runes use this instead of InfixUpgrade's InfixBuff object.
    @SerialName("bonuses")
    val bonuses: List<String> = emptyList()
)