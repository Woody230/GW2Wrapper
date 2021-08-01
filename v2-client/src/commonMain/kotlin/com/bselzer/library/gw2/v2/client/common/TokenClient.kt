package com.bselzer.library.gw2.v2.client.common

import com.bselzer.library.gw2.v2.client.common.constant.Endpoints
import com.bselzer.library.gw2.v2.client.common.extension.bearer
import com.bselzer.library.gw2.v2.model.common.account.token.SubToken
import com.bselzer.library.gw2.v2.model.common.account.token.TokenInfo
import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.datetime.LocalDateTime

/**
 * The token client.
 *
 * Scopes: account
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/tokeninfo">tokeninfo on the wiki</a>
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/createsubtoken">createsubtoken on the wiki</a>
 */
class TokenClient(httpClient: HttpClient) : BaseClient(httpClient)
{
    /**
     * Scopes: account
     *
     * @return the token information
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/tokeninfo">tokeninfo on the wiki</a>
     */
    suspend fun information(): TokenInfo = httpClient.get(path = Endpoints.TOKEN_INFO)

    /**
     * Creates a sub-token that expires at [expiration], that is able to access the endpoints associated with the [permissions] or defined by the [urls].
     *
     * The token must either be defined in the configuration or by [token].
     *
     * Scopes: account
     *
     * @return the sub-token id
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/createsubtoken">createsubtoken on the wiki</a>
     */
    suspend fun createSubToken(
        expiration: LocalDateTime,
        permissions: List<String>,
        urls: List<String>,
        token: String? = null
    ): SubToken = httpClient.get(path = Endpoints.CREATE_SUBTOKEN) {
        if (token != null)
        {
            // Override the configuration API key with the given API key.
            bearer(token)
        } else
        {
            throw IllegalArgumentException("Unable to create a sub-token without an API key defined in the configuration or the method parameter.")
        }

        parameter("expire", expiration)
        parameter("permissions", permissions.joinToString())
        parameter("urls", urls.joinToString())
    }
}