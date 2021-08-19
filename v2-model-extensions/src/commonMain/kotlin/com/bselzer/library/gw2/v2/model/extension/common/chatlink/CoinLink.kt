package com.bselzer.library.gw2.v2.model.extension.common.chatlink

import com.bselzer.library.kotlin.extension.function.common.collection.toByteArray
import com.bselzer.library.kotlin.extension.function.common.collection.toInt

class CoinLink(
    /**
     * The number of copper coins.
     */
    var coins: Int = 0
) : ChatLink<CoinLink>()
{
    override val header: Byte = 1

    override fun getData(): ByteArray = coins.toByteArray()

    override fun decode(bytes: ByteArray): CoinLink = apply {
        coins = bytes.toInt()
    }
}