package com.bselzer.library.gw2.v2.model.guild.log

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("upgrade")
data class UpgradeLog(
    /**
     * The type of interaction.
     */
    @SerialName("action")
    val action: String = "",

    /**
     * The id of the upgrade.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/upgrades">the wiki</a>
     */
    @SerialName("upgrade_id")
    val upgradeId: Int = 0,

    /**
     * The id of the recipe.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/recipes">the wiki</a>
     */
    @SerialName("recipe_id")
    val recipeId: Int = 0,

    /**
     * The number of upgrades.
     */
    @SerialName("count")
    val count: Int = 0
) : GuildLog()