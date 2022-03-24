package com.bselzer.gw2.v2.chatlink

import com.bselzer.gw2.v2.model.skill.SkillId

/**
 * A link to a skill effect, buff, or ability.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skills">the wiki for ability ids</a>
 */
class SkillLink(id: SkillId = SkillId()) : IdLink(id.value) {
    override val header: Byte = 6
}