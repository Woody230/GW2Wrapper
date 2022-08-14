package com.bselzer.gw2.v2.client.resource.account

import com.bselzer.gw2.v2.client.instance.base.Gw2Resource
import com.bselzer.gw2.v2.client.request.model.GetModel
import com.bselzer.gw2.v2.model.account.Account

interface AccountResource : Gw2Resource, GetModel<Account>