package com.bselzer.library.gw2.v2.client.common

import com.bselzer.library.gw2.v2.client.common.constant.Endpoints
import com.bselzer.library.gw2.v2.model.common.account.Account
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
class AccountClient(
    private val httpClient: HttpClient
)
{
    /**
     * Scopes: account
     *
     * Optional scopes: guilds, progression
     * @return the account information
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account">the wiki</a>
     */
    suspend fun account(): Account = httpClient.get(path = Endpoints.ACCOUNT)
}