package com.bselzer.gw2.v2.client.request

import io.ktor.util.reflect.*

interface GetModel : Gw2GetRequest {
    val modelTypeInfo: TypeInfo
}