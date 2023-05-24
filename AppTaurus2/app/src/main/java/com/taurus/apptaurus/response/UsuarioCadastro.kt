package com.taurus.apptaurus.response

import java.util.*

data class UsuarioCadastro(
    val name: String?,
    val cpf: String?,
    val email: String?,
    val password: String?,
    val birthDate: Date?,
    val valueInAccount: Double
)
