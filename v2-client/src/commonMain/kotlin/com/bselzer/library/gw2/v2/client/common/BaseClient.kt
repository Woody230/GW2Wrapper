package com.bselzer.library.gw2.v2.client.common

import io.ktor.client.*

// TODO ensureScopes()
abstract class BaseClient(
    protected val httpClient: HttpClient
)