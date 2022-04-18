package com.bselzer.gw2.v2.model.recipe.ingredient

import com.bselzer.ktx.value.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
abstract class RecipeIngredient(
    @SerialName("count")
    val count: Int = 0
) : Identifiable<Int> {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as RecipeIngredient

        if (count != other.count) return false

        return true
    }

    override fun hashCode(): Int {
        return count
    }
}