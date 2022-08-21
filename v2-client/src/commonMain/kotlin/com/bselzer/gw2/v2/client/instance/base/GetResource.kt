package com.bselzer.gw2.v2.client.instance.base

import com.bselzer.gw2.v2.client.GenericTypeInfo
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.gw2.v2.client.result.GetResult
import com.bselzer.gw2.v2.client.result.Gw2Result
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

abstract class GetResource<Model>(
    private val typeInfo: GenericTypeInfo<Model>
) : Resource() {
    /**
     * [configure]s the [HttpClient] customizations and executes the request.
     * If an exception occurs during this process, then the result fails with a [GetResult.Failure.Gw2] and [Gw2HttpOptions.onFailure] is applied.
     *
     * If the response is successful, then the response body is converted into the [Model].
     * If an exception occurs during this process, then the result fails with a [GetResult.Failure.Serialization].
     *
     * @param context The type of request being made, which should include any important information being used in the request.
     * @param customizations The [HttpClient] customizations specific to this implementation of the request.
     * @return The response body converted into the [Model] on [GetResult.Success], otherwise, [GetResult.Failure].
     * @see [configure]
     */
    protected suspend fun Gw2HttpOptions.get(
        context: () -> String,
        customizations: HttpRequestBuilder.() -> Unit
    ): GetResult<Model> {
        val result = response(context) {
            method = HttpMethod.Get
            apply(customizations)
        }

        return when (result) {
            is Gw2Result.Failure -> GetResult.Failure.Gw2(result)
            is Gw2Result.Success -> result.response.deserialize(context)
        }
    }

    private suspend fun <Model> HttpResponse.deserialize(
        context: () -> String
    ): GetResult<Model> = try {
        GetResult.Success(this, body(typeInfo.value))
    } catch (ex: Exception) {
        val message = context.message("Unable to convert the response body into ${typeInfo.toDisplayableString()}.")
        GetResult.Failure.Serialization(this, message, ex)
    }
}