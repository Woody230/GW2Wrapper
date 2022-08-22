package com.bselzer.gw2.v2.client.instance.base

import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.gw2.v2.client.result.GetResult
import com.bselzer.ktx.client.GenericTypeInfo
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * A [GetResource] that gets the response body as a [ResponseModel] and converts it into the [ResultModel].
 */
abstract class ConvertibleGetResource<ResponseModel, ResultModel>(
    private val responseTypeInfo: GenericTypeInfo<ResponseModel>,
    private val resultTypeInfo: GenericTypeInfo<ResultModel>
) : GetResource<ResponseModel>(responseTypeInfo) {
    /**
     * Disable applying the result so that it can be done after conversion.
     */
    override val shouldApply: Boolean = false

    /**
     * [configure]s the [HttpClient] customizations and executes the request.
     * If an exception occurs during this process, then the result fails with a [GetResult.Failure.Gw2] and [Gw2HttpOptions.onFailure]/[Gw2HttpOptions.onGetFailure] is applied.
     *
     * If the response is successful, then the response body is converted into the [ResponseModel] and then into [ResultModel] by [convert] and the [Gw2HttpOptions.onGetSuccess] is applied.
     * If an exception occurs during this process, then the result fails with a [GetResult.Failure.Serialization] and [Gw2HttpOptions.onGetFailure] is applied.
     *
     * @param context The type of request being made, which should include any important information being used in the request.
     * @param customizations The [HttpClient] customizations specific to this implementation of the request.
     * @return [GetResult.Success] if able to convert the response, otherwise [GetResult.Failure]
     * @see [configure]
     */
    protected suspend fun Gw2HttpOptions.get(
        context: () -> String,
        customizations: HttpRequestBuilder.() -> Unit,
        convert: (GetResult.Success<ResponseModel>) -> GetResult<ResultModel>
    ): GetResult<ResultModel> = when (val result = get(context, customizations)) {
        is GetResult.Success<ResponseModel> -> try {
            convert(result)
        } catch (ex: Exception) {
            val message = "Failed to convert from ${responseTypeInfo.toDisplayableString()} to ${resultTypeInfo.toDisplayableString()}."
            GetResult.Failure.Conversion(result.response, message, ex)
        }
        is GetResult.Failure<ResponseModel> -> result.persistFailure()
    }.apply(options = this)
}