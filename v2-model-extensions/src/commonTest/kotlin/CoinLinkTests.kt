import com.bselzer.library.gw2.v2.model.extension.common.chatlink.CoinLink
import kotlin.test.Test
import kotlin.test.assertEquals

class CoinLinkTests
{
    private companion object
    {
        val mapping: Map<String, List<Any>> = mapOf(
            "[&AQAAAAA=]" to listOf(0),
            "[&AQEAAAA=]" to listOf(1),
            "[&AdsnAAA=]" to listOf(10203)
        )
    }

    @Test
    fun encode()
    {
        for (input in mapping)
        {
            // Arrange
            val link = input.key
            val coins = input.value.first() as Int

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
            val coins = input.value.first() as Int

            // Act
            val output = CoinLink().decode(link)

            // Assert
            assertEquals(coins, output.coins)
        }
    }
}