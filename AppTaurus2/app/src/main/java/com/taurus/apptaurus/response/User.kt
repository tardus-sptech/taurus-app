package com.taurus.apptaurus.response

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
