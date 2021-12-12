package com.bselzer.gw2.v2.client.client

import com.bselzer.gw2.v2.client.extension.bearer
import com.bselzer.gw2.v2.model.account.token.SubToken
import com.bselzer.gw2.v2.model.account.token.TokenInfo
import com.bselzer.gw2.v2.scope.core.Permission
import com.bselzer.gw2.v2.scope.core.Requirement
import com.bselzer.gw2.v2.scope.core.Scope
import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.datetime.Instant

/**
 * The token client.
 *
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/tokeninfo">tokeninfo on the wiki</a>
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/createsubtoken">createsubtoken on the wiki</a>
 */
@Scope(Requirement.REQUIRED, Permission.ACCOUNT)
class TokenClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration) {
    private companion object {
        const val TOKEN_INFO = "tokeninfo"
        const val CREATE_SUBTOKEN = "createsubtoken"
    }

    /**
     * Gets the token information.
     *
     * The token must either be defined in the configuration or by [token].
     * @return the token information
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/tokeninfo">tokeninfo on the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT)
    suspend fun information(token: String? = null): TokenInfo = forceGetSingle(path = TOKEN_INFO) {
        bearer(token)
    }

    /**
     * Creates a sub-token that expires at [expiration], that is able to access the endpoints associated with the [permissions] or defined by the [urls].
     *
     * The token must either be defined in the configuration or by [token].
     *
     * @return the sub-token id
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/createsubtoken">createsubtoken on the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT)
    suspend fun createSubToken(
        expiration: Instant,
        permissions: List<String>,
        urls: List<String>,
        token: String? = null
    ): SubToken = forceGetSingle(path = CREATE_SUBTOKEN) {
        bearer(token)
        parameter("expire", expiration)
        parameter("permissions", permissions.joinToString())
        parameter("urls", urls.joinToString())
    }
}