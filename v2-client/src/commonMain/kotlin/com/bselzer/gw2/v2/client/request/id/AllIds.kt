package com.bselzer.gw2.v2.client.request.id

import com.bselzer.ktx.value.identifier.Identifiable
import com.bselzer.ktx.value.identifier.Identifier

interface AllIds<Model, Id, Value> : GetByAllIds<Model, Id, Value>, Ids<Model, Id, Value> where Id : Identifier<Value>, Model : Identifiable<Id, Value>