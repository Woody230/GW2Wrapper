package com.bselzer.gw2.v2.model.guild.log

import com.bselzer.gw2.v2.model.enumeration.wrapper.UpgradeAction
import com.bselzer.gw2.v2.model.item.ItemId
import com.bselzer.gw2.v2.model.recipe.RecipeId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("upgrade")
data class UpgradeLog(
    /**
     * The type of interaction.
     */
    @SerialName("action")
    val action: UpgradeAction = UpgradeAction(),

    /**
     * The id of the upgrade.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/upgrades">the wiki</a>
     */
    @SerialName("upgrade_id")
    val upgradeId: ItemId = ItemId(),

    /**
     * The id of the recipe.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/recipes">the wiki</a>
     */
    @SerialName("recipe_id")
    val recipeId: RecipeId = RecipeId(),

    /**
     * The number of upgrades.
     */
    @SerialName("count")
    val count: Int = 0
) : GuildLog()