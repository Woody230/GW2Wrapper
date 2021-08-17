package com.bselzer.library.gw2.v2.client.common.client

import com.bselzer.library.gw2.v2.model.common.recipe.Recipe
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * The recipe client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/recipes">the wiki</a>
 */
class RecipeClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    private companion object
    {
        const val RECIPES = "recipes"
        const val SEARCH = "search"
    }

    /**
     * The recipe input item id.
     */
    @JvmInline
    value class RecipeInput(val itemId: Int)

    /**
     * The recipe output item id.
     */
    @JvmInline
    value class RecipeOutput(val itemId: Int)

    /**
     * @return the ids of the available recipes
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/recipes">the wiki</a>
     */
    suspend fun ids(): List<String> = get(path = RECIPES)

    /**
     * @return the ids of the recipes that use the item with the given [input] id
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/recipes/search">the wiki</a>
     */
    suspend fun ids(input: RecipeInput): List<Int> = get(path = "${RECIPES}/${SEARCH}") {
        parameter("input", input.itemId)
    }

    /**
     * @return the ids of the recipes that produce the item with the given [output] id
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/recipes/search">the wiki</a>
     */
    suspend fun ids(output: RecipeOutput): List<Int> = get(path = "${RECIPES}/${SEARCH}") {
        parameter("output", output.itemId)
    }

    /**
     * @return the recipes associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/recipes">the wiki</a>
     */
    suspend fun recipe(id: String): Recipe = single(id, RECIPES)

    /**
     * @return the recipes associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/recipes">the wiki</a>
     */
    suspend fun recipes(ids: Collection<String>): List<Recipe> = chunkedIds(ids, RECIPES)
}