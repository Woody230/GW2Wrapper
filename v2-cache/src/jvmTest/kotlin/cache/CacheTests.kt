package cache

import com.bselzer.gw2.v2.cache.instance.GuildCache
import com.bselzer.gw2.v2.cache.metadata.IdentifiableMetadataExtractor
import com.bselzer.gw2.v2.cache.type.gw2
import com.bselzer.gw2.v2.client.client.Gw2Client
import com.bselzer.gw2.v2.model.guild.upgrade.GuildUpgrade
import com.bselzer.gw2.v2.model.serialization.Modules
import com.bselzer.ktx.kodein.db.cache.GlobalCacheProvider
import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import kotlinx.coroutines.runBlocking
import org.kodein.db.DB
import org.kodein.db.TypeTable
import org.kodein.db.asModelSequence
import org.kodein.db.find
import org.kodein.db.inmemory.inMemory
import org.kodein.db.orm.kotlinx.KotlinxSerializer
import kotlin.test.Test
import kotlin.test.assertEquals

class CacheTests {
    /**
     * Verifies that clearing the database removes all models.
     */
    @Test
    fun clear_WithModels_DeletesAll() {
        // Arrange
        // TODO test module for common Ktor mocking
        val http = HttpClient(MockEngine) {
            engine {
                addHandler { request ->
                    when (request.url.toString()) {
                        "https://api.guildwars2.com/v2/guild/upgrades?ids=all" -> respond(
                            headers = headersOf(HttpHeaders.ContentType, listOf(ContentType.Application.Json.toString())),
                            content = this::class.java.getResource("/GuildUpgrade.json")!!.readText()
                        )
                        else -> error("Cannot handle request.")
                    }
                }
            }
        }
        val client = Gw2Client(http)
        val db = DB.inMemory.open("test",
            KotlinxSerializer(Modules.ALL),
            IdentifiableMetadataExtractor() as org.kodein.db.Options.Open,
            TypeTable { gw2() }
        )

        val cache = GlobalCacheProvider(db)
        val guild = GuildCache(cache, client)

        val upgrades = runBlocking { client.guild.upgrades() }
        db.newBatch().apply {
            upgrades.forEach { upgrade -> put(upgrade) }
            write()
            close()
        }

        val stored = db.find<GuildUpgrade>().all().asModelSequence()
        assertEquals(upgrades.count(), stored.count())

        // Act
        runBlocking { guild.clear() }

        // Assert
        assertEquals(0, db.find<GuildUpgrade>().all().asModelSequence().count())
    }
}