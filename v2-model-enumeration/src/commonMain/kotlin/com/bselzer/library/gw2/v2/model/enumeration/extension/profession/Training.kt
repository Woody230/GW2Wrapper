package com.bselzer.library.gw2.v2.model.enumeration.extension.profession

import com.bselzer.library.gw2.v2.model.enumeration.profession.TrainingCategory
import com.bselzer.library.gw2.v2.model.profession.Training
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [Training.category] as a [TrainingCategory]
 */
fun Training.category(): TrainingCategory? = category.enumValueOrNull<TrainingCategory>()