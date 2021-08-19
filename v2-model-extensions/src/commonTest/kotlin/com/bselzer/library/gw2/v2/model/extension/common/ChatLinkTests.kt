package com.bselzer.library.gw2.v2.model.extension.common

import com.bselzer.library.gw2.v2.model.extension.common.chatlink.ChatLink

abstract class ChatLinkTests<Link> where Link : ChatLink
{
    /**
     * The dummy instance of the link.
     */
    abstract val instance: Link

    /**
     * @return the decoded link
     */
    fun decode(encoded: String): Link = instance.apply {
        decode(encoded)
    }
}