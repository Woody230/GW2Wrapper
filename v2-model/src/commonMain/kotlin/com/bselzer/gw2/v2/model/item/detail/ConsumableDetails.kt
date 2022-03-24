package com.bselzer.gw2.v2.model.item.detail

import com.bselzer.gw2.v2.model.color.DyeColorId
import com.bselzer.gw2.v2.model.enumeration.wrapper.ConsumableDetailType
import com.bselzer.gw2.v2.model.enumeration.wrapper.ConsumableUnlockType
import com.bselzer.gw2.v2.model.guild.upgrade.GuildUpgradeId
import com.bselzer.gw2.v2.model.recipe.RecipeId
import com.bselzer.gw2.v2.model.skin.SkinId
import com.bselzer.gw2.v2.model.wrapper.ImageLink
import com.bselzer.ktx.datetime.serialization.MillisecondDurationSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.time.Duration

@Serializable
data class ConsumableDetails(
    @SerialName("type")
    val type: ConsumableDetailType = ConsumableDetailType(),

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
    val unlockType: ConsumableUnlockType? = null,

    /**
     * The id of the dye color when the [unlockType] is for a dye.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/colors">the wiki</a>
     */
    @SerialName("color_id")
    val colorId: DyeColorId = DyeColorId(),

    /**
     * The id of the recipe when the [unlockType] is for a recipe.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/recipes">the wiki</a>
     */
    @SerialName("recipe_id")
    val recipeId: RecipeId = RecipeId(),

    /**
     * The ids of the additional recipe unlocks.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/recipes">the wiki</a>
     */
    @SerialName("extra_recipe_ids")
    val extraRecipeIds: List<RecipeId> = emptyList(),

    /**
     * The id of the guild upgrade.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/upgrades">the wiki</a>
     */
    @SerialName("guild_upgrade_id")
    val guildUpgradeId: GuildUpgradeId = GuildUpgradeId(),

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
    val iconLink: ImageLink = ImageLink(),

    /**
     * The ids of the skins this item unlocks.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skins">the wiki</a>
     */
    @SerialName("skins")
    val skinIds: List<SkinId> = emptyList()
)