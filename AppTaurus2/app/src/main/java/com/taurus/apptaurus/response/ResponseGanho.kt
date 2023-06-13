package com.taurus.apptaurus.response

data class ResponseGanho(
    val id: Int?,
    val name: String?,
    val value: Double?,
    val category: String = "Receita",
    val user: User?,
    val created_at: String?
)
