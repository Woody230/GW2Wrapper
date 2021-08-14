package com.bselzer.library.gw2.v2.model.common.recipe

import com.bselzer.library.gw2.v2.model.common.extension.serialization.MillisecondDurationSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
@Serializable
data class Recipe(
    @SerialName("id")
    val id: Int = 0,

    @SerialName("type")
    val type: String = "",

    /**
     * The id of the item produced by this recipe.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    @SerialName("output_item_id")
    val outputItemId: Int = 0,

    /**
     * The number of the item associated with the [outputItemId] produced.
     */
    @SerialName("output_item_count")
    val outputItemCount: Int = 0,

    /**
     * The time required to craft the item(s) in milliseconds.
     */
    @Serializable(with = MillisecondDurationSerializer::class)
    @SerialName("time_to_craft_ms")
    val timeToCraft: Duration = Duration.ZERO,

    /**
     * The names of the crafting disciplines that can use this recipe.
     */
    @SerialName("disciplines")
    val disciplines: List<String> = emptyList(),

    /**
     * The minimum crafting discipline level required to craft this recipe.
     */
    @SerialName("min_rating")
    val minRating: Int = 0,

    @SerialName("flags")
    val flags: List<String> = emptyList(),

    /**
     * The ingredients required in the recipe.
     */
    @SerialName("ingredients")
    val ingredients: List<RecipeIngredient> = emptyList(),

    /**
     * The ingredients required in the recipe that come from the guild.
     */
    @SerialName("guild_ingredients")
    val guildIngredients: List<GuildRecipeIngredient> = emptyList(),

    /**
     * The id of the guild upgrade produced by the recipe.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/upgrades">the wiki</a>
     */
    @SerialName("output_upgrade_id")
    val outputUpgradeId: Int = 0,

    /**
     * The chat link.
     * @see <a href="https://wiki.guildwars2.com/wiki/Chat_link_format#Recipe_link">the wiki</a>
     */
    @SerialName("chat_link")
    val chatLink: String = ""
)