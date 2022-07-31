package com.bselzer.gw2.v2.client.instance.base

import com.bselzer.gw2.v2.client.GenericTypeInfo
import com.bselzer.gw2.v2.client.exception.ResponseException
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.ktx.logging.Logger
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*

abstract class GetResource<Model>(
    private val typeInfo: GenericTypeInfo<Model>
) : Gw2Resource() {
    protected suspend fun Gw2HttpOptions.get(
        context: () -> String,
        customizations: HttpRequestBuilder.() -> Unit
    ): Result<Model> = response(context) {
        method = HttpMethod.Get
        apply(customizations)
    }.fold(
        onSuccess = { response ->
            try {
                response.body<Model>(typeInfo.value).successResult()
            } catch (ex: Exception) {
                val message = context.message("Unable to convert the response body into ${typeInfo.toDisplayableString()}.")
                ResponseException(message, ex).failureResult()
            }
        },
        onFailure = { exception -> exception.failureResult() }
    ).onFailure { exception -> Logger.e(exception) }

    protected suspend fun Gw2HttpOptions.getOrThrow(
        context: () -> String,
        customizations: HttpRequestBuilder.() -> Unit
    ): Model = get(context, customizations).getOrThrow()

    protected suspend fun Gw2HttpOptions.getOrNull(
        context: () -> String,
        customizations: HttpRequestBuilder.() -> Unit
    ): Model? = get(context, customizations).getOrNull()
}