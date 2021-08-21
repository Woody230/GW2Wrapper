package com.bselzer.library.gw2.v2.client.common

import com.bselzer.library.gw2.v2.client.common.client.Gw2Client
import com.bselzer.library.gw2.v2.client.common.client.Gw2ClientConfiguration
import io.ktor.client.*
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

abstract class BaseTests
{
    /**
     * The GW2 client.
     */
    private val gw2 = createGw2Client()

    /**
     * The secrets resource contents.
     */
    protected val secrets = getSecretsResource()

    private fun createGw2Client(): Gw2Client = Gw2Client(createHttpClient(), createJson(), createConfiguration())
    open fun createHttpClient(): HttpClient = HttpClient()
    open fun createJson(): Json = Gw2Client.DEFAULT_JSON
    open fun createConfiguration(): Gw2ClientConfiguration = Gw2ClientConfiguration()

    /**
     * Closes the GW2 client after getting the request response.
     * @return the response of the request performed by the [block]
     */
    protected fun <T> use(block: suspend Gw2Client.() -> T): T
    {
        return runBlocking { gw2.use { block(gw2) } }
    }

    /**
     * Gets the request response.
     * @return the response of the request performed by the [block]
     */
    protected fun <T> get(block: suspend Gw2Client.() -> T): T
    {
        return runBlocking { gw2.run { block(gw2) } }
    }

    /**
     * @return the resource as a string from a path without the leading slash.
     */
    protected fun String.getResource(): String = this@BaseTests::class.java.getResource("/$this")!!.readText()

    /**
     * @return the resource that is in JSON format from a path without the leading slash.
     */
    protected inline fun <reified T> String.getJsonResource(json: Json = Json): T = json.decodeFromString(this.getResource())

    /**
     * @return the contents of the secrets file
     */
    private fun getSecretsResource(): Map<String, String> = "Secrets.json".getJsonResource()
    protected fun Map<String, String>.token(): String = this.getValue("token")
    protected fun Map<String, String>.characterName(): String = this.getValue("characterName")

    protected fun getProfessionResource(): String = "Profession.json".getResource()
}