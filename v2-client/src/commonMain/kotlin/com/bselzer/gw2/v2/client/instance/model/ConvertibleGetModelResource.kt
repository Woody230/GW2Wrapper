package com.bselzer.gw2.v2.client.instance.model

import com.bselzer.gw2.v2.client.GenericTypeInfo
import com.bselzer.gw2.v2.client.genericTypeInfo
import com.bselzer.gw2.v2.client.instance.base.ConvertibleGetResource
import com.bselzer.gw2.v2.client.instance.base.Gw2ResourceOptions
import com.bselzer.gw2.v2.client.instance.base.ResourceDependencies
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.gw2.v2.client.request.model.GetModel
import com.bselzer.gw2.v2.client.result.GetResult
import io.ktor.client.*
import io.ktor.client.request.*

class ConvertibleGetModelResource<ResponseModel, ResultModel> @PublishedApi internal constructor(
    override val httpClient: HttpClient,
    options: Gw2ResourceOptions,
    private val responseTypeInfo: GenericTypeInfo<ResponseModel>,
    private val resultTypeInfo: GenericTypeInfo<ResultModel>,
    private val convert: (ResponseModel) -> ResultModel
) : ConvertibleGetResource<ResponseModel, ResultModel>(responseTypeInfo, resultTypeInfo), Gw2ResourceOptions by options, GetModel<ResultModel> {
    private val context: () -> String = { "Request for ${responseTypeInfo.toDisplayableString()} with conversion to ${resultTypeInfo.toDisplayableString()}." }
    private val parameters: HttpRequestBuilder.() -> Unit = { }

    override suspend fun model(
        options: Gw2HttpOptions
    ): GetResult<ResultModel> = options.get(context, parameters) { result ->
        GetResult.Success(result.response, convert(result.body))
    }

    override suspend fun modelOrThrow(options: Gw2HttpOptions): ResultModel = model(options).getOrThrow()
    override suspend fun modelOrNull(options: Gw2HttpOptions): ResultModel? = model(options).getOrNull()
}

inline fun <reified ResponseModel, reified ResultModel> ResourceDependencies.convertibleGetModelResource(
    options: Gw2ResourceOptions,
    noinline convert: (ResponseModel) -> ResultModel
): ConvertibleGetModelResource<ResponseModel, ResultModel> = ConvertibleGetModelResource(
    httpClient,
    options,
    genericTypeInfo(),
    genericTypeInfo(),
    convert
)