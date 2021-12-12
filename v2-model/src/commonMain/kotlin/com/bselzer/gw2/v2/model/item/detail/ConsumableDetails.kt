package com.bselzer.gw2.v2.model.item.detail

import com.bselzer.ktx.datetime.serialization.MillisecondDurationSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
@Serializable
data class ConsumableDetails(
    @SerialName("type")
    val type: String = "",

    @SerialName("description")
    val description: String = "",

    @Serializable(with = MillisecondDurationSerializer::class)
    @SerialName("duration_ms")
    val duration: Duration = Duration.ZERO,

    /**
     * The unlock type for unlockable consumables.
     *
     * Null if this consumable is not unlockable.
     */
    @SerialName("unlock_type")
    val unlockType: String? = null,

    /**
     * The id of the dye color when the [unlockType] is for a dye.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/colors">the wiki</a>
     */
    @SerialName("color_id")
    val colorId: Int = 0,

    /**
     * The id of the recipe when the [unlockType] is for a recipe.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/recipes">the wiki</a>
     */
    @SerialName("recipe_id")
    val recipeId: Int = 0,

    /**
     * The ids of the additional recipe unlocks.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/recipes">the wiki</a>
     */
    @SerialName("extra_recipe_ids")
    val extraRecipeIds: List<Int> = emptyList(),

    /**
     * The id of the guild upgrade.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/upgrades">the wiki</a>
     */
    @SerialName("guild_upgrade_id")
    val guildUpgradeId: Int = 0,

    /**
     * The number of stacks of the effect applied by this item.
     */
    @SerialName("apply_count")
    val applyCount: Int = 0,

    /**
     * The effect type name.
     */
    @SerialName("name")
    val name: String = "",

    /**
     * The link to the effect icon.
     */
    @SerialName("icon")
    val iconLink: String = "",

    /**
     * The ids of the skins this item unlocks.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skins">the wiki</a>
     */
    @SerialName("skins")
    val skinIds: List<Int> = emptyList()
)