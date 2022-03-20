package com.bselzer.gw2.v2.model.enumeration.extension.character

import com.bselzer.gw2.v2.model.character.progression.CharacterCrafting
import com.bselzer.gw2.v2.model.enumeration.recipe.CraftingDiscipline
import com.bselzer.ktx.serialization.function.enumValueOrNull

/**
 * The [CharacterCrafting.discipline] as a [CraftingDiscipline]
 */
fun CharacterCrafting.discipline(): CraftingDiscipline? = discipline.enumValueOrNull<CraftingDiscipline>()