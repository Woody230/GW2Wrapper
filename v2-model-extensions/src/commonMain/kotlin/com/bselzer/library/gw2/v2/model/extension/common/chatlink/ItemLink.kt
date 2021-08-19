package com.bselzer.library.gw2.v2.model.extension.common.chatlink

import com.bselzer.library.kotlin.extension.function.common.collection.toInt

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
        val flags = encodeFlags(isSkinned, hasFirstUpgradeSlot, hasSecondUpgradeSlot)
        var bytes = byteArrayOf(count) + itemId.bytes(take = 3, slots = 3) + byteArrayOf(flags)

        // Only include the skin and upgrade slots if the flags exist.
        // Consequently, the link can have a variable length instead of being fixed and zeroed out.
        if (isSkinned) bytes += skinId.bytes(take = 3, slots = 4)
        if (hasFirstUpgradeSlot) bytes += firstUpgradeId.bytes(take = 3, slots = 4)
        if (hasSecondUpgradeSlot) bytes += secondUpgradeId.bytes(take = 3, slots = 4)
        return bytes
    }

    override fun decode(bytes: ByteArray)
    {
        if (bytes.size < 4)
        {
            throw IllegalArgumentException("Unable to decode ${this::class.simpleName}: at least 4 data bytes required for the item count and the item id")
        }

        count = bytes.first()
        itemId = bytes.copyOfRange(1, 3).toInt()

        val flags = decodeFlags(bytes.getOrNull(4) ?: return)
        val isSkinned = flags[0]
        val hasFirstUpgradeSlot = flags[1]
        val hasSecondUpgradeSlot = flags[2]

        val additionalData = bytes.copyOfRange(5, bytes.size - 1).toMutableList().apply {
            // Fill the remaining space if the data does not exist.
            (1..12 - size).forEach { _ -> add(0) }
        }.toByteArray()

        var group = 0
        if (isSkinned)
        {
            skinId = additionalData.decodeGroup(group)
            group += 1
        }
        if (hasFirstUpgradeSlot)
        {
            firstUpgradeId = additionalData.decodeGroup(group)
            group += 1
        }
        if (hasSecondUpgradeSlot)
        {
            secondUpgradeId = additionalData.decodeGroup(group)
            group += 1
        }
    }

    /**
     * @return the integer associated with the bytes in the [group]
     */
    private fun ByteArray.decodeGroup(group: Int): Int
    {
        val start = group * 4
        return copyOfRange(start, start + 3).toInt()
    }
}