package com.bselzer.gw2.v2.chatlink.build.profession

import com.bselzer.gw2.v2.chatlink.build.LinkComponent
import com.bselzer.ktx.function.collection.fill
import kotlinx.serialization.Serializable

@Serializable
open class LinkProfessionData : LinkComponent() {
    override val size: Int = 16

    override fun getData(): ByteArray = listOf<Byte>().fill(size) { 0 }.toByteArray()
}