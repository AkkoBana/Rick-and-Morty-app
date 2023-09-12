package com.akkobana.rickandmortyapp.utils

import com.akkobana.rickandmortyapp.data.model.FilterEntity

object FilterListEntity {
    val filterEntity = FilterEntity(
    listOf("status", "gender"),
    listOf("live", "dead", "unknown"),
    listOf("male", "female", "genderless", "unknown"),
    )
}