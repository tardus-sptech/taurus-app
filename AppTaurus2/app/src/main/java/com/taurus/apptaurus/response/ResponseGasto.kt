package com.taurus.apptaurus.response

import java.util.*

data class Category(
    val id: Int?,
    val description: String?,
    val value: Double?
)

data class User(
    val id: Int?,
    val name: String?,
    val cpf: String?,
    val birthDate: String?,
    val email: String?,
    val password: String?,
    val valueInAccount: Double?,
    val personId: String?,
    val logged: Boolean?
)

data class ResponseGasto(
    val id: Int?,
    val name: String?,
    val value: Double?,
    val category: Category?,
    val user: User?,
    val created_at: String?
)
