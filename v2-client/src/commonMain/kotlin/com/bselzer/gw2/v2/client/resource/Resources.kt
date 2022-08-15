package com.bselzer.gw2.v2.client.resource

import com.bselzer.gw2.v2.client.instance.base.Gw2Resource
import com.bselzer.gw2.v2.client.instance.base.ResourceDependencies
import com.bselzer.gw2.v2.client.instance.model.getModelResource
import com.bselzer.gw2.v2.client.request.model.GetModel
import com.bselzer.gw2.v2.client.resource.account.AccountResource
import com.bselzer.gw2.v2.model.account.Account
import com.bselzer.gw2.v2.scope.core.Permission
import com.bselzer.gw2.v2.scope.core.Requirement
import com.bselzer.gw2.v2.scope.core.Scope

fun ResourceDependencies.accountResource(): AccountResource {
    val options = resourceOptions(
        path = "account",
        scopes = listOf(
            Scope(Requirement.REQUIRED, Permission.ACCOUNT),
            Scope(Requirement.OPTIONAL, Permission.GUILDS, Permission.PROGRESSION)
        )
    )

    val delegate = getModelResource<Account>(options)
    return object : AccountResource, Gw2Resource by delegate, GetModel<Account> by delegate {}
}