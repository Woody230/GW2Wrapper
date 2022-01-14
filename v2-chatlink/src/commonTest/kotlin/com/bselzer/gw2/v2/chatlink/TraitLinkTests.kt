package com.bselzer.gw2.v2.chatlink

class TraitLinkTests : IdLinkTests<TraitLink>() {
    override val instance: TraitLink = TraitLink()

    override val mapping: Map<String, Int> = mapOf(
        "[&B/IDAAA=]" to 1010,
    )
}