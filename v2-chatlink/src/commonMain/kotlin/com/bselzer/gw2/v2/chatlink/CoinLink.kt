package com.bselzer.gw2.v2.chatlink

import com.bselzer.ktx.function.collection.toByteArray
import com.bselzer.ktx.function.collection.toInt

/**
 * A link to an amount of coins.
 */
class CoinLink(
    /**
     * The number of copper coins.
     */
    var coins: Int = 0
) : ChatLink() {
    override val header: Byte = 1

    override fun getData(): ByteArray = coins.toByteArray()

    override fun decode(bytes: ArrayDeque<Byte>) {
        coins = bytes.toInt()
    }
}