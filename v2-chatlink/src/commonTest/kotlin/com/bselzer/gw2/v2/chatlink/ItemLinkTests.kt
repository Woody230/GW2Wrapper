package com.bselzer.gw2.v2.chatlink

import com.bselzer.gw2.v2.model.item.ItemId
import com.bselzer.gw2.v2.model.skin.SkinId
import kotlin.test.Test
import kotlin.test.assertEquals

class ItemLinkTests {
    private companion object {
        val mapping: Map<String, ItemId> = mapOf(
            "[&AgGqtgAA]" to 46762,
            "[&AgH1WQAA]" to 23029,
            "[&AgH2WQAA]" to 23030,
            "[&AgH3WQAA]" to 23031,
            "[&AgEAWgAA]" to 23040,
        ).mapValues { kvp -> ItemId(kvp.value) }
    }

    @Test
    fun encodeId() {
        for (input in mapping) {
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
    fun decodeId() {
        for (input in mapping) {
            // Arrange
            val link = input.key
            val id = input.value

            // Act
            val output = ItemLink().apply {
                decode(link)
            }

            // Assert
            assertEquals(1, output.count)
            assertEquals(id, output.itemId)
            assertEquals(0, output.skinId.value)
            assertEquals(0, output.firstUpgradeId.value)
            assertEquals(0, output.secondUpgradeId.value)
        }
    }

    @Test
    fun encode_WithUpgrade() {
        // Arrange
        val link = "[&AgGqtgBA/18AAA==]"
        val id = ItemId(46762)
        val firstUpgradeId = ItemId(24575)

        // Act
        val output = ItemLink(itemId = id, firstUpgradeId = firstUpgradeId).encode()

        // Assert
        assertEquals(link, output)
    }

    @Test
    fun decode_WithUpgrade() {
        // Arrange
        val link = "[&AgGqtgBA/18AAA==]"
        val id = ItemId(46762)
        val firstUpgradeId = ItemId(24575)

        // Act
        val output = ItemLink().apply {
            decode(link)
        }

        // Assert
        assertEquals(1, output.count)
        assertEquals(id, output.itemId)
        assertEquals(0, output.skinId.value)
        assertEquals(firstUpgradeId, output.firstUpgradeId)
        assertEquals(0, output.secondUpgradeId.value)
    }

    @Test
    fun encode_WithUpgrades() {
        // Arrange
        val link = "[&AgGqtgBg/18AACdgAAA=]"
        val id = ItemId(46762)
        val firstUpgradeId = ItemId(24575)
        val secondUpgradeId = ItemId(24615)

        // Act
        val output = ItemLink(itemId = id, firstUpgradeId = firstUpgradeId, secondUpgradeId = secondUpgradeId).encode()

        // Assert
        assertEquals(link, output)
    }

    @Test
    fun decode_WithUpgrades() {
        // Arrange
        val link = "[&AgGqtgBg/18AACdgAAA=]"
        val id = ItemId(46762)
        val firstUpgradeId = ItemId(24575)
        val secondUpgradeId = ItemId(24615)

        // Act
        val output = ItemLink().apply {
            decode(link)
        }

        // Assert
        assertEquals(1, output.count)
        assertEquals(id, output.itemId)
        assertEquals(0, output.skinId.value)
        assertEquals(firstUpgradeId, output.firstUpgradeId)
        assertEquals(secondUpgradeId, output.secondUpgradeId)
    }

    @Test
    fun encode_WithSkin() {
        // Arrange
        val link = "[&AgGqtgCAfQ4AAA==]"
        val id = ItemId(46762)
        val skinId = SkinId(3709)

        // Act
        val output = ItemLink(itemId = id, skinId = skinId).encode()

        // Assert
        assertEquals(link, output)
    }

    @Test
    fun decode_WithSkin() {
        // Arrange
        val link = "[&AgGqtgCAfQ4AAA==]"
        val id = ItemId(46762)
        val skinId = SkinId(3709)

        // Act
        val output = ItemLink().apply {
            decode(link)
        }

        // Assert
        assertEquals(1, output.count)
        assertEquals(id, output.itemId)
        assertEquals(skinId, output.skinId)
        assertEquals(0, output.firstUpgradeId.value)
        assertEquals(0, output.secondUpgradeId.value)
    }

    @Test
    fun encode_WithSkin_WithUpgrade() {
        // Arrange
        val link = "[&AgGqtgDAfQ4AAP9fAAA=]"
        val id = ItemId(46762)
        val skinId = SkinId(3709)
        val firstUpgradeId = ItemId(24575)

        // Act
        val output = ItemLink(itemId = id, skinId = skinId, firstUpgradeId = firstUpgradeId).encode()

        // Assert
        assertEquals(link, output)
    }

    @Test
    fun decode_WithSkin_WithUpgrade() {
        // Arrange
        val link = "[&AgGqtgDAfQ4AAP9fAAA=]"
        val id = ItemId(46762)
        val skinId = SkinId(3709)
        val firstUpgradeId = ItemId(24575)

        // Act
        val output = ItemLink().apply {
            decode(link)
        }

        // Assert
        assertEquals(1, output.count)
        assertEquals(id, output.itemId)
        assertEquals(skinId, output.skinId)
        assertEquals(firstUpgradeId, output.firstUpgradeId)
        assertEquals(0, output.secondUpgradeId.value)
    }

    @Test
    fun encode_WithSkin_WithUpgrades() {
        // Arrange
        val link = "[&AgGqtgDgfQ4AAP9fAAAnYAAA]"
        val id = ItemId(46762)
        val skinId = SkinId(3709)
        val firstUpgradeId = ItemId(24575)
        val secondUpgradeId = ItemId(24615)

        // Act
        val output = ItemLink(itemId = id, skinId = skinId, firstUpgradeId = firstUpgradeId, secondUpgradeId = secondUpgradeId).encode()

        // Assert
        assertEquals(link, output)
    }

    @Test
    fun decode_WithSkin_WithUpgrades() {
        // Arrange
        val link = "[&AgGqtgDgfQ4AAP9fAAAnYAAA]"
        val id = ItemId(46762)
        val skinId = SkinId(3709)
        val firstUpgradeId = ItemId(24575)
        val secondUpgradeId = ItemId(24615)

        // Act
        val output = ItemLink().apply {
            decode(link)
        }

        // Assert
        assertEquals(1, output.count)
        assertEquals(id, output.itemId)
        assertEquals(skinId, output.skinId)
        assertEquals(firstUpgradeId, output.firstUpgradeId)
        assertEquals(secondUpgradeId, output.secondUpgradeId)
    }
}