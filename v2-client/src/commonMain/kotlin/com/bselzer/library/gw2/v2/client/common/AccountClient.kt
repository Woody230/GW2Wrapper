package com.bselzer.library.gw2.v2.client.common

import com.bselzer.library.gw2.v2.annotation.common.scope.Permission
import com.bselzer.library.gw2.v2.annotation.common.scope.Requirement
import com.bselzer.library.gw2.v2.annotation.common.scope.Scope
import com.bselzer.library.gw2.v2.client.common.constant.endpoint.Accounts
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
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account">the wiki</a>
 */
@OptIn(ExperimentalTime::class)
@Scope(Requirement.REQUIRED, Permission.ACCOUNT)
@Scope(Requirement.OPTIONAL, Permission.GUILDS, Permission.PROGRESSION)
class AccountClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    /**
     * @return the account information
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT)
    @Scope(Requirement.OPTIONAL, Permission.GUILDS, Permission.PROGRESSION)
    suspend fun account(token: String? = null): Account = httpClient.get(path = Accounts.ACCOUNT) {
        ensureBearer(token)
    }

    /**
     * @return the account's achievements
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/achievements">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.PROGRESSION)
    suspend fun achievements(token: String? = null): List<AccountAchievement> =
        httpClient.get(path = "${Accounts.ACCOUNT}/${Accounts.ACHIEVEMENTS}") {
            ensureBearer(token)
        }

    /**
     * Gets the bank slots associated with an account.
     * A null [BankItem] indicates that the slot does not contain an item.
     *
     * @return the account's bank slots
     * @see <a href="https://wiki.guildwars2.com/wiki/Account_vault">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.INVENTORIES)
    suspend fun bankItems(token: String? = null): List<BankItem> =
        httpClient.get(path = "${Accounts.ACCOUNT}/${Accounts.BANK}") {
            ensureBearer(token)
        }

    /**
     * @return the time-gated recipes that have been crafted since the daily reset
     * @see <a href="https://wiki.guildwars2.com/wiki/Crafting#Time_gated_recipes">the wiki</a>
     */
    // TODO enum for the items and extension method
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.PROGRESSION)
    suspend fun dailyCrafting(token: String? = null): List<String> =
        httpClient.get(path = "${Accounts.ACCOUNT}/${Accounts.DAILY_CRAFTING}") {
            ensureBearer(token)
        }

    /**
     * @return the ids of the dungeon paths completed since the daily reset
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/dungeons">the wiki</a>
     */
    // TODO enum for the paths (when doing dungeons endpoint) and extension method
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.PROGRESSION)
    suspend fun dungeons(token: String? = null): List<String> =
        httpClient.get("${Accounts.ACCOUNT}/${Accounts.DUNGEONS}") {
            ensureBearer(token)
        }

    /**
     * @return the ids of the unlocked dyes on the account
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/colors">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.UNLOCKS)
    suspend fun dyes(token: String? = null): List<Int> = httpClient.get("${Accounts.ACCOUNT}/${Accounts.DYES}") {
        ensureBearer(token)
    }
}