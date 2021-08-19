import com.bselzer.library.gw2.v2.model.extension.common.chatlink.ItemLink
import org.junit.Test
import kotlin.test.assertEquals

class ItemLinkTests
{
    private companion object
    {
        val mapping: Map<String, Int> = mapOf(
            "[&AgGqtgAA]" to 46762,
            "[&AgH1WQAA]" to 23029,
            "[&AgH2WQAA]" to 23030,
            "[&AgH3WQAA]" to 23031,
            "[&AgEAWgAA]" to 23040,
        )
    }

    @Test
    fun encodeId()
    {
        for (input in mapping)
        {
            // Arrange
            val link = input.key
            val id = input.value

            // Act
            val output = ItemLink(itemId = id).encode()

            // Assert
            assertEquals(link, output)
        }
    }

    @Test
    fun decodeId()
    {
        for (input in mapping)
        {
            // Arrange
            val link = input.key
            val id = input.value

            // Act
            val output = ItemLink().decode(link)

            // Assert
            assertEquals(1, output.count)
            assertEquals(id, output.itemId)
            assertEquals(0, output.skinId)
            assertEquals(0, output.firstUpgradeId)
            assertEquals(0, output.secondUpgradeId)
        }
    }

    @Test
    fun encode_WithUpgrade()
    {
        // Arrange
        val link = "[&AgGqtgBA/18AAA==]"
        val id = 46762
        val firstUpgradeId = 24575

        // Act
        val output = ItemLink(itemId = id, firstUpgradeId = firstUpgradeId).encode()

        // Assert
        assertEquals(link, output)
    }

    @Test
    fun decode_WithUpgrade()
    {
        // Arrange
        val link = "[&AgGqtgBA/18AAA==]"
        val id = 46762
        val firstUpgradeId = 24575

        // Act
        val output = ItemLink().decode(link)

        // Assert
        assertEquals(1, output.count)
        assertEquals(id, output.itemId)
        assertEquals(0, output.skinId)
        assertEquals(firstUpgradeId, output.firstUpgradeId)
        assertEquals(0, output.secondUpgradeId)
    }

    @Test
    fun encode_WithUpgrades()
    {
        // Arrange
        val link = "[&AgGqtgBg/18AACdgAAA=]"
        val id = 46762
        val firstUpgradeId = 24575
        val secondUpgradeId = 24615

        // Act
        val output = ItemLink(itemId = id, firstUpgradeId = firstUpgradeId, secondUpgradeId = secondUpgradeId).encode()

        // Assert
        assertEquals(link, output)
    }

    @Test
    fun decode_WithUpgrades()
    {
        // Arrange
        val link = "[&AgGqtgBg/18AACdgAAA=]"
        val id = 46762
        val firstUpgradeId = 24575
        val secondUpgradeId = 24615

        // Act
        val output = ItemLink().decode(link)

        // Assert
        assertEquals(1, output.count)
        assertEquals(id, output.itemId)
        assertEquals(0, output.skinId)
        assertEquals(firstUpgradeId, output.firstUpgradeId)
        assertEquals(secondUpgradeId, output.secondUpgradeId)
    }

    @Test
    fun encode_WithSkin()
    {
        // Arrange
        val link = "[&AgGqtgCAfQ4AAA==]"
        val id = 46762
        val skinId = 3709

        // Act
        val output = ItemLink(itemId = id, skinId = skinId).encode()

        // Assert
        assertEquals(link, output)
    }

    @Test
    fun decode_WithSkin()
    {
        // Arrange
        val link = "[&AgGqtgCAfQ4AAA==]"
        val id = 46762
        val skinId = 3709

        // Act
        val output = ItemLink().decode(link)

        // Assert
        assertEquals(1, output.count)
        assertEquals(id, output.itemId)
        assertEquals(skinId, output.skinId)
        assertEquals(0, output.firstUpgradeId)
        assertEquals(0, output.secondUpgradeId)
    }

    @Test
    fun encode_WithSkin_WithUpgrade()
    {
        // Arrange
        val link = "[&AgGqtgDAfQ4AAP9fAAA=]"
        val id = 46762
        val skinId = 3709
        val firstUpgradeId = 24575

        // Act
        val output = ItemLink(itemId = id, skinId = skinId, firstUpgradeId = firstUpgradeId).encode()

        // Assert
        assertEquals(link, output)
    }

    @Test
    fun decode_WithSkin_WithUpgrade()
    {
        // Arrange
        val link = "[&AgGqtgDAfQ4AAP9fAAA=]"
        val id = 46762
        val skinId = 3709
        val firstUpgradeId = 24575

        // Act
        val output = ItemLink().decode(link)

        // Assert
        assertEquals(1, output.count)
        assertEquals(id, output.itemId)
        assertEquals(skinId, output.skinId)
        assertEquals(firstUpgradeId, output.firstUpgradeId)
        assertEquals(0, output.secondUpgradeId)
    }

    @Test
    fun encode_WithSkin_WithUpgrades()
    {
        // Arrange
        val link = "[&AgGqtgDgfQ4AAP9fAAAnYAAA]"
        val id = 46762
        val skinId = 3709
        val firstUpgradeId = 24575
        val secondUpgradeId = 24615

        // Act
        val output = ItemLink(itemId = id, skinId = skinId, firstUpgradeId = firstUpgradeId, secondUpgradeId = secondUpgradeId).encode()

        // Assert
        assertEquals(link, output)
    }

    @Test
    fun decode_WithSkin_WithUpgrades()
    {
        // Arrange
        val link = "[&AgGqtgDgfQ4AAP9fAAAnYAAA]"
        val id = 46762
        val skinId = 3709
        val firstUpgradeId = 24575
        val secondUpgradeId = 24615

        // Act
        val output = ItemLink().decode(link)

        // Assert
        assertEquals(1, output.count)
        assertEquals(id, output.itemId)
        assertEquals(skinId, output.skinId)
        assertEquals(firstUpgradeId, output.firstUpgradeId)
        assertEquals(secondUpgradeId, output.secondUpgradeId)
    }
}