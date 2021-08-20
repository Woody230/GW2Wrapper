package com.bselzer.library.gw2.v2.model.extension.common.chatlink.build.profession

import com.bselzer.library.gw2.v2.model.extension.common.chatlink.build.LinkComponent
import com.bselzer.library.kotlin.extension.function.common.collection.fill
import kotlinx.serialization.Serializable

@Serializable
open class LinkProfessionData : LinkComponent()
{
    override val size: Int = 16

    override fun getData(): ByteArray = listOf<Byte>().fill(size) { 0 }.toByteArray()
}