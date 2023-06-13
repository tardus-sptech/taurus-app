package com.taurus.apptaurus.response

import java.util.*

data class ResponseGasto(
    val id: Int?,
    val name: String?,
    val value: Double?,
    val category: Category?,
    val user: User?,
    val created_at: String?
)
