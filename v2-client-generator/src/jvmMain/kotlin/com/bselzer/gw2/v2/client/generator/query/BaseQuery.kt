package com.bselzer.gw2.v2.client.generator.query

import com.bselzer.gw2.v2.client.model.Language
import com.bselzer.gw2.v2.client.model.Token
import com.bselzer.gw2.v2.scope.core.Permission
import com.bselzer.gw2.v2.scope.core.Requirement
import com.bselzer.gw2.v2.scope.core.Scope
import com.bselzer.gw2.v2.scope.guild.GuildRanking
import com.bselzer.gw2.v2.scope.guild.GuildScope
import com.bselzer.ktx.poet.file.ClassImport
import com.bselzer.ktx.poet.file.Import
import com.squareup.kotlinpoet.*

abstract class BaseQuery(
    private val scopes: List<Scope>,
    private val guildScopes: List<GuildScope>,
    links: List<String>
) : Query {
    protected val languageParameter = ParameterSpec.builder("language", Language::class.asTypeName().copy(nullable = true)).build()
    protected val tokenParameter = ParameterSpec.builder("token", Token::class.asTypeName().copy(nullable = true)).build()

    override val imports: List<Import> = buildList {
        if (scopes.any() || guildScopes.any()) {
            add(ClassImport(Requirement::class))
        }

        if (scopes.any()) {
            add(ClassImport(Permission::class))
        }

        if (guildScopes.any()) {
            add(ClassImport(GuildRanking::class))
        }
    }

    private val scopeAnnotations = scopes.map { scope ->
        AnnotationSpec.builder(Scope::class).apply {
            addMember("${Requirement::class.simpleName}.${scope.requirement}")
            scope.permissions.forEach { permission -> addMember("${Permission::class.simpleName}.$permission") }
        }.build()
    }

    private val guildScopeAnnotations = guildScopes.map { scope ->
        AnnotationSpec.builder(GuildScope::class).apply {
            addMember("${Requirement::class.simpleName}.${scope.requirement}")
            scope.permissions.forEach { permission -> addMember("${GuildRanking::class.simpleName}.$permission") }
        }.build()
    }

    private val annotations = scopeAnnotations + guildScopeAnnotations

    private val linkKdoc = links.joinToString("\n") { link -> "@see <a href=\"$link\">the wiki</a>" }

    override fun function(path: String) = FunSpec.builder(name).apply {
        addKdoc(kdoc + "\n" + linkKdoc)
        this@BaseQuery.annotations.forEach { annotation -> addAnnotation(annotation) }
        addModifiers(KModifier.SUSPEND)
        addStatement(statement(path))
        this@BaseQuery.parameters.forEach { parameter -> addParameter(parameter) }
        returns(returnType)
    }.build()

    protected abstract val kdoc: String
    protected abstract val name: String
    protected open val parameters: List<ParameterSpec> = emptyList()
    protected abstract val returnType: TypeName

    protected abstract fun statement(path: String): String
}