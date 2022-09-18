package com.bselzer.gw2.v2.client.options

import com.bselzer.gw2.v2.client.result.GetResult
import com.bselzer.gw2.v2.client.result.Gw2Result

data class Gw2ResponseOptions(
    /**
     * The block for performing an action when the HTTP result is successful.
     */
    val onSuccess: (Gw2Result.Success) -> Unit = {},

    /**
     * The block for performing an action when the HTTP result is a failure.
     */
    val onFailure: (Gw2Result.Failure) -> Unit = {},

    /**
     * The block for performing an action when the GET result is a success.
     */
    val onGetSuccess: (GetResult.Success<*>) -> Unit = {},

    /**
     * The block for performing an action when the GET result is a failure.
     */
    val onGetFailure: (GetResult.Failure<*>) -> Unit = {}
) {
    companion object {
        val Default = Gw2ResponseOptions()
    }

    /**
     * Performs this [onSuccess] and [onFailure] first, then the [other] [Gw2ResponseOptions.onSuccess] and [Gw2ResponseOptions.onFailure]
     */
    fun merge(other: Gw2ResponseOptions): Gw2ResponseOptions = Gw2ResponseOptions(
        onSuccess = { success ->
            onSuccess(success)
            other.onSuccess(success)
        },
        onFailure = { failure ->
            onFailure(failure)
            other.onFailure(failure)
        },
        onGetSuccess = { success ->
            onGetSuccess(success)
            other.onGetSuccess(success)
        },
        onGetFailure = { failure ->
            onGetFailure(failure)
            other.onGetFailure(failure)
        }
    )
}