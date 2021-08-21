package com.bselzer.library.gw2.v2.model.enumeration.common.recipe

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class RecipeFlag
{
    /**
     * The recipe is automatically unlocked when reaching the required discipline rating.
     */
    @SerialName("AutoLearned")
    AUTO_LEARNED,

    /**
     * The recipe must be unlocked by consuming a recipe sheet.
     */
    @SerialName("LearnedFromItem")
    LEARNED_FROM_ITEM
}