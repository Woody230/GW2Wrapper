package com.bselzer.gw2.v2.client.request.token

import com.bselzer.gw2.v2.client.exception.Gw2ClientException
import com.bselzer.gw2.v2.client.options.DefaultGw2HttpOptions
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.gw2.v2.scope.core.Permission
import kotlinx.datetime.Instant

interface CreateSubToken {
    /**
     * Creates a sub-token that expires at [expiration], that is able to access the endpoints associated with the [permissions] or defined by the [urls].
     *
     * The token must either be defined in the [Gw2HttpOptions] or [DefaultGw2HttpOptions].
     *
     * @return the sub-token id or a [Gw2ClientException] if unable to fulfill the request.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/createsubtoken">createsubtoken on the wiki</a>
     */
    suspend fun create(expiration: Instant, permissions: List<Permission>, urls: List<String>, options: Gw2HttpOptions): Result<Token>

    /**
     * Creates a sub-token that expires at [expiration], that is able to access the endpoints associated with the [permissions] or defined by the [urls].
     *
     * The token must either be defined in the [Gw2HttpOptions] or [DefaultGw2HttpOptions].
     *
     * @return the sub-token id
     * @throws Gw2ClientException if unable to fulfill the request
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/createsubtoken">createsubtoken on the wiki</a>
     */
    suspend fun createOrThrow(expiration: Instant, permissions: List<Permission>, urls: List<String>, options: Gw2HttpOptions): Token

    /**
     * Creates a sub-token that expires at [expiration], that is able to access the endpoints associated with the [permissions] or defined by the [urls].
     *
     * The token must either be defined in the [Gw2HttpOptions] or [DefaultGw2HttpOptions].
     *
     * @return the sub-token id, or null if unable to fulfill the request
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/createsubtoken">createsubtoken on the wiki</a>
     */
    suspend fun createOrNull(expiration: Instant, permissions: List<Permission>, urls: List<String>, options: Gw2HttpOptions): Token?
}