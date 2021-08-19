package com.bselzer.library.gw2.v2.model.extension.common

import com.bselzer.library.gw2.v2.model.extension.common.chatlink.SkinLink

class SkinLinkTests : IdLinkTests<SkinLink>()
{
    override val instance: SkinLink = SkinLink()

    override val mapping: Map<String, Int> = mapOf(
        "[&CgQAAAA=]" to 4
    )
}