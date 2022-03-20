package com.bselzer.gw2.v2.model.backstory.question

import com.bselzer.gw2.v2.model.identifier.IntIdentifier
import kotlinx.serialization.Serializable

@Serializable
value class BackstoryQuestionId(override val value: Int = 0) : IntIdentifier