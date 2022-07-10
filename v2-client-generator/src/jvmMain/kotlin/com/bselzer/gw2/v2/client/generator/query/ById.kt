package com.bselzer.gw2.v2.client.generator.query

import com.bselzer.gw2.v2.scope.core.Scope
import com.bselzer.gw2.v2.scope.guild.GuildScope
import com.bselzer.ktx.poet.file.ClassImport
import com.bselzer.ktx.poet.file.Import
import com.bselzer.ktx.value.identifier.Identifiable
import com.bselzer.ktx.value.identifier.Identifier
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.asTypeName
import kotlin.reflect.KClass

class ById<Id, Value, Model>(
    private val idClass: KClass<Id>,
    private val modelClass: KClass<Model>,
    scopes: List<Scope> = emptyList(),
    guildScopes: List<GuildScope> = emptyList(),
    links: List<String> = emptyList()
) : BaseQuery(scopes, guildScopes, links) where Id : Identifier<Value>, Model : Identifiable<Id, Value> {
    override val kdoc = "@returns the [${modelClass.simpleName}] associated with the [${idClass.simpleName}]"
    override val name: String = "byId"
    override val returnType: TypeName = idClass.asTypeName()
    override fun statement(path: String): String = """
        |return getSingleById(id, \"$path\",
        |instance = { WvwAbility(id = it) })
    """.trimMargin()

    override val parameters: List<ParameterSpec> = super.parameters + ParameterSpec.builder("id", idClass).build()

    override val imports: List<Import> = super.imports + ClassImport(idClass) + ClassImport(modelClass)
}