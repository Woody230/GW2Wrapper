package com.bselzer.library.gw2.v2.client.common

import com.bselzer.library.gw2.v2.client.common.constant.Endpoints
import com.bselzer.library.gw2.v2.client.common.extension.ensureBearer
import com.bselzer.library.gw2.v2.model.common.account.Account
import com.bselzer.library.gw2.v2.model.common.account.AccountAchievement
import com.bselzer.library.gw2.v2.model.common.account.bank.BankItem
import io.ktor.client.*
import io.ktor.client.request.*
import kotlin.time.ExperimentalTime

/**
 * The account client.
 *
 * Scopes: account
 *
 * Optional scopes: guilds, progression
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account">the wiki</a>
 */
@OptIn(ExperimentalTime::class)
class AccountClient(httpClient: HttpClient) : BaseClient(httpClient)
{
    /**
     * Scopes: account
     *
     * Optional scopes: guilds, progression
     * @return the account information
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account">the wiki</a>
     */
    suspend fun information(token: String? = null): Account = httpClient.get(path = Endpoints.ACCOUNT) {
        ensureBearer(token)
    }

    /**
     * Scopes: account, progression
     * @return the account's achievements
     */
    suspend fun achievements(token: String? = null): List<AccountAchievement> =
        httpClient.get(path = "${Endpoints.ACCOUNT}/${Endpoints.ACHIEVEMENTS}") {
            ensureBearer(token)
        }

    /**
     * Gets the bank slots associated with an account.
     * A null [BankItem] indicates that the slot does not contain an item.
     *
     * Scopes: account, inventories
     * @return the account's bank slots
     * @see <a href="https://wiki.guildwars2.com/wiki/Account_vault">the wiki</a>
     */
    suspend fun bankItems(token: String? = null): List<BankItem> =
        httpClient.get(path = "${Endpoints.ACCOUNT}/${Endpoints.BANK}") {
            ensureBearer(token)
        }

    /**
     * Scopes: account, progression
     * @return the time-gated recipes that have been crafted since the daily reset
     * @see <a href="https://wiki.guildwars2.com/wiki/Crafting#Time_gated_recipes">the wiki</a>
     */
    // TODO enum for the items and extension method
    suspend fun dailyCrafting(token: String? = null): List<String> =
        httpClient.get(path = "${Endpoints.ACCOUNT}/${Endpoints.DAILY_CRAFTING}") {
            ensureBearer(token)
        }

    /**
     * Scopes: account, progression
     * @return the ids of the dungeon paths completed since the daily reset
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/dungeons">the wiki</a>
     */
    // TODO enum for the paths (when doing dungeons endpoint) and extension method
    suspend fun dungeons(token: String? = null): List<String> =
        httpClient.get("${Endpoints.ACCOUNT}/${Endpoints.DUNGEONS}") {
            ensureBearer(token)
        }
}