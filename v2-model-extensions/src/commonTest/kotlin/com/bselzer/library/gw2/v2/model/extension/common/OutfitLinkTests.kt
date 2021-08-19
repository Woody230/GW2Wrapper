package com.bselzer.library.gw2.v2.model.extension.common

import com.bselzer.library.gw2.v2.model.extension.common.chatlink.OutfitLink

class OutfitLinkTests : IdLinkTests<OutfitLink>()
{
    override val instance: OutfitLink = OutfitLink()

    override val mapping: Map<String, Int> = mapOf(
        "[&CwQAAAA=]" to 4
    )
}