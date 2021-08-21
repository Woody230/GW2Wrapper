package com.bselzer.library.gw2.v2.model.enumeration.common.extension.profession

import com.bselzer.library.gw2.v2.model.common.profession.Training
import com.bselzer.library.gw2.v2.model.enumeration.common.profession.TrainingCategory
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [Training.category] as a [TrainingCategory]
 */
fun Training.category(): TrainingCategory? = category.enumValueOrNull<TrainingCategory>()