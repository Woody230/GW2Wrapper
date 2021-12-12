package com.bselzer.gw2.v2.client.client

import com.bselzer.gw2.v2.model.recipe.Recipe
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * The recipe client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/recipes">the wiki</a>
 */
class RecipeClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration) {
    private companion object {
        const val RECIPES = "recipes"
        const val SEARCH = "search"
    }

    /**
     * @return the ids of the available recipes
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/recipes">the wiki</a>
     */
    suspend fun ids(): List<String> = getList(path = RECIPES)

    /**
     * @return the ids of the recipes that use the item with the given [itemId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/recipes/search">the wiki</a>
     */
    suspend fun idsByInput(itemId: Int): List<Int> = getList(path = "${RECIPES}/${SEARCH}") {
        parameter("input", itemId)
    }

    /**
     * @return the ids of the recipes that produce the item with the given [itemId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/recipes/search">the wiki</a>
     */
    suspend fun idsByOutput(itemId: Int): List<Int> = getList(path = "${RECIPES}/${SEARCH}") {
        parameter("output", itemId)
    }

    /**
     * @return the recipes associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/recipes">the wiki</a>
     */
    suspend fun recipe(id: Int): Recipe = getSingleById(id, RECIPES)

    /**
     * @return the recipes associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/recipes">the wiki</a>
     */
    suspend fun recipes(ids: Collection<Int>): List<Recipe> = chunkedIds(ids, RECIPES)
}