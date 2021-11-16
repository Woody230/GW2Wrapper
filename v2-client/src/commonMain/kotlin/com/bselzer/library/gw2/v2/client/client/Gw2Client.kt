package com.bselzer.library.gw2.v2.client.client

import com.bselzer.library.gw2.v2.client.constant.Endpoints
import com.bselzer.library.gw2.v2.client.extension.bearer
import com.bselzer.library.gw2.v2.client.extension.language
import com.bselzer.library.gw2.v2.client.extension.schemaVersion
import com.bselzer.library.gw2.v2.model.serialization.Modules
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.utils.io.core.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonBuilder

/**
 * The GW2 client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:Main">the wiki</a>
 */
open class Gw2Client(
    httpClient: HttpClient = HttpClient(),
    private val json: Json = DEFAULT_JSON,
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
            encodeDefaults = true
            serializersModule = Modules.ALL
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
     * The backstory client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/backstory">the wiki</a>
     */
    val backstory: BackstoryClient

    /**
     * The build client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/build">the wiki</a>
     */
    val build: BuildClient

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
     * The commerce client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/commerce">the wiki</a>
     */
    val commerce: CommerceClient

    /**
     * The continent client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    val continent: ContinentClient

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
     * The file client for commonly requests in-game assets.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/files">the wiki</a>
     */
    val file: FileClient

    /**
     * The finisher client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/finishers">the wiki</a>
     */
    val finisher: FinisherClient

    /**
     * The glider client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/gliders">the wiki</a>
     */
    val glider: GliderClient

    /**
     * The guild client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild">the wiki</a>
     */
    val guild: GuildClient

    /**
     * The home instance client.
     */
    val home: HomeClient

    /**
     * The item client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    val item: ItemClient

    /**
     * The legendary armory client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/legendaryarmory">the wiki</a>
     */
    val legendaryArmory: LegendaryArmoryClient

    /**
     * The legend client. For Revenants.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/legends">the wiki</a>
     */
    val legend: LegendClient

    /**
     * The mail carrier client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/mailcarriers">the wiki</a>
     */
    val mailCarrier: MailCarrierClient

    /**
     * The map chests client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/mapchests">the wiki</a>
     */
    val mapChest: MapChestClient

    /**
     * The map client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/maps">the wiki</a>
     */
    val map: MapClient

    /**
     * The mastery client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/masteries">the wiki</a>
     */
    val mastery: MasteryClient

    /**
     * The material client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/materials">the wiki</a>
     */
    val material: MaterialClient

    /**
     * The mini-pet client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/minis">the wiki</a>
     */
    val mini: MiniClient

    /**
     * The mount client.
     * @see <a href='https://wiki.guildwars2.com/wiki/API:2/mounts">the wiki</a>
     */
    val mount: MountClient

    /**
     * The novelty client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/novelties">the wiki</a>
     */
    val novelty: NoveltyClient

    /**
     * The outfit client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/outfits">the wiki</a>
     */
    val outfit: OutfitClient

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
     * The player vs. player client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp">the wiki</a>
     */
    val pvp: PvpClient

    /**
     * The quaggan client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/quaggans">the wiki</a>
     */
    val quaggan: QuagganClient

    /**
     * The quest client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/quests">the wiki</a>
     */
    val quest: QuestClient

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
     * The recipe client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/recipes">the wiki</a>
     */
    val recipe: RecipeClient

    /**
     * The skill client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skills">the wiki</a>
     */
    val skill: SkillClient

    /**
     * The skin client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skins">the wiki</a>
     */
    val skin: SkinClient

    /**
     * The specialization client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/specializations">the wiki</a>
     */
    val specialization: SpecializationClient

    /**
     * The story client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/stories">the wiki</a>
     */
    val story: StoryClient

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

    /**
     * The world client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/worlds">the wiki</a>
     */
    val world: WorldClient

    /**
     * The world vs. world client.
     * @see <a href='https://wiki.guildwars2.com/wiki/API:2/wvw">the wiki</a>
     */
    val wvw: WvwClient

    init
    {
        val client = httpClient.setup(json, configuration)
        this.httpClient = client
        account = AccountClient(client, configuration)
        achievement = AchievementClient(client, configuration)
        backstory = BackstoryClient(client, configuration)
        build = BuildClient(client, configuration)
        character = CharacterClient(client, configuration)
        color = ColorClient(client, configuration)
        commerce = CommerceClient(client, configuration)
        continent = ContinentClient(client, configuration)
        currency = CurrencyClient(client, configuration)
        dailyCrafting = DailyCraftingClient(client, configuration)
        dungeon = DungeonClient(client, configuration)
        emblem = EmblemClient(client, configuration)
        emote = EmoteClient(client, configuration)
        file = FileClient(client, configuration)
        finisher = FinisherClient(client, configuration)
        glider = GliderClient(client, configuration)
        guild = GuildClient(client, configuration)
        home = HomeClient(client, configuration)
        item = ItemClient(client, configuration)
        legendaryArmory = LegendaryArmoryClient(client, configuration)
        legend = LegendClient(client, configuration)
        mailCarrier = MailCarrierClient(client, configuration)
        mapChest = MapChestClient(client, configuration)
        map = MapClient(client, configuration)
        mastery = MasteryClient(client, configuration)
        material = MaterialClient(client, configuration)
        mini = MiniClient(client, configuration)
        mount = MountClient(client, configuration)
        novelty = NoveltyClient(client, configuration)
        outfit = OutfitClient(client, configuration)
        pet = PetClient(client, configuration)
        profession = ProfessionClient(client, configuration)
        pvp = PvpClient(client, configuration)
        quaggan = QuagganClient(client, configuration)
        quest = QuestClient(client, configuration)
        race = RaceClient(client, configuration)
        raid = RaidClient(client, configuration)
        recipe = RecipeClient(client, configuration)
        skill = SkillClient(client, configuration)
        skin = SkinClient(client, configuration)
        specialization = SpecializationClient(client, configuration)
        story = StoryClient(client, configuration)
        token = TokenClient(client, configuration)
        title = TitleClient(client, configuration)
        trait = TraitClient(client, configuration)
        worldBoss = WorldBossClient(client, configuration)
        world = WorldClient(client, configuration)
        wvw = WvwClient(client, configuration)
    }

    /**
     * @return a new [Gw2Client] with an updated [Gw2ClientConfiguration]
     */
    fun config(block: Gw2ClientConfiguration.() -> Gw2ClientConfiguration): Gw2Client = Gw2Client(httpClient, json, block(configuration))

    /**
     * @return a new [Gw2Client] with an updated [Json]
     */
    fun json(block: JsonBuilder.() -> Unit): Gw2Client = Gw2Client(httpClient, Json(json, block), configuration)

    /**
     * @return a new [Gw2Client] with an updated [HttpClientConfig]
     */
    fun httpClient(block: HttpClientConfig<*>.() -> Unit): Gw2Client = Gw2Client(httpClient.config(block), json, configuration)

    /**
     * @return a new http client with the configuration applied
     */
    private fun HttpClient.setup(json: Json, configuration: Gw2ClientConfiguration): HttpClient = config {
        // Enable kotlinx.serialization
        install(JsonFeature) {
            serializer = KotlinxSerializer(json)
        }

        // TODO HttpResponseValidator? https://ktor.io/docs/response-validation.html#custom

        // NOTE: this default request is applied last.
        defaultRequest {
            host = Endpoints.BASE_URL

            url {
                protocol = URLProtocol.HTTPS
            }

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