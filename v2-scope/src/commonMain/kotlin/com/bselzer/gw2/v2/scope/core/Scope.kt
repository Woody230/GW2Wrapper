package com.bselzer.gw2.v2.scope.core

// TODO processor module
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.FIELD)
@Repeatable
@Retention(AnnotationRetention.SOURCE)
@MustBeDocumented
annotation class Scope(val requirement: Requirement, vararg val permissions: Permission)