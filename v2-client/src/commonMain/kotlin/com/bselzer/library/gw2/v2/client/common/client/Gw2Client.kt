package com.bselzer.library.gw2.v2.client.common.client

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
        // TODO serializer modules
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
     * The color client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/colors">the wiki</a>
     */
    val color: ColorClient

    /**
     * The currency client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/currencies">the wiki</a>
     */
    val currency: CurrencyClient

    /**
     * The daily crafting client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/dailycrafting">the wiki</a>
     */
    val dailyCrafting: DailyCraftingClient

    /**
     * The dungeon client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/dungeons">the wiki</a>
     */
    val dungeon: DungeonClient

    /**
     * The emblem client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/emblem">the wiki</a>
     */
    val emblem: EmblemClient

    /**
     * The emote client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/emotes">the wiki</a>
     */
    val emote: EmoteClient

    /**
     * The guild client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild">the wiki</a>
     */
    val guild: GuildClient

    /**
     * The legend client. For Revenants.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/legends">the wiki</a>
     */
    val legend: LegendClient

    /**
     * The legendary armory client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/legendaryarmory">the wiki</a>
     */
    val legendaryArmory: LegendaryArmoryClient

    /**
     * The map chests client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/mapchests">the wiki</a>
     */
    val mapChest: MapChestClient

    /**
     * The mastery client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/masteries">the wiki</a>
     */
    val mastery: MasteryClient

    /**
     * The mount client.
     * @see <a href='https://wiki.guildwars2.com/wiki/API:2/mounts">the wiki</a>
     */
    val mount: MountClient

    /**
     * The pet client. For Rangers.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pets">the wiki</a>
     */
    val pet: PetClient

    /**
     * The profession client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/professions">the wiki</a>
     */
    val profession: ProfessionClient

    /**
     * The player vs player client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp">the wiki</a>
     */
    val pvp: PvpClient

    /**
     * The race client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/races">the wiki</a.
     */
    val race: RaceClient

    /**
     * The raid client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/raids">the wiki</a>
     */
    val raid: RaidClient

    /**
     * The skill client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skills">the wiki</a>
     */
    val skill: SkillClient

    /**
     * The specialization client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/specializations">the wiki</a>
     */
    val specialization: SpecializationClient

    /**
     * The title client.
     * <a href="https://wiki.guildwars2.com/wiki/API:2/titles">the wiki</a>
     */
    val title: TitleClient

    /**
     * The token client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/tokeninfo">the wiki</a>
     */
    val token: TokenClient

    /**
     * The trait client.
     * <a href="https://wiki.guildwars2.com/wiki/API:2/traits">the wiki</a>
     */
    val trait: TraitClient

    /**
     * The world boss client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/worldbosses">the wiki</a>
     */
    val worldBoss: WorldBossClient

    init
    {
        val client = httpClient.setup(json, configuration)
        this.httpClient = client
        account = AccountClient(client, configuration)
        achievement = AchievementClient(client, configuration)
        character = CharacterClient(client, configuration)
        color = ColorClient(client, configuration)
        currency = CurrencyClient(client, configuration)
        dailyCrafting = DailyCraftingClient(client, configuration)
        dungeon = DungeonClient(client, configuration)
        emblem = EmblemClient(client, configuration)
        emote = EmoteClient(client, configuration)
        guild = GuildClient(client, configuration)
        legend = LegendClient(client, configuration)
        legendaryArmory = LegendaryArmoryClient(client, configuration)
        mapChest = MapChestClient(client, configuration)
        mastery = MasteryClient(client, configuration)
        mount = MountClient(client, configuration)
        pet = PetClient(client, configuration)
        profession = ProfessionClient(client, configuration)
        pvp = PvpClient(client, configuration)
        race = RaceClient(client, configuration)
        raid = RaidClient(client, configuration)
        skill = SkillClient(client, configuration)
        specialization = SpecializationClient(client, configuration)
        token = TokenClient(client, configuration)
        title = TitleClient(client, configuration)
        trait = TraitClient(client, configuration)
        worldBoss = WorldBossClient(client, configuration)
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