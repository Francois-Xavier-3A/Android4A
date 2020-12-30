package com.example.android4a.presentation.main

import com.example.android4a.domain.entity.Monster

data class RestMonsterResponce(
    var count: Int,

    val next: String,

    val results: MutableList<Monster>) {
}