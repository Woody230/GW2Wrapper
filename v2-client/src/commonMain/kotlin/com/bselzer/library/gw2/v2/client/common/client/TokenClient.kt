package com.bselzer.library.gw2.v2.client.common.client

import com.bselzer.library.gw2.v2.client.common.extension.bearer
import com.bselzer.library.gw2.v2.model.common.account.token.SubToken
import com.bselzer.library.gw2.v2.model.common.account.token.TokenInfo
import com.bselzer.library.gw2.v2.scope.common.core.Permission
import com.bselzer.library.gw2.v2.scope.common.core.Requirement
import com.bselzer.library.gw2.v2.scope.common.core.Scope
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
class TokenClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    private companion object
    {
        const val TOKEN_INFO = "tokeninfo"
        const val CREATE_SUBTOKEN = "createsubtoken"
    }

    /**
     * @return the token information
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/tokeninfo">tokeninfo on the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT)
    suspend fun information(): TokenInfo = get(path = TOKEN_INFO)

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
    ): SubToken = get(path = CREATE_SUBTOKEN) {
        bearer(token)
        parameter("expire", expiration)
        parameter("permissions", permissions.joinToString())
        parameter("urls", urls.joinToString())
    }
}