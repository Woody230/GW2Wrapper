package com.bselzer.gw2.v2.model.recipe

import com.bselzer.gw2.v2.model.enumeration.wrapper.CraftingDiscipline
import com.bselzer.gw2.v2.model.enumeration.wrapper.RecipeFlag
import com.bselzer.gw2.v2.model.enumeration.wrapper.RecipeType
import com.bselzer.gw2.v2.model.guild.upgrade.GuildUpgradeId
import com.bselzer.gw2.v2.model.item.ItemId
import com.bselzer.gw2.v2.model.recipe.ingredient.RecipeIngredient
import com.bselzer.gw2.v2.model.wrapper.ChatLink
import com.bselzer.ktx.serialization.serializer.MillisecondDurationSerializer
import com.bselzer.ktx.value.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.time.Duration

@Serializable
data class Recipe(
    @SerialName("id")
    override val id: RecipeId = RecipeId(),

    @SerialName("type")
    val type: RecipeType = RecipeType(),

    /**
     * The id of the item produced by this recipe.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    @SerialName("output_item_id")
    val outputItemId: ItemId = ItemId(),

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
    val disciplines: List<CraftingDiscipline> = emptyList(),

    /**
     * The minimum crafting discipline level required to craft this recipe.
     */
    @SerialName("min_rating")
    val minRating: Int = 0,

    @SerialName("flags")
    val flags: List<RecipeFlag> = emptyList(),

    /**
     * The ingredients required in the recipe.
     */
    @SerialName("ingredients")
    val ingredients: List<RecipeIngredient<*>> = emptyList(),

    /**
     * The id of the guild upgrade produced by the recipe.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/upgrades">the wiki</a>
     */
    @SerialName("output_upgrade_id")
    val outputUpgradeId: GuildUpgradeId = GuildUpgradeId(),

    /**
     * The chat link.
     * @see <a href="https://wiki.guildwars2.com/wiki/Chat_link_format#Recipe_link">the wiki</a>
     */
    @SerialName("chat_link")
    val chatLink: ChatLink = ChatLink()
) : Identifiable<RecipeId, Int>