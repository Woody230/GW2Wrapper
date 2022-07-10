package com.bselzer.ktx.poet.file

import com.squareup.kotlinpoet.FileSpec
import kotlin.reflect.KClass

class ClassImport<Model>(
    private val modelClass: KClass<Model>,
    private vararg val names: String
) : Import where Model : Any {
    override fun FileSpec.Builder.addImport() = run {
        val names = when {
            names.isEmpty() -> arrayOf("")
            else -> names
        }

        addImport(modelClass, *names)
    }
}