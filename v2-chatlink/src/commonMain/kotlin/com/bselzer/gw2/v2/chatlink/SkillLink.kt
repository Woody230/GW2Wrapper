package com.bselzer.gw2.v2.chatlink

/**
 * A link to a skill effect, buff, or ability.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skills">the wiki for ability ids</a>
 */
class SkillLink(id: Int = 0) : IdLink(id) {
    override val header: Byte = 6
}