package com.bselzer.gw2.v2.client

import com.bselzer.gw2.v2.client.instance.ExceptionRecoveryMode
import com.bselzer.gw2.v2.client.instance.Gw2Client
import com.bselzer.gw2.v2.client.instance.Gw2ClientConfiguration
import com.bselzer.gw2.v2.client.model.Token
import com.bselzer.gw2.v2.model.character.CharacterName
import com.bselzer.gw2.v2.model.serialization.Modules
import io.ktor.client.*
import io.ktor.client.engine.mock.*
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlin.test.fail

abstract class BaseTests {
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
    open fun createJson(): Json = Modules.JSON
    open fun createConfiguration(): Gw2ClientConfiguration = Gw2ClientConfiguration()

    /**
     * Closes the GW2 client after getting the request response.
     * @return the response of the request performed by the [block]
     */
    protected fun <T> use(block: suspend Gw2Client.() -> T): T {
        return runBlocking { gw2.use { block(gw2) } }
    }

    /**
     * Gets the request response.
     * @return the response of the request performed by the [block]
     */
    protected fun <T> get(block: suspend Gw2Client.() -> T): T {
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
    protected fun Map<String, String>.token(): Token = Token(this.getValue("token"))
    protected fun Map<String, String>.characterName(): CharacterName = CharacterName(this.getValue("characterName"))

    protected fun getProfessionResource(): String = "Profession.json".getResource()
    protected fun getGuildUpgradeResource(): String = "GuildUpgrade.json".getResource()

    /**
     * Asserts a failure due to an exception not being thrown.
     */
    protected fun expectedException(): Nothing = fail("Expected an exception to be thrown")

    /**
     * Asserts that recovery can be performed.
     */
    protected fun <R> testRecovery(callEndpoint: suspend Gw2Client.() -> R, defaultAssertion: (R) -> Unit) =
        try {
            use { callEndpoint(this) }
            expectedException()
        } catch (exception: Exception) {
            Gw2Client(createHttpClient(), createJson(), Gw2ClientConfiguration(exceptionRecoveryMode = ExceptionRecoveryMode.DEFAULT)).use {
                val result = runBlocking { callEndpoint(it) }
                defaultAssertion(result)
            }
        }

    /**
     * Asserts that recovery cannot be performed.
     */
    protected fun <R> failedRecovery(callEndpoint: suspend Gw2Client.() -> R) = try {
        use { callEndpoint(this) }
        expectedException()
    } catch (exception: Exception) {
        try {
            Gw2Client(createHttpClient(), createJson(), Gw2ClientConfiguration(exceptionRecoveryMode = ExceptionRecoveryMode.DEFAULT)).use {
                runBlocking { callEndpoint(it) }
                expectedException()
            }
        } catch (exception: Exception) {

        }
    }
}