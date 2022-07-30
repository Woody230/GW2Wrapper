package com.bselzer.gw2.v2.client.instance.base

import com.bselzer.gw2.v2.client.exception.ResponseException
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.ktx.logging.Logger
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.util.reflect.*

abstract class GetResource<Model>(
    private val typeInfo: TypeInfo
) : Gw2Resource() {
    protected suspend fun Gw2HttpOptions.get(
        context: () -> String,
        customizations: HttpRequestBuilder.() -> Unit
    ): Model = response(context, customizations).run {
        try {
            body<Model>(typeInfo)
        } catch (ex: Exception) {
            throw ResponseException("Unable to convert the response body into ${typeInfo.type.simpleName}. ${context()}", ex)
        }
    }

    protected suspend fun Gw2HttpOptions.getOrNull(
        context: () -> String,
        customizations: HttpRequestBuilder.() -> Unit
    ): Model? = responseOrNull(context, customizations)?.run {
        try {
            body<Model>(typeInfo)
        } catch (ex: Exception) {
            Logger.e(ResponseException(ex), "Unable to convert the response body into ${typeInfo.type.simpleName}. ${context()}")
            null
        }
    }
}