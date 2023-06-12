package com.taurus.apptaurus.request

import java.time.LocalDateTime

data class Spent(
    val id: Int,
    val name: String,
    val value: Double,
    val createdAt: LocalDateTime
)
