package com.bselzer.gw2.v2.model.recipe.ingredient

import com.bselzer.gw2.v2.model.guild.upgrade.GuildUpgradeId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GuildRecipeIngredient(
    /**
     * The id of the ingredient guild upgrade.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/upgrades">the wiki</a>
     */
    @SerialName("upgrade_id")
    val upgradeId: GuildUpgradeId = GuildUpgradeId(),

    /**
     * The number of the upgrade associated with the [upgradeId] required.
     */
    @SerialName("count")
    val count: Int = 0
)