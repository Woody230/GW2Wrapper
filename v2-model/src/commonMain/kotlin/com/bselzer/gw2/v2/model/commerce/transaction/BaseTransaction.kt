package com.bselzer.gw2.v2.model.commerce.transaction

import com.bselzer.gw2.v2.model.extension.base.Identifiable
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
abstract class BaseTransaction(
    @SerialName("id")
    override val id: Long = 0,

    /**
     * The id of the item.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    @SerialName("item_id")
    val itemId: Int = 0,

    /**
     * The number of copper coins.
     */
    @SerialName("price")
    val price: Int = 0,

    /**
     * The number of the item with [itemId].
     */
    @SerialName("quantity")
    val count: Int = 0,

    /**
     * The date and time this transaction was created.
     */
    @SerialName("created")
    val createdAt: Instant = Instant.DISTANT_PAST
) : Identifiable<Long> {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as BaseTransaction

        if (id != other.id) return false
        if (itemId != other.itemId) return false
        if (price != other.price) return false
        if (count != other.count) return false
        if (createdAt != other.createdAt) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + itemId
        result = 31 * result + price
        result = 31 * result + count
        result = 31 * result + createdAt.hashCode()
        return result
    }
}