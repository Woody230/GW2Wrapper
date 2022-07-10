package com.bselzer.gw2.v2.client.generator.query

import com.bselzer.ktx.poet.file.Import
import com.squareup.kotlinpoet.FunSpec

interface Query {
    val imports: List<Import>
        get() = emptyList()

    fun function(path: String): FunSpec
}