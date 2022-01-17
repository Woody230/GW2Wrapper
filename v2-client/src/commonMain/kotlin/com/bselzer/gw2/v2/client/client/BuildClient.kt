package com.bselzer.gw2.v2.client.client

import com.bselzer.gw2.v2.model.build.Build
import io.ktor.client.*

/**
 * The build client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/build">the wiki</a>
 */
class BuildClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration) {
    private companion object {
        const val BUILD = "build"
    }

    /**
     * @return the current build id
     */
    suspend fun buildId(): Int = getSingle(path = BUILD, instance = { Build() }).id
}