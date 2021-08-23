package com.bselzer.library.gw2.v2.chatlink

import com.bselzer.library.kotlin.extension.function.collection.toByteArray
import com.bselzer.library.kotlin.extension.function.collection.toInt

abstract class IdLink(
    var id: Int = 0
) : ChatLink()
{
    override fun getData(): ByteArray = id.toByteArray()

    override fun decode(bytes: ArrayDeque<Byte>)
    {
        id = bytes.toInt()
    }
}