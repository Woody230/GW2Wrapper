package com.bselzer.library.gw2.v2.client.common

import com.bselzer.library.gw2.v2.client.common.constant.Headers
import com.bselzer.library.gw2.v2.client.common.constant.endpoint.Endpoints
import com.bselzer.library.gw2.v2.client.common.extension.bearer
import com.bselzer.library.gw2.v2.client.common.extension.language
import com.bselzer.library.gw2.v2.client.common.extension.schemaVersion
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.json.Json

/**
 * The GW2 client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:Main">the wiki</a>
 */
open class Gw2Client(
    httpClient: HttpClient,
    json: Json = DEFAULT_JSON,
    private val configuration: Gw2ClientConfiguration = Gw2ClientConfiguration()
)
{
    companion object
    {
        /**
         * The default [Json] instance.
         *
         * It is designed to be lenient in order to avoid errors.
         */
        val DEFAULT_JSON = Json {
            isLenient = true
            ignoreUnknownKeys = true
            coerceInputValues = true
        }
    }

    /**
     * The account client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account">the wiki</a>
     */
    val account: AccountClient

    /**
     * The achievement client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/achievements">the wiki</a>
     */
    val achievement: AchievementClient

    /**
     * The token client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/tokeninfo">the wiki</a>
     */
    val token: TokenClient

    init
    {
        val setupClient = httpClient.setup(json, configuration)
        account = AccountClient(setupClient, configuration)
        achievement = AchievementClient(setupClient, configuration)
        token = TokenClient(setupClient, configuration)
    }

    /**
     * @return a new http client with the configuration applied
     */
    private fun HttpClient.setup(json: Json, configuration: Gw2ClientConfiguration): HttpClient = config {
        defaultRequest {
            host = Endpoints.BASE_URL

            // TODO validation?

            // Enable kotlinx.serialization
            install(JsonFeature) {
                serializer = KotlinxSerializer(json)
            }

            // Set up the headers.
            header(HttpHeaders.ContentType, Headers.JSON)

            configuration.schemaVersion?.let { version ->
                schemaVersion(version)
            }

            configuration.token?.let { token ->
                bearer(token)
            }

            configuration.language?.let { language ->
                language(language)
            }
        }
    }
}