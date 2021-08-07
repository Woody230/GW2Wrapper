package com.bselzer.library.gw2.v2.client.common

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
import io.ktor.utils.io.core.*
import kotlinx.serialization.json.Json

/**
 * The GW2 client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:Main">the wiki</a>
 */
open class Gw2Client(
    httpClient: HttpClient,
    json: Json = DEFAULT_JSON,
    private val configuration: Gw2ClientConfiguration = Gw2ClientConfiguration()
) : Closeable
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
     * The HTTP client.
     */
    private val httpClient: HttpClient

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
     * The character client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/characters">the wiki</a>
     */
    val character: CharacterClient

    /**
     * The token client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/tokeninfo">the wiki</a>
     */
    val token: TokenClient

    /**
     * The player vs player client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp">the wiki</a>
     */
    val pvp: PvpClient

    init
    {
        val client = httpClient.setup(json, configuration)
        this.httpClient = client
        account = AccountClient(client, configuration)
        achievement = AchievementClient(client, configuration)
        character = CharacterClient(client, configuration)
        token = TokenClient(client, configuration)
        pvp = PvpClient(client, configuration)
    }

    /**
     * @return a new http client with the configuration applied
     */
    private fun HttpClient.setup(json: Json, configuration: Gw2ClientConfiguration): HttpClient = config {
        // Enable kotlinx.serialization
        install(JsonFeature) {
            serializer = KotlinxSerializer(json)
        }

        defaultRequest {
            host = Endpoints.BASE_URL

            url {
                protocol = URLProtocol.HTTPS
            }

            // TODO HttpResponseValidator? https://ktor.io/docs/response-validation.html#custom

            // Set up the headers.
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

    /**
     * Close the HTTP client.
     */
    override fun close()
    {
        httpClient.close()
    }
}