package com.bselzer.gw2.v2.client.options

import com.bselzer.gw2.v2.client.result.Gw2Result

interface Gw2ResponseOptions {
    /**
     * The block for performing an action when the result is successful.
     */
    val onSuccess: (Gw2Result.Success) -> Unit

    /**
     * The block for performing an action when the result is a failure.
     */
    val onFailure: (Gw2Result.Failure) -> Unit

    /**
     * Performs this [onSuccess] and [onFailure] first, then the [other] [Gw2ResponseOptions.onSuccess] and [Gw2ResponseOptions.onFailure]
     */
    fun merge(other: Gw2ResponseOptions): Gw2ResponseOptions = ResponseOptions(
        onSuccess = { success ->
            onSuccess(success)
            other.onSuccess(success)
        },
        onFailure = { failure ->
            onFailure(failure)
            other.onFailure(failure)
        }
    )

    companion object : Gw2ResponseOptions by ResponseOptions()
}

data class ResponseOptions(
    override val onSuccess: (Gw2Result.Success) -> Unit = {},
    override val onFailure: (Gw2Result.Failure) -> Unit = {}
) : Gw2ResponseOptions