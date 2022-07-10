package com.bselzer.gw2.v2.client.instance

import com.bselzer.gw2.v2.client.constant.Endpoints
import com.bselzer.gw2.v2.client.extension.bearer
import com.bselzer.gw2.v2.client.extension.language
import com.bselzer.gw2.v2.client.extension.schemaVersion
import com.bselzer.gw2.v2.client.request.options.DefaultGw2HttpOptions
import com.bselzer.gw2.v2.model.serialization.Modules
import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.utils.io.core.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonBuilder

/**
 * The GW2 client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:Main">the wiki</a>
 */
open class Gw2Client(
    private var httpClient: HttpClient = HttpClient(),
    private var json: Json = Modules.JSON,
    private var configuration: DefaultGw2HttpOptions = DefaultGw2HttpOptions()
) : Closeable {
    /**
     * The account client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account">the wiki</a>
     */
    lateinit var account: AccountClient

    /**
     * The achievement client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/achievements">the wiki</a>
     */
    lateinit var achievement: AchievementClient

    /**
     * The backstory client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/backstory">the wiki</a>
     */
    lateinit var backstory: BackstoryClient

    /**
     * The build client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/build">the wiki</a>
     */
    lateinit var build: BuildClient

    /**
     * The character client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/characters">the wiki</a>
     */
    lateinit var character: CharacterClient

    /**
     * The color client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/colors">the wiki</a>
     */
    lateinit var color: ColorClient

    /**
     * The commerce client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/commerce">the wiki</a>
     */
    lateinit var commerce: CommerceClient

    /**
     * The continent client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    lateinit var continent: ContinentClient

    /**
     * The currency client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/currencies">the wiki</a>
     */
    lateinit var currency: CurrencyClient

    /**
     * The daily crafting client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/dailycrafting">the wiki</a>
     */
    lateinit var dailyCrafting: DailyCraftingClient

    /**
     * The dungeon client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/dungeons">the wiki</a>
     */
    lateinit var dungeon: DungeonClient

    /**
     * The emblem client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/emblem">the wiki</a>
     */
    lateinit var emblem: EmblemClient

    /**
     * The emote client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/emotes">the wiki</a>
     */
    lateinit var emote: EmoteClient

    /**
     * The file client for commonly requests in-game assets.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/files">the wiki</a>
     */
    lateinit var file: FileClient

    /**
     * The finisher client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/finishers">the wiki</a>
     */
    lateinit var finisher: FinisherClient

    /**
     * The glider client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/gliders">the wiki</a>
     */
    lateinit var glider: GliderClient

    /**
     * The guild client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild">the wiki</a>
     */
    lateinit var guild: GuildClient

    /**
     * The home instance client.
     */
    lateinit var home: HomeClient

    /**
     * The item client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    lateinit var item: ItemClient

    /**
     * The legendary armory client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/legendaryarmory">the wiki</a>
     */
    lateinit var legendaryArmory: LegendaryArmoryClient

    /**
     * The legend client. For Revenants.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/legends">the wiki</a>
     */
    lateinit var legend: LegendClient

    /**
     * The mail carrier client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/mailcarriers">the wiki</a>
     */
    lateinit var mailCarrier: MailCarrierClient

    /**
     * The map chests client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/mapchests">the wiki</a>
     */
    lateinit var mapChest: MapChestClient

    /**
     * The map client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/maps">the wiki</a>
     */
    lateinit var map: MapClient

    /**
     * The mastery client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/masteries">the wiki</a>
     */
    lateinit var mastery: MasteryClient

    /**
     * The material client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/materials">the wiki</a>
     */
    lateinit var material: MaterialClient

    /**
     * The mini-pet client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/minis">the wiki</a>
     */
    lateinit var mini: MiniClient

    /**
     * The mount client.
     * @see <a href='https://wiki.guildwars2.com/wiki/API:2/mounts">the wiki</a>
     */
    lateinit var mount: MountClient

    /**
     * The novelty client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/novelties">the wiki</a>
     */
    lateinit var novelty: NoveltyClient

    /**
     * The outfit client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/outfits">the wiki</a>
     */
    lateinit var outfit: OutfitClient

    /**
     * The pet client. For Rangers.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pets">the wiki</a>
     */
    lateinit var pet: PetClient

    /**
     * The profession client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/professions">the wiki</a>
     */
    lateinit var profession: ProfessionClient

    /**
     * The player vs. player client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp">the wiki</a>
     */
    lateinit var pvp: PvpClient

    /**
     * The quaggan client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/quaggans">the wiki</a>
     */
    lateinit var quaggan: QuagganClient

    /**
     * The quest client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/quests">the wiki</a>
     */
    lateinit var quest: QuestClient

    /**
     * The race client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/races">the wiki</a.
     */
    lateinit var race: RaceClient

    /**
     * The raid client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/raids">the wiki</a>
     */
    lateinit var raid: RaidClient

    /**
     * The recipe client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/recipes">the wiki</a>
     */
    lateinit var recipe: RecipeClient

    /**
     * The skill client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skills">the wiki</a>
     */
    lateinit var skill: SkillClient

    /**
     * The skin client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skins">the wiki</a>
     */
    lateinit var skin: SkinClient

    /**
     * The specialization client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/specializations">the wiki</a>
     */
    lateinit var specialization: SpecializationClient

    /**
     * The story client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/stories">the wiki</a>
     */
    lateinit var story: StoryClient

    /**
     * The title client.
     * <a href="https://wiki.guildwars2.com/wiki/API:2/titles">the wiki</a>
     */
    lateinit var title: TitleClient

    /**
     * The token client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/tokeninfo">the wiki</a>
     */
    lateinit var token: TokenClient

    /**
     * The trait client.
     * <a href="https://wiki.guildwars2.com/wiki/API:2/traits">the wiki</a>
     */
    lateinit var trait: TraitClient

    /**
     * The world boss client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/worldbosses">the wiki</a>
     */
    lateinit var worldBoss: WorldBossClient

    /**
     * The world client.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/worlds">the wiki</a>
     */
    lateinit var world: WorldClient

    /**
     * The world vs. world client.
     * @see <a href='https://wiki.guildwars2.com/wiki/API:2/wvw">the wiki</a>
     */
    lateinit var wvw: WvwClient

    init {
        setupClients(httpClient, json, configuration)
    }

    /**
     * Sets up the underlying clients.
     */
    private fun setupClients(httpClient: HttpClient, json: Json, configuration: DefaultGw2HttpOptions) {
        val newClient = httpClient.setup(json, configuration)
        this.httpClient = newClient
        account = AccountClient(newClient, configuration)
        achievement = AchievementClient(newClient, configuration)
        backstory = BackstoryClient(newClient, configuration)
        build = BuildClient(newClient, configuration)
        character = CharacterClient(newClient, configuration)
        color = ColorClient(newClient, configuration)
        commerce = CommerceClient(newClient, configuration)
        continent = ContinentClient(newClient, configuration)
        currency = CurrencyClient(newClient, configuration)
        dailyCrafting = DailyCraftingClient(newClient, configuration)
        dungeon = DungeonClient(newClient, configuration)
        emblem = EmblemClient(newClient, configuration)
        emote = EmoteClient(newClient, configuration)
        file = FileClient(newClient, configuration)
        finisher = FinisherClient(newClient, configuration)
        glider = GliderClient(newClient, configuration)
        guild = GuildClient(newClient, configuration)
        home = HomeClient(newClient, configuration)
        item = ItemClient(newClient, configuration)
        legendaryArmory = LegendaryArmoryClient(newClient, configuration)
        legend = LegendClient(newClient, configuration)
        mailCarrier = MailCarrierClient(newClient, configuration)
        mapChest = MapChestClient(newClient, configuration)
        map = MapClient(newClient, configuration)
        mastery = MasteryClient(newClient, configuration)
        material = MaterialClient(newClient, configuration)
        mini = MiniClient(newClient, configuration)
        mount = MountClient(newClient, configuration)
        novelty = NoveltyClient(newClient, configuration)
        outfit = OutfitClient(newClient, configuration)
        pet = PetClient(newClient, configuration)
        profession = ProfessionClient(newClient, configuration)
        pvp = PvpClient(newClient, configuration)
        quaggan = QuagganClient(newClient, configuration)
        quest = QuestClient(newClient, configuration)
        race = RaceClient(newClient, configuration)
        raid = RaidClient(newClient, configuration)
        recipe = RecipeClient(newClient, configuration)
        skill = SkillClient(newClient, configuration)
        skin = SkinClient(newClient, configuration)
        specialization = SpecializationClient(newClient, configuration)
        story = StoryClient(newClient, configuration)
        token = TokenClient(newClient, configuration)
        title = TitleClient(newClient, configuration)
        trait = TraitClient(newClient, configuration)
        worldBoss = WorldBossClient(newClient, configuration)
        world = WorldClient(newClient, configuration)
        wvw = WvwClient(newClient, configuration)
    }

    /**
     * @return a new [Gw2Client] with an updated [DefaultGw2HttpOptions]
     */
    fun config(block: DefaultGw2HttpOptions.() -> DefaultGw2HttpOptions): Unit = setupClients(httpClient, json, block(configuration))

    /**
     * @return a new [Gw2Client] with an updated [Json]
     */
    fun json(block: JsonBuilder.() -> Unit): Unit = setupClients(httpClient, Json(json, block), configuration)

    /**
     * @return a new [Gw2Client] with an updated [HttpClientConfig]
     */
    fun httpClient(block: HttpClientConfig<*>.() -> Unit): Unit = setupClients(httpClient.config(block), json, configuration)

    /**
     * @return a new http client with the configuration applied
     */
    private fun HttpClient.setup(json: Json, configuration: DefaultGw2HttpOptions): HttpClient = config {
        // Enable kotlinx.serialization
        install(ContentNegotiation) {
            json(json)
        }

        defaultRequest {
            url(Endpoints.BASE_URL)

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
    override fun close() {
        httpClient.close()
    }
}