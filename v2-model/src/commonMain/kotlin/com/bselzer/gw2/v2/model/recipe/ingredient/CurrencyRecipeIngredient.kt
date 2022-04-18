package com.bselzer.gw2.v2.model.recipe.ingredient

import com.bselzer.gw2.v2.model.currency.CurrencyId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Currency")
data class CurrencyRecipeIngredient(
    /**
     * The id of the currency.
     * @see <a href="https://wiki.guildwars2.com/wiki/Currency">the wiki</a>
     */
    @SerialName("id")
    override val id: CurrencyId = CurrencyId(),
) : RecipeIngredient()