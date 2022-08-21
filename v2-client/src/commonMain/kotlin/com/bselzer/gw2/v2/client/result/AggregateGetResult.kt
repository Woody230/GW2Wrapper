package com.bselzer.gw2.v2.client.result

import com.bselzer.gw2.v2.client.exception.AggregateGw2ClientException

typealias AggregateGetResult<Model> = List<GetResult<List<Model>>>

fun <Model> AggregateGetResult<Model>.getOrThrow(): List<Model> {
    val failed = filterIsInstance<GetResult.Failure<List<Model>>>()
    if (failed.any()) {
        val message = "${failed.count()} failed requests"
        val causes = failed.map { fail -> fail.exception() }
        throw AggregateGw2ClientException(message, causes)
    }

    return getOrEmpty()
}

fun <Model> AggregateGetResult<Model>.getOrEmpty(): List<Model> = filterIsInstance<GetResult.Success<List<Model>>>().flatMap { successful -> successful.body }