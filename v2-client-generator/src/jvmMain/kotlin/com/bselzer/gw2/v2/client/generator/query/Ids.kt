package com.bselzer.gw2.v2.client.generator.query

import com.bselzer.gw2.v2.scope.core.Scope
import com.bselzer.gw2.v2.scope.guild.GuildScope
import com.bselzer.ktx.poet.file.ClassImport
import com.bselzer.ktx.poet.file.Import
import com.bselzer.ktx.value.identifier.Identifiable
import com.bselzer.ktx.value.identifier.Identifier
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.asClassName
import com.squareup.kotlinpoet.asTypeName
import kotlin.reflect.KClass

class Ids<Id, Value, Model>(
    private val idClass: KClass<Id>,
    private val modelClass: KClass<Model>,
    scopes: List<Scope> = emptyList(),
    guildScopes: List<GuildScope> = emptyList(),
    links: List<String> = emptyList()
) : BaseQuery(scopes, guildScopes, links) where Id : Identifier<Value>, Model : Identifiable<Id, Value> {
    override val kdoc = "@returns the [${idClass.simpleName}]s for the currently available [${modelClass.simpleName}]s"
    override val name: String = "ids"
    override val returnType: TypeName = List::class.asClassName().parameterizedBy(idClass.asTypeName())
    override fun statement(path: String): String = "return getIds(path = \"$path\")"

    override val imports: List<Import>
        get() = super.imports + ClassImport(idClass) + ClassImport(modelClass)
}