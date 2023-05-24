package com.taurus.apptaurus.request

import java.util.*

data class Usuario (

    val id: Int,
    val name: String,
    val cpf: String,
    val birthDate: Date,
    val email: String
)