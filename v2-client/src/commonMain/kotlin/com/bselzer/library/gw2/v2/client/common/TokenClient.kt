package com.bselzer.library.gw2.v2.client.common

import com.bselzer.library.gw2.v2.annotation.common.scope.Permission
import com.bselzer.library.gw2.v2.annotation.common.scope.Requirement
import com.bselzer.library.gw2.v2.annotation.common.scope.Scope
import com.bselzer.library.gw2.v2.client.common.constant.endpoint.Tokens
import com.bselzer.library.gw2.v2.client.common.extension.ensureBearer
import com.bselzer.library.gw2.v2.model.common.account.token.SubToken
import com.bselzer.library.gw2.v2.model.common.account.token.TokenInfo
import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.datetime.LocalDateTime

/**
 * The token client.
 *
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/tokeninfo">tokeninfo on the wiki</a>
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/createsubtoken">createsubtoken on the wiki</a>
 */
@Scope(Requirement.REQUIRED, Permission.ACCOUNT)
class TokenClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    /**
     * @return the token information
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/tokeninfo">tokeninfo on the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT)
    suspend fun information(): TokenInfo = httpClient.get(path = Tokens.TOKEN_INFO)

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
        expiration: LocalDateTime,
        permissions: List<String>,
        urls: List<String>,
        token: String? = null
    ): SubToken = httpClient.get(path = Tokens.CREATE_SUBTOKEN) {
        ensureBearer(token)
        parameter("expire", expiration)
        parameter("permissions", permissions.joinToString())
        parameter("urls", urls.joinToString())
    }
}