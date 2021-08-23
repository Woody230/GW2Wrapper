package com.bselzer.library.gw2.v2.chatlink

import com.bselzer.library.kotlin.extension.function.collection.fill
import com.bselzer.library.kotlin.extension.function.collection.removeFirst
import com.bselzer.library.kotlin.extension.function.collection.toByteArray
import com.bselzer.library.kotlin.extension.function.collection.toInt
import com.bselzer.library.kotlin.extension.function.objects.toBits
import com.bselzer.library.kotlin.extension.function.objects.toByte

/**
 * A link to an item.
 */
class ItemLink(
    /**
     * The number of the item in the stack.
     */
    var count: Byte = 1,

    /**
     * The id of the item.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    var itemId: Int = 0,

    /**
     * The id of the skin.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skins">the wiki</a>
     */
    var skinId: Int = 0,

    /**
     * The id of the first upgrade component.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    var firstUpgradeId: Int = 0,

    /**
     * The id of the second upgrade component.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    var secondUpgradeId: Int = 0
) : ChatLink()
{
    override val header: Byte = 2

    override fun getData(): ByteArray
    {
        val isSkinned = skinId > 0
        val hasFirstUpgradeSlot = firstUpgradeId > 0
        val hasSecondUpgradeSlot = secondUpgradeId > 0
        val flags = listOf(isSkinned, hasFirstUpgradeSlot, hasSecondUpgradeSlot).toByte()
        var bytes = byteArrayOf(count) + itemId.toByteArray(take = 3, capacity = 3) + byteArrayOf(flags)

        // Only include the skin and upgrade slots if the flags exist.
        // Consequently, the link can have a variable length instead of being fixed and zeroed out.
        if (isSkinned) bytes += skinId.toByteArray(take = 3, capacity = 4)
        if (hasFirstUpgradeSlot) bytes += firstUpgradeId.toByteArray(take = 3, capacity = 4)
        if (hasSecondUpgradeSlot) bytes += secondUpgradeId.toByteArray(take = 3, capacity = 4)
        return bytes
    }

    override fun decode(bytes: ArrayDeque<Byte>)
    {
        if (bytes.size < 4)
        {
            throw IllegalArgumentException("Unable to decode ${this::class.simpleName}: at least 4 data bytes required for the item count and the item id")
        }

        count = bytes.removeFirst()
        itemId = bytes.removeFirst(take = 3).toInt()

        val flags = bytes.removeFirstOrNull()?.toBits() ?: return
        val isSkinned = flags[0]
        val hasFirstUpgradeSlot = flags[1]
        val hasSecondUpgradeSlot = flags[2]

        // Additional data may contain up to 12 bytes, so fill it to be consistent.
        val additionalData = ArrayDeque(bytes.fill(12) { 0 })
        if (isSkinned)
        {
            skinId = additionalData.removeFirst(take = 4).toInt()
        }
        if (hasFirstUpgradeSlot)
        {
            firstUpgradeId = additionalData.removeFirst(take = 4).toInt()
        }
        if (hasSecondUpgradeSlot)
        {
            secondUpgradeId = additionalData.removeFirst(take = 4).toInt()
        }
    }
}