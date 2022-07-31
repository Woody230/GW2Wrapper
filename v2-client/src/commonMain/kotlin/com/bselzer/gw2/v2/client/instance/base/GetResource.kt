package com.bselzer.gw2.v2.client.instance.base

import com.bselzer.gw2.v2.client.GenericTypeInfo
import com.bselzer.gw2.v2.client.exception.RequestException
import com.bselzer.gw2.v2.client.exception.ResponseException
import com.bselzer.gw2.v2.client.exception.ValidationException
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.ktx.logging.Logger
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*

abstract class GetResource<Model>(
    private val typeInfo: GenericTypeInfo<Model>
) : Gw2Resource() {
    /**
     * [configure]s the [HttpClient] customizations and executes the request.
     * If an exception occurs during this process, then the result fails with a [RequestException].
     *
     * If the response is able to be obtained, then it is validated according to the given [Gw2HttpOptions].
     * If an exception occurs during this process, then the result fails with a [ValidationException].
     *
     * If validation is successful, then the response body is converted into the [Model].
     * If an exception occurs during this process, then the result fails with a [ResponseException].
     *
     * @param context The type of request being made, which should include any important information being used in the request.
     * @param customizations The [HttpClient] customizations specific to this implementation of the request.
     * @return The response body converted into the [Model]. On success, the [Model]. On failure, a [RequestException], [ResponseException], or [ValidationException].
     * @see [configure]
     */
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

    /**
     * @param context The type of request being made, which should include any important information being used in the request.
     * @param customizations The [HttpClient] customizations specific to this implementation of the request.
     * @return The response body converted into the [Model].
     * @see [get]
     * @see [configure]
     * @throws RequestException If the request is not able to be fulfilled.
     * @throws ResponseException If the response body is not able to be converted into the [Model].
     * @throws ValidationException If validation of the response fails.
     */
    protected suspend fun Gw2HttpOptions.getOrThrow(
        context: () -> String,
        customizations: HttpRequestBuilder.() -> Unit
    ): Model = get(context, customizations).getOrThrow()

    /**
     * @param context The type of request being made, which should include any important information being used in the request.
     * @param customizations The [HttpClient] customizations specific to this implementation of the request.
     * @return The response body converted into the [Model], or null if an exception occurs during the process.
     * @see [get]
     * @see [configure]
     */
    protected suspend fun Gw2HttpOptions.getOrNull(
        context: () -> String,
        customizations: HttpRequestBuilder.() -> Unit
    ): Model? = get(context, customizations).getOrNull()
}