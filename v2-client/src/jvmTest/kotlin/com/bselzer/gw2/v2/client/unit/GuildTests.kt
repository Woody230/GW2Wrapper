package com.bselzer.gw2.v2.client.unit

import com.bselzer.gw2.v2.model.guild.upgrade.BankTabUpgrade
import com.bselzer.gw2.v2.model.guild.upgrade.ClaimableUpgrade
import com.bselzer.gw2.v2.model.guild.upgrade.cost.CollectibleUpgradeCost
import com.bselzer.gw2.v2.model.guild.upgrade.cost.ItemUpgradeCost
import io.ktor.client.engine.mock.*
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class GuildTests : BaseUnitTests() {
    override fun createEngineConfig(): MockEngineConfig.() -> Unit = {
        exhaust(url = "https://api.guildwars2.com/v2/guild/upgrades?ids=all", content = getGuildUpgradeResource())
    }

    /**
     * Verifies that polymorphic deserialization works with the guild upgrade and guild upgrade cost models.
     */
    @Test
    fun upgrades() {
        // Act
        val upgrades = use { guild.upgrades() }.associateBy { it.id }

        // Assert

        // Emergency Waypoint
        val claimable = upgrades[178]
        assertTrue(claimable is ClaimableUpgrade)
        assertEquals("Emergency Waypoint", claimable.name)

        val item = claimable.costs.single()
        assertTrue(item is ItemUpgradeCost)
        assertEquals(1, item.count)
        assertEquals("Emergency Waypoint Tactic", item.name)
        assertEquals(81488, item.itemId)

        // Guild Treasure Trove
        val bankBag = upgrades[55]
        assertTrue(bankBag is BankTabUpgrade)
        assertEquals("Guild Treasure Trove", bankBag.name)
        assertEquals(100, bankBag.maxSlots)

        val collectible = bankBag.costs.first()
        assertTrue(collectible is CollectibleUpgradeCost)
        assertEquals(1500, collectible.count)
        assertEquals("Guild Favor", collectible.name)
        assertEquals(70701, collectible.itemId)
    }
}