package com.taurus.apptaurus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.taurus.apptaurus.external.Apis
import com.taurus.apptaurus.request.UsuarioLogin
import com.taurus.apptaurus.response.UsuarioDados
import com.taurus.apptaurus.util.UserManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_home)

        val email = intent.getStringExtra("email")
        val password = intent.getStringExtra("senha")

        val api = Apis.getApiUsuarios()

        verificarAutenticacao()

    }

    fun verificarAutenticacao() {

        val apiUsuarios = Apis.getApiUsuarios()

        val email = intent.getStringExtra("email")
        val password = intent.getStringExtra("password")

        val tvAutenticacao = findViewById<TextView>(R.id.valorTotal)

        val login = UsuarioLogin(email.toString(), password.toString())
        val request = apiUsuarios.getPorLoginSenha(login)

        val idUser = UserManager.userId

        val requestTeste = apiUsuarios.getDados(idUser)


        requestTeste.enqueue(object : Callback<UsuarioDados> {
            override fun onResponse(call: Call<UsuarioDados>, response: Response<UsuarioDados>) {
                if (response.isSuccessful) {
                    if (response.body()?.id != null) {
                        val valorConta = response.body()?.valueInAccount
                        tvAutenticacao.text = valorConta.toString()
                    }
                }
            }

            override fun onFailure(call: Call<UsuarioDados>, t: Throwable) {
                tvAutenticacao.text = "Erro na api: ${t.message}"
                println(t.printStackTrace())
            }

        })
    }

}