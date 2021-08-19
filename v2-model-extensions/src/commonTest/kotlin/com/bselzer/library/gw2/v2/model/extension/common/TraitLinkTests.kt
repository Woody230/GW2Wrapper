package com.bselzer.library.gw2.v2.model.extension.common

import com.bselzer.library.gw2.v2.model.extension.common.chatlink.TraitLink

class TraitLinkTests : IdLinkTests<TraitLink>()
{
    override val instance: TraitLink = TraitLink()

    override val mapping: Map<String, Int> = mapOf(
        "[&B/IDAAA=]" to 1010,
    )
}