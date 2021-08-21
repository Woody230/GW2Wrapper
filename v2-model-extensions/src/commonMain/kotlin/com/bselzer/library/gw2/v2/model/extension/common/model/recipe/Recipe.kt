package com.bselzer.library.gw2.v2.model.extension.common.model.recipe

import com.bselzer.library.gw2.v2.model.common.recipe.Recipe
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.recipe.CraftingDiscipline
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.recipe.RecipeFlag
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.recipe.RecipeType
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull
import com.bselzer.library.kotlin.extension.serialization.common.function.validEnumValues

/**
 * The [Recipe.type] as a [RecipeType]
 */
fun Recipe.type(): RecipeType? = type.enumValueOrNull<RecipeType>()

/**
 * The [Recipe.disciplines] as a collection of [CraftingDiscipline]
 */
fun Recipe.disciplines(): List<CraftingDiscipline> = disciplines.validEnumValues()

/**
 * The [Recipe.flags] as a collection of [RecipeFlag]
 */
fun Recipe.flags(): List<RecipeFlag> = flags.validEnumValues()