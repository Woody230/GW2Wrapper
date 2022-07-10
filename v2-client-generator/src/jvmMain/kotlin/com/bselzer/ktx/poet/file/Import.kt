package com.bselzer.ktx.poet.file

import com.squareup.kotlinpoet.FileSpec

interface Import {
    fun FileSpec.Builder.addImport(): FileSpec.Builder
}