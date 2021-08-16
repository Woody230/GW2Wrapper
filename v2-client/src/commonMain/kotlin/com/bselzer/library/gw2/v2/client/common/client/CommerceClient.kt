package com.bselzer.library.gw2.v2.client.common.client

import com.bselzer.library.gw2.v2.annotation.common.scope.Permission
import com.bselzer.library.gw2.v2.annotation.common.scope.Requirement
import com.bselzer.library.gw2.v2.annotation.common.scope.Scope
import com.bselzer.library.gw2.v2.client.common.constant.endpoint.Commerce
import com.bselzer.library.gw2.v2.client.common.extension.ensureBearer
import com.bselzer.library.gw2.v2.model.common.commerce.delivery.Delivery
import com.bselzer.library.gw2.v2.model.common.commerce.exchange.CoinExchange
import com.bselzer.library.gw2.v2.model.common.commerce.exchange.GemExchange
import com.bselzer.library.gw2.v2.model.common.commerce.listing.Listings
import com.bselzer.library.gw2.v2.model.common.commerce.price.Prices
import com.bselzer.library.gw2.v2.model.common.commerce.transaction.CurrentTransaction
import com.bselzer.library.gw2.v2.model.common.commerce.transaction.PastTransaction
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * The commerce client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/commerce">the wiki</a>
 */
@Scope(Requirement.OPTIONAL, Permission.ACCOUNT, Permission.TRADING_POST)
class CommerceClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    /**
     * @return the information about the items ready for pickup
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/delivery">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.TRADING_POST)
    suspend fun delivery(token: String? = null): Delivery = httpClient.get(path = "${Commerce.COMMERCE}/${Commerce.DELIVERY}") {
        ensureBearer(token)
    }

    /**
     * @return the information about the exchange of [quantity] coins to gems
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/exchange/coins">the wiki</a>
     */
    suspend fun coinExchange(quantity: Int): CoinExchange = httpClient.get(path = "${Commerce.COMMERCE}/${Commerce.EXCHANGE}/${Commerce.COINS}") {
        parameter("quantity", quantity)
    }

    /**
     * @return the information about the exchange of [quantity] gems to coins
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/exchange/gems">the wiki</a>
     */
    suspend fun gemExchange(quantity: Int): GemExchange = httpClient.get(path = "${Commerce.COMMERCE}/${Commerce.EXCHANGE}/${Commerce.GEMS}") {
        parameter("quantity", quantity)
    }

    /**
     * @return the ids of the available listings
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/listings">the wiki</a>
     */
    suspend fun listingIds(): List<Int> = httpClient.get(path = "${Commerce.COMMERCE}/${Commerce.LISTINGS}")

    /**
     * @return the listing associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/listings">the wiki</a>
     */
    suspend fun listing(id: Int): Listings = single(id, "${Commerce.COMMERCE}/${Commerce.LISTINGS}")


    /**
     * @return the listings associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/listings">the wiki</a>
     */
    suspend fun listings(ids: Collection<Int>): List<Listings> = chunkedIds(ids, "${Commerce.COMMERCE}/${Commerce.LISTINGS}")

    /**
     * @return the ids of the available prices
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/prices">the wiki</a>
     */
    suspend fun priceIds(): List<Int> = httpClient.get(path = "${Commerce.COMMERCE}/${Commerce.PRICES}")

    /**
     * @return the price associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/prices">the wiki</a>
     */
    suspend fun price(id: Int): Prices = single(id, "${Commerce.COMMERCE}/${Commerce.PRICES}")

    /**
     * @return the prices associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/prices">the wiki</a>
     */
    suspend fun prices(ids: Collection<Int>): List<Prices> = chunkedIds(ids, "${Commerce.COMMERCE}/${Commerce.PRICES}")

    /**
     * @return the current unfilled transactions for buy orders
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/transactions">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.TRADING_POST)
    suspend fun currentBuys(token: String? = null): List<CurrentTransaction> =
        httpClient.get(path = "${Commerce.COMMERCE}/${Commerce.TRANSACTIONS}/${Commerce.CURRENT}/${Commerce.BUYS}") {
            ensureBearer(token)
        }

    /**
     * @return the current unfilled transactions for sell offers
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/transactions">the wiki</a>
     */
    suspend fun currentSells(token: String? = null): List<CurrentTransaction> =
        httpClient.get(path = "${Commerce.COMMERCE}/${Commerce.TRANSACTIONS}/${Commerce.CURRENT}/${Commerce.BUYS}") {
            ensureBearer(token)
        }

    /**
     * @return the fulfilled transactions for buy orders within the last 90 days
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/transactions">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.TRADING_POST)
    suspend fun pastBuys(token: String? = null): List<PastTransaction> =
        httpClient.get(path = "${Commerce.COMMERCE}/${Commerce.TRANSACTIONS}/${Commerce.HISTORY}/${Commerce.SELLS}") {
            ensureBearer(token)
        }

    /**
     * @return the filled transactions for sell offers within the last 90 days
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/transactions">the wiki</a>
     */
    suspend fun pastSells(token: String? = null): List<PastTransaction> =
        httpClient.get(path = "${Commerce.COMMERCE}/${Commerce.TRANSACTIONS}/${Commerce.HISTORY}/${Commerce.SELLS}") {
            ensureBearer(token)
        }
}