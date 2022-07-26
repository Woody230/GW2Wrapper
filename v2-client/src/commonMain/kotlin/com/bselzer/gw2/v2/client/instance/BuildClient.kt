package com.bselzer.gw2.v2.client.instance

import com.bselzer.gw2.v2.client.options.DefaultGw2HttpOptions
import com.bselzer.gw2.v2.model.build.Build
import com.bselzer.gw2.v2.model.build.BuildId
import io.ktor.client.*

/**
 * The build client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/build">the wiki</a>
 */
class BuildClient(httpClient: HttpClient, configuration: DefaultGw2HttpOptions) : BaseClient(httpClient, configuration) {
    private companion object {
        const val BUILD = "build"
    }

    /**
     * @return the current build id
     */
    suspend fun buildId(): BuildId = getSingle(path = BUILD, instance = { Build() }).id
}