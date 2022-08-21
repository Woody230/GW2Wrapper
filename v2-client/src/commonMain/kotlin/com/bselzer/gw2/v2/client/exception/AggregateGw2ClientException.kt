package com.bselzer.gw2.v2.client.exception

class AggregateGw2ClientException(
    message: String,
    val causes: List<Gw2ClientException> = emptyList()
) : Gw2ClientException(message, causes.firstOrNull())