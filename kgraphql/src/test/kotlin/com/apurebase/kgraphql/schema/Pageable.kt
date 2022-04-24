package com.apurebase.kgraphql.schema

data class Pageable<T>(val total: Long, val first: T?, val items: List<T>)
