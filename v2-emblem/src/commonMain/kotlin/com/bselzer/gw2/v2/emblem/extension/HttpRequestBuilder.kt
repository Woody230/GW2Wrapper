package com.bselzer.gw2.v2.emblem.extension

import com.bselzer.gw2.v2.emblem.constant.Parameters
import com.bselzer.gw2.v2.emblem.request.EmblemRequestOptions
import io.ktor.client.request.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

/**
 * Sets the options if the [options] are not empty.
 */
internal fun HttpRequestBuilder.options(options: Collection<EmblemRequestOptions>) {
    if (options.isNotEmpty()) {
        parameter(Parameters.OPTIONS, options.encodeOptions())
    }
}

/**
 * Encodes the enum options into a comma separated list of strings.
 */
internal fun Collection<EmblemRequestOptions>.encodeOptions(): String = joinToString(separator = ",") { option -> Json.encodeToString(option) }