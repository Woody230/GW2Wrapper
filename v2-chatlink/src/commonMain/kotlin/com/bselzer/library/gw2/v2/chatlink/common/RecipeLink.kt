package com.bselzer.library.gw2.v2.chatlink.common

/**
 * A link to a recipe.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/recipes">the wiki</a>
 */
class RecipeLink(id: Int = 0) : IdLink(id)
{
    override val header: Byte = 9
}