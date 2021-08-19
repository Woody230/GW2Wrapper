import com.bselzer.library.gw2.v2.model.extension.common.chatlink.SkillLink
import org.junit.Test
import kotlin.test.assertEquals

class SkillLinkTests
{
    private companion object
    {
        val mapping: Map<String, Int> = mapOf(
            "[&BucCAAA=]" to 743,
            "[&BnMVAAA=]" to 5491,
            "[&Bn0VAAA=]" to 5501,
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
            val output = SkillLink(id = id).encode()

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
            val output = SkillLink().apply {
                decode(link)
            }

            // Assert
            assertEquals(id, output.id)
        }
    }
}