package com.bselzer.gw2.v2.client.request.token

import com.bselzer.gw2.v2.client.exception.Gw2ClientException
import com.bselzer.gw2.v2.client.options.Gw2Options
import com.bselzer.gw2.v2.client.result.GetResult
import com.bselzer.gw2.v2.model.account.token.SubToken
import com.bselzer.gw2.v2.scope.core.Permission
import kotlinx.datetime.Instant

interface CreateSubToken {
    /**
     * Creates a sub-token that expires at [expiration], that is able to access the endpoints associated with the [permissions] or defined by the [urls].
     *
     * The token must be defined in the [Gw2Options].
     *
     * @return the sub-token or a [GetResult.Failure] if unable to fulfill the request.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/createsubtoken">createsubtoken on the wiki</a>
     */
    suspend fun create(expiration: Instant, permissions: List<Permission>, urls: List<String>, options: Gw2Options = Gw2Options.Default): GetResult<SubToken>

    /**
     * Creates a sub-token that expires at [expiration], that is able to access the endpoints associated with the [permissions] or defined by the [urls].
     *
     * The token must be defined in the [Gw2Options]
     *
     * @return the sub-token
     * @throws Gw2ClientException if unable to fulfill the request
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/createsubtoken">createsubtoken on the wiki</a>
     */
    suspend fun createOrThrow(expiration: Instant, permissions: List<Permission>, urls: List<String>, options: Gw2Options = Gw2Options.Default): SubToken

    /**
     * Creates a sub-token that expires at [expiration], that is able to access the endpoints associated with the [permissions] or defined by the [urls].
     *
     * The token must be defined in the [Gw2Options]
     *
     * @return the sub-token, or null if unable to fulfill the request
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/createsubtoken">createsubtoken on the wiki</a>
     */
    suspend fun createOrNull(expiration: Instant, permissions: List<Permission>, urls: List<String>, options: Gw2Options = Gw2Options.Default): SubToken?
}