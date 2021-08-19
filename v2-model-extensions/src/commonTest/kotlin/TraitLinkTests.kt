import com.bselzer.library.gw2.v2.model.extension.common.chatlink.TraitLink
import org.junit.Test
import kotlin.test.assertEquals

class TraitLinkTests
{
    private companion object
    {
        val mapping: Map<String, Int> = mapOf(
            "[&B/IDAAA=]" to 1010,
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
            val output = TraitLink(id = id).encode()

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
            val output = TraitLink().apply {
                decode(link)
            }

            // Assert
            assertEquals(id, output.id)
        }
    }
}