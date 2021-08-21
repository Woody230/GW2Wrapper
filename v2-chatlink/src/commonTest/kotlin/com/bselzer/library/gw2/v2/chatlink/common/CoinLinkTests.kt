package com.bselzer.library.gw2.v2.chatlink.common

import kotlin.test.Test
import kotlin.test.assertEquals

class CoinLinkTests
{
    private companion object
    {
        val mapping: Map<String, Int> = mapOf(
            "[&AQAAAAA=]" to 0,
            "[&AQEAAAA=]" to 1,
            "[&AdsnAAA=]" to 10203
        )
    }

    @Test
    fun encode()
    {
        for (input in mapping)
        {
            // Arrange
            val link = input.key
            val coins = input.value

            // Act
            val output = CoinLink(coins).encode()

            // Assert
            assertEquals(link, output)
        }
    }

    @Test
    fun decode()
    {
        for (input in mapping)
        {
            // Arrange
            val link = input.key
            val coins = input.value

            // Act
            val output = CoinLink().apply {
                decode(link)
            }

            // Assert
            assertEquals(coins, output.coins)
        }
    }
}