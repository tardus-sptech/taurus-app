package com.taurus.apptaurus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.taurus.apptaurus.external.Apis
import com.taurus.apptaurus.request.Usuario
import com.taurus.apptaurus.request.UsuarioLogin
import com.taurus.apptaurus.util.UserManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginTela : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_login_tela)
    }


    fun entrar(componente:View) {
        val email = findViewById<EditText>(R.id.et_login)
        val password = findViewById<EditText>(R.id.et_senha)

        val apiUsuarios = Apis.getApiUsuarios()
        val login = UsuarioLogin(email.text.toString(), password.text.toString())
        val request = apiUsuarios.getPorLoginSenha(login)

        val erroLogin = findViewById<TextView>(R.id.erroLogin)

        val home = Intent(applicationContext,Home::class.java)


        request.enqueue(object: Callback<Usuario> {
            override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
                if(response.isSuccessful){
                        home.putExtra("email", email.text.toString())
                        home.putExtra("password", password.text.toString())

                    val userId = response.body()?.id
                    UserManager.updateUserId(userId)

                        startActivity(home)

                } else {
                    erroLogin.text = "Login e/ou senha inválidos"
                }
            }

            override fun onFailure(call: Call<Usuario>, t: Throwable) {
                erroLogin.text = "Erro de conexão com o servidor"
                println(t.printStackTrace())
            }
        })
    }


}