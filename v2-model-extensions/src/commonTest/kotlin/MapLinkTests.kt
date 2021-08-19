import com.bselzer.library.gw2.v2.model.extension.common.chatlink.MapLink
import org.junit.Test
import kotlin.test.assertEquals

class MapLinkTests
{
    private companion object
    {
        val mapping: Map<String, Int> = mapOf(
            "[&BDgAAAA=]" to 56,
            "[&BEgAAAA=]" to 72,
            "[&BDkDAAA=]" to 825,
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
            val output = MapLink(id = id).encode()

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
            val output = MapLink().apply {
                decode(link)
            }

            // Assert
            assertEquals(id, output.id)
        }
    }
}