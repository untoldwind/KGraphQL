package com.apurebase.kgraphql.schema.scalar

import com.fasterxml.jackson.databind.util.RawValue

interface RawScalarCoercion<T> : ScalarCoercion<T, RawValue>
