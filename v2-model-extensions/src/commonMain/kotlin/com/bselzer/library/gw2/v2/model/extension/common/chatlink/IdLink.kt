package com.bselzer.library.gw2.v2.model.extension.common.chatlink

import com.bselzer.library.kotlin.extension.function.common.collection.toByteArray
import com.bselzer.library.kotlin.extension.function.common.collection.toInt

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