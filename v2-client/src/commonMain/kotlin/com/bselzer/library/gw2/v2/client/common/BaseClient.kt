package com.bselzer.library.gw2.v2.client.common

import io.ktor.client.*

abstract class BaseClient(
    protected val httpClient: HttpClient
)