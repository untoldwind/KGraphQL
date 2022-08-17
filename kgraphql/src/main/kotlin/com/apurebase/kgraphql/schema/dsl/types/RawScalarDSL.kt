package com.apurebase.kgraphql.schema.dsl.types

import com.apurebase.kgraphql.schema.SchemaException
import com.apurebase.kgraphql.schema.model.ast.ValueNode
import com.apurebase.kgraphql.schema.scalar.ScalarCoercion
import com.apurebase.kgraphql.schema.scalar.RawScalarCoercion
import com.fasterxml.jackson.databind.util.RawValue
import kotlin.reflect.KClass

class RawScalarDSL<T : Any>(kClass: KClass<T>) : ScalarDSL<T, RawValue>(kClass) {

    override fun createCoercionFromFunctions(): ScalarCoercion<T, RawValue> {
        return object : RawScalarCoercion<T> {

            val serializeImpl = serialize ?: throw SchemaException(PLEASE_SPECIFY_COERCION)

            val deserializeImpl = deserialize ?: throw SchemaException(PLEASE_SPECIFY_COERCION)

            override fun serialize(instance: T): RawValue = serializeImpl(instance)

            override fun deserialize(raw: RawValue, valueNode: ValueNode?): T = deserializeImpl(raw)
        }
    }

}
