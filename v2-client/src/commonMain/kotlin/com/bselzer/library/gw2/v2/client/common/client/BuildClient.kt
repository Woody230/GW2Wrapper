package com.bselzer.library.gw2.v2.client.common.client

import com.bselzer.library.gw2.v2.client.common.constant.endpoint.Builds
import com.bselzer.library.gw2.v2.model.common.build.Build
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * The build client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/build">the wiki</a>
 */
class BuildClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    /**
     * @return the current build id
     */
    suspend fun buildId(): Int = httpClient.get<Build>(path = Builds.BUILD).id
}