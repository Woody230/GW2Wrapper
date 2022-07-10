package com.bselzer.gw2.v2.client.instance

import com.bselzer.gw2.v2.client.request.options.DefaultGw2HttpOptions
import io.ktor.client.*

open class BaseClient(
    protected val httpClient: HttpClient,
    protected val defaultOptions: DefaultGw2HttpOptions
)