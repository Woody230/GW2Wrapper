package com.bselzer.gw2.v2.client.request.id

import com.bselzer.ktx.value.identifier.Identifiable
import com.bselzer.ktx.value.identifier.Identifier

interface AllIds<Model, Id, Value> : GetByAllIds<Model, Id, Value>, GetById<Model, Id, Value>, GetByIds<Model, Id, Value>,
    GetIds<Id> where Id : Identifier<Value>, Model : Identifiable<Id, Value>