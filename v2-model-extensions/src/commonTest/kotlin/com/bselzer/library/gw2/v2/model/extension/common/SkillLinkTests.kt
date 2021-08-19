package com.bselzer.library.gw2.v2.model.extension.common

import com.bselzer.library.gw2.v2.model.extension.common.chatlink.SkillLink

class SkillLinkTests : IdLinkTests<SkillLink>()
{
    override val instance: SkillLink = SkillLink()

    override val mapping: Map<String, Int> = mapOf(
        "[&BucCAAA=]" to 743,
        "[&BnMVAAA=]" to 5491,
        "[&Bn0VAAA=]" to 5501,
    )
}