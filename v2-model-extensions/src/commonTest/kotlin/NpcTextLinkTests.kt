import com.bselzer.library.gw2.v2.model.extension.common.chatlink.NpcTextLink
import org.junit.Test
import kotlin.test.assertEquals

class NpcTextLinkTests
{
    private companion object
    {
        val mapping: Map<String, Int> = mapOf(
            "[&AxcnAAA=]" to 10007,
            "[&AxgnAAA=]" to 10008,
            "[&AxknAAA=]" to 10009,
            "[&AyAnAAA=]" to 10016
        )
    }

    @Test
    fun encode()
    {
        for (input in mapping)
        {
            // Arrange
            val link = input.key
            val id = input.value

            // Act
            val output = NpcTextLink(id = id).encode()

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
            val id = input.value

            // Act
            val output = NpcTextLink().apply {
                decode(link)
            }

            // Assert
            assertEquals(id, output.id)
        }
    }
}