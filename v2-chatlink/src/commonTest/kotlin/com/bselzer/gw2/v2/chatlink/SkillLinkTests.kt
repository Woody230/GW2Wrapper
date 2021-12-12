package com.bselzer.gw2.v2.chatlink

class SkillLinkTests : IdLinkTests<SkillLink>() {
    override val instance: SkillLink = SkillLink()

    override val mapping: Map<String, Int> = mapOf(
        "[&BucCAAA=]" to 743,
        "[&BnMVAAA=]" to 5491,
        "[&Bn0VAAA=]" to 5501,
    )
}