package com.bselzer.gw2.v2.model.recipe.ingredient

import com.bselzer.gw2.v2.model.guild.upgrade.GuildUpgradeId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("GuildUpgrade")
data class GuildUpgradeRecipeIngredient(
    /**
     * The id of the ingredient guild upgrade.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/upgrades">the wiki</a>
     */
    @SerialName("id")
    override val id: GuildUpgradeId = GuildUpgradeId(),
) : RecipeIngredient<GuildUpgradeId>()