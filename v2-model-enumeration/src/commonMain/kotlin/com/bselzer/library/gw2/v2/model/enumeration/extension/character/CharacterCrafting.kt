package com.bselzer.library.gw2.v2.model.enumeration.extension.character

import com.bselzer.library.gw2.v2.model.character.CharacterCrafting
import com.bselzer.library.gw2.v2.model.enumeration.recipe.CraftingDiscipline
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [CharacterCrafting.discipline] as a [CraftingDiscipline]
 */
fun CharacterCrafting.discipline(): CraftingDiscipline? = discipline.enumValueOrNull<CraftingDiscipline>()