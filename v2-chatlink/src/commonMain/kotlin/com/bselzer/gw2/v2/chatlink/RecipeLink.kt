package com.bselzer.gw2.v2.chatlink

import com.bselzer.gw2.v2.model.recipe.RecipeId

/**
 * A link to a recipe.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/recipes">the wiki</a>
 */
class RecipeLink(id: RecipeId = RecipeId()) : IdLink(id.value) {
    override val header: Byte = 9
}