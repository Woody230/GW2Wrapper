package com.bselzer.gw2.v2.client.unit

import com.bselzer.gw2.v2.client.BaseTests
import com.bselzer.gw2.v2.client.asHeader
import com.bselzer.gw2.v2.client.client.Gw2ClientConfiguration
import com.bselzer.gw2.v2.client.model.Token
import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.client.request.*
import io.ktor.http.*

abstract class BaseUnitTests : BaseTests() {
    override fun createHttpClient(): HttpClient = HttpClient(MockEngine, createHttpClientConfig())

    /**
     * The GW2 client configuration.
     *
     * The token must be setup to be able to use the authenticated endpoints.
     */
    override fun createConfiguration(): Gw2ClientConfiguration = Gw2ClientConfiguration(token = Token(""))

    /**
     * @return the block for setting up the HttpClient
     */
    open fun createHttpClientConfig(): HttpClientConfig<MockEngineConfig>.() -> Unit = { engine(createEngineConfig()) }

    /**
     * @return the block for setting up the HttpClientEngine
     */
    abstract fun createEngineConfig(): MockEngineConfig.() -> Unit

    /**
     * Throws an error to indicate the request could not be handled.
     */
    protected fun HttpRequestData.throwError(): Nothing = error("Cannot handle ${this.url.fullPath}")

    /**
     * @return the json header
     */
    protected fun jsonHeader(): Headers = ContentType.Application.Json.asHeader()

    /**
     * Adds an exhaustive response block for a single valid request.
     */
    protected fun MockEngineConfig.exhaust(url: String, content: String) = addHandler { request ->
        when (request.url.toString()) {
            url -> respond(
                headers = jsonHeader(),
                content = content
            )
            else -> request.throwError()
        }
    }

    /**
     * Adds a response block that throws an error.
     */
    protected fun MockEngineConfig.throwError() = addHandler { request -> request.throwError() }
}