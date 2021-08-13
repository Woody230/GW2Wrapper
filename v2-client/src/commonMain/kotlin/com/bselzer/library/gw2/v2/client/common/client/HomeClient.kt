package com.bselzer.library.gw2.v2.client.common.client

import com.bselzer.library.gw2.v2.client.common.constant.endpoint.Home
import com.bselzer.library.gw2.v2.model.common.home.Cat
import com.bselzer.library.gw2.v2.model.common.home.Node
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * The home instance client.
 */
class HomeClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    /**
     * @return the ids of the available cats
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/home/cats">the wiki</a>
     */
    suspend fun catIds(): List<Int> = httpClient.get(path = "${Home.HOME}/${Home.CATS}")

    /**
     * @return the cats associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/home/cats">the wiki</a>
     */
    suspend fun cats(ids: Collection<Int>): List<Cat> = chunkedIds(ids, "${Home.HOME}/${Home.CATS}")

    /**
     * @return all the cats
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/home/cats">the wiki</a>
     */
    suspend fun cats(): List<Cat> = allIds("${Home.HOME}/${Home.CATS}")

    /**
     * @return the ids of the available nodes
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/home/nodes">the wiki</a>
     */
    suspend fun nodeIds(): List<String> = httpClient.get(path = "${Home.HOME}/${Home.NODES}")

    /**
     * @return the nodes associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/home/nodes">the wiki</a>
     */
    suspend fun nodes(ids: Collection<String>): List<Cat> = chunkedIds(ids, "${Home.HOME}/${Home.NODES}")

    /**
     * @return all the nodes
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/home/nodes">the wiki</a>
     */
    suspend fun nodes(): List<Node> = allIds("${Home.HOME}/${Home.NODES}")
}