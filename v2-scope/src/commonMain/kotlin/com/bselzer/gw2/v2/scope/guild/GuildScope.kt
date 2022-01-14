package com.bselzer.gw2.v2.scope.guild

import com.bselzer.gw2.v2.scope.core.Requirement

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.FIELD)
@Repeatable
@Retention(AnnotationRetention.SOURCE)
@MustBeDocumented
annotation class GuildScope(val requirement: Requirement, vararg val permissions: GuildRanking)