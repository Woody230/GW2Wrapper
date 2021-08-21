package com.bselzer.library.gw2.v2.chatlink.common.build.profession

import com.bselzer.library.gw2.v2.chatlink.common.build.LinkComponent
import com.bselzer.library.kotlin.extension.function.common.collection.fill
import kotlinx.serialization.Serializable

@Serializable
open class LinkProfessionData : LinkComponent()
{
    override val size: Int = 16

    override fun getData(): ByteArray = listOf<Byte>().fill(size) { 0 }.toByteArray()
}