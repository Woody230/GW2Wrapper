package com.bselzer.library.gw2.v2.model.extension.common.model.character

import com.bselzer.library.gw2.v2.model.common.character.CharacterCrafting
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.recipe.CraftingDiscipline
import com.bselzer.library.kotlin.extension.function.common.objects.enumValueOrNull

/**
 * The [CharacterCrafting.discipline] as a [CraftingDiscipline]
 */
fun CharacterCrafting.discipline(): CraftingDiscipline? = discipline.enumValueOrNull<CraftingDiscipline>()