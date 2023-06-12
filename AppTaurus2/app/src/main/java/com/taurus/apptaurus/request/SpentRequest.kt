package com.taurus.apptaurus.request

data class SpentRequest(
    val name: String?,
    val value: Double?,
    val categoryId: Int?,
    val userId: Int?
)
