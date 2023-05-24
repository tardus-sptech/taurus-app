package com.taurus.apptaurus.external

import com.taurus.apptaurus.request.Usuario
import com.taurus.apptaurus.request.UsuarioLogin
import com.taurus.apptaurus.response.UsuarioCadastro
import com.taurus.apptaurus.response.UsuarioDados
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiUsuarios {

    @Headers("Content-Type: application/json")
    @POST("/api/users/login")
    fun getPorLoginSenha(@Body usuarioLogin: UsuarioLogin): Call<Usuario>

    @Headers("Content-Type: application/json")
    @GET("/api/users/{idUser}")
    fun getDados(@Path("idUser") idUser: Int?): Call<UsuarioDados>

    @Headers("Content-Type: application/json")
    @POST("/api/users")
    fun postCadastrar(@Body usuarioCadastro: UsuarioCadastro): Call<Usuario>

}