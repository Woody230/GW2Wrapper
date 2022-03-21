package com.bselzer.gw2.v2.client.client

import com.bselzer.gw2.v2.client.extension.bearer
import com.bselzer.gw2.v2.client.model.Token
import com.bselzer.gw2.v2.model.commerce.delivery.Delivery
import com.bselzer.gw2.v2.model.commerce.exchange.CoinExchange
import com.bselzer.gw2.v2.model.commerce.exchange.GemExchange
import com.bselzer.gw2.v2.model.commerce.listing.Listings
import com.bselzer.gw2.v2.model.commerce.price.Prices
import com.bselzer.gw2.v2.model.commerce.transaction.CurrentTransaction
import com.bselzer.gw2.v2.model.commerce.transaction.PastTransaction
import com.bselzer.gw2.v2.model.item.ItemId
import com.bselzer.gw2.v2.scope.core.Permission
import com.bselzer.gw2.v2.scope.core.Requirement
import com.bselzer.gw2.v2.scope.core.Scope
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * The commerce client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/commerce">the wiki</a>
 */
@Scope(Requirement.OPTIONAL, Permission.ACCOUNT, Permission.TRADING_POST)
class CommerceClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration) {
    private companion object {
        const val COMMERCE = "commerce"
        const val DELIVERY = "delivery"
        const val EXCHANGE = "exchange"
        const val COINS = "coins"
        const val GEMS = "gems"
        const val LISTINGS = "listings"
        const val PRICES = "prices"
        const val TRANSACTIONS = "transactions"
        const val CURRENT = "current"
        const val HISTORY = "history"
        const val BUYS = "buys"
        const val SELLS = "sells"
    }

    /**
     * @return the information about the items ready for pickup
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/delivery">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.TRADING_POST)
    suspend fun delivery(token: Token? = null): Delivery = getSingle(path = "${COMMERCE}/${DELIVERY}", instance = { Delivery() }) {
        bearer(token)
    }

    /**
     * @return the information about the exchange of [quantity] coins to gems
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/exchange/coins">the wiki</a>
     */
    suspend fun coinExchange(quantity: Int): CoinExchange = getSingle(path = "${COMMERCE}/${EXCHANGE}/${COINS}", { CoinExchange() }) {
        parameter("quantity", quantity)
    }

    /**
     * @return the information about the exchange of [quantity] gems to coins
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/exchange/gems">the wiki</a>
     */
    suspend fun gemExchange(quantity: Int): GemExchange = getSingle(path = "${COMMERCE}/${EXCHANGE}/${GEMS}", instance = { GemExchange() }) {
        parameter("quantity", quantity)
    }

    /**
     * @return the ids of the available listings
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/listings">the wiki</a>
     */
    suspend fun listingIds(): List<ItemId> = getIds(path = "${COMMERCE}/${LISTINGS}")

    /**
     * @return the listing associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/listings">the wiki</a>
     */
    suspend fun listing(id: ItemId): Listings = getSingleById(id, "${COMMERCE}/${LISTINGS}", instance = { Listings(id = it) })


    /**
     * @return the listings associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/listings">the wiki</a>
     */
    suspend fun listings(ids: Collection<ItemId>): List<Listings> = chunkedIds(ids, "${COMMERCE}/${LISTINGS}", instance = { Listings(id = it) })

    /**
     * @return the ids of the available prices
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/prices">the wiki</a>
     */
    suspend fun priceIds(): List<ItemId> = getIds(path = "${COMMERCE}/${PRICES}")

    /**
     * @return the price associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/prices">the wiki</a>
     */
    suspend fun price(id: ItemId): Prices = getSingleById(id, "${COMMERCE}/${PRICES}", instance = { Prices(id = it) })

    /**
     * @return the prices associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/prices">the wiki</a>
     */
    suspend fun prices(ids: Collection<ItemId>): List<Prices> = chunkedIds(ids, "${COMMERCE}/${PRICES}", instance = { Prices(id = it) })

    /**
     * @return the current unfilled transactions for buy orders
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/transactions">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.TRADING_POST)
    suspend fun currentBuys(token: Token? = null): List<CurrentTransaction> =
        getList(path = "${COMMERCE}/${TRANSACTIONS}/${CURRENT}/${BUYS}") {
            bearer(token)
        }

    /**
     * @return the current unfilled transactions for sell offers
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/transactions">the wiki</a>
     */
    suspend fun currentSells(token: Token? = null): List<CurrentTransaction> =
        getList(path = "${COMMERCE}/${TRANSACTIONS}/${CURRENT}/${BUYS}") {
            bearer(token)
        }

    /**
     * @return the fulfilled transactions for buy orders within the last 90 days
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/transactions">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.TRADING_POST)
    suspend fun pastBuys(token: Token? = null): List<PastTransaction> =
        getList(path = "${COMMERCE}/${TRANSACTIONS}/${HISTORY}/${SELLS}") {
            bearer(token)
        }

    /**
     * @return the filled transactions for sell offers within the last 90 days
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/transactions">the wiki</a>
     */
    suspend fun pastSells(token: Token? = null): List<PastTransaction> =
        getList(path = "${COMMERCE}/${TRANSACTIONS}/${HISTORY}/${SELLS}") {
            bearer(token)
        }
}