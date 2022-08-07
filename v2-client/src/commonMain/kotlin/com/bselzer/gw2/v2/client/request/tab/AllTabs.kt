package com.bselzer.gw2.v2.client.request.tab

import com.bselzer.ktx.value.identifier.Identifiable
import com.bselzer.ktx.value.identifier.Identifier

interface AllTabs<Model, Tab, Value> : GetByAllTabs<Model, Tab, Value>, GetByTab<Model, Tab, Value>, GetByTabs<Model, Tab, Value>,
    GetTabs<Tab> where Tab : Identifier<Value>, Model : Identifiable<Tab, Value>