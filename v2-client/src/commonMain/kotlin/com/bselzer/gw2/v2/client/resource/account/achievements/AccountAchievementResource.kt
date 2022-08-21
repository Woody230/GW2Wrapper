package com.bselzer.gw2.v2.client.resource.account.achievements

import com.bselzer.gw2.v2.client.instance.base.Gw2Resource
import com.bselzer.gw2.v2.client.request.model.GetModels
import com.bselzer.gw2.v2.model.account.achievement.AccountAchievement

interface AccountAchievementResource : Gw2Resource, GetModels<AccountAchievement>