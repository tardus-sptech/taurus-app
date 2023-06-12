package com.taurus.apptaurus.util


object UserManager {

    var userId: Int? = null
    var userNome: String? = null

    fun updateUserId(id: Int?) {
            userId = id
    }

    fun updateNome(nome: String?) {
            userNome = nome
    }

}
