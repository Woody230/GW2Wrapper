package com.bselzer.gw2.v2.client.instance.base

import com.bselzer.gw2.v2.client.exception.AggregateException
import kotlin.jvm.JvmInline

@JvmInline
class AggregateListResult<Model>(val results: List<Result<List<Model>>>) {
    val exceptions: List<Throwable>
        get() = results.mapNotNull { result -> result.exceptionOrNull() }

    private val models: List<Model>
        get() = results.flatMap { result -> result.getOrNull() ?: emptyList() }

    fun getOrThrow(): List<Model> {
        if (exceptions.any()) {
            throw AggregateException(causes = exceptions.toTypedArray())
        }

        return models
    }

    fun getOrEmpty(): List<Model> = models
}