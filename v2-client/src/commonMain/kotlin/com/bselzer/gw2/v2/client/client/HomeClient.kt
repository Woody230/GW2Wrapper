package com.bselzer.gw2.v2.client.client

import com.bselzer.gw2.v2.model.home.cat.Cat
import com.bselzer.gw2.v2.model.home.node.Node
import io.ktor.client.*

/**
 * The home instance client.
 */
class HomeClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration) {
    private companion object {
        const val HOME = "home"
        const val CATS = "cats"
        const val NODES = "nodes"
    }

    /**
     * @return the ids of the available cats
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/home/cats">the wiki</a>
     */
    suspend fun catIds(): List<Int> = getList(path = "${HOME}/${CATS}")

    /**
     * @return the cat associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/home/cats">the wiki</a>
     */
    suspend fun cat(id: Int): Cat = getSingleById(id, "${HOME}/${CATS}", instance = { Cat(id = it) })

    /**
     * @return the cats associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/home/cats">the wiki</a>
     */
    suspend fun cats(ids: Collection<Int>): List<Cat> = chunkedIds(ids, "${HOME}/${CATS}", instance = { Cat(id = it) })

    /**
     * @return all the cats
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/home/cats">the wiki</a>
     */
    suspend fun cats(): List<Cat> = allIds("${HOME}/${CATS}")

    /**
     * @return the ids of the available nodes
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/home/nodes">the wiki</a>
     */
    suspend fun nodeIds(): List<String> = getList(path = "${HOME}/${NODES}")

    /**
     * @return the node associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/home/nodes">the wiki</a>
     */
    suspend fun node(id: String): Node = getSingleById(id, "${HOME}/${NODES}", instance = { Node(id = it) })

    /**
     * @return the nodes associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/home/nodes">the wiki</a>
     */
    suspend fun nodes(ids: Collection<String>): List<Node> = chunkedIds(ids, "${HOME}/${NODES}", instance = { Node(id = it) })

    /**
     * @return all the nodes
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/home/nodes">the wiki</a>
     */
    suspend fun nodes(): List<Node> = allIds("${HOME}/${NODES}")
}