package com.bselzer.gw2.v2.client.request.model

import com.bselzer.gw2.v2.client.request.Gw2GetRequest
import io.ktor.util.reflect.*

interface GetModel : Gw2GetRequest {
    val modelTypeInfo: TypeInfo
}