package com.taurus.apptaurus.response

import java.util.*

data class UsuarioDados(

    val id: Int,
    val name: String,
    val cpf: String,
    val birthDate: Date,
    val email: String,
    val password: String,
    val valueInAccount: Double,
    val personId: String,
    val logged: Boolean
)
