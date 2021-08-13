package com.bselzer.library.gw2.v2.annotation.common.scope

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.FIELD)
@Repeatable
@Retention(AnnotationRetention.SOURCE)
@MustBeDocumented
annotation class GuildScope(val requirement: Requirement, vararg val permissions: GuildRanking)