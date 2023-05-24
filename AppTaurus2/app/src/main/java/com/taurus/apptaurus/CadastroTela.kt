package com.taurus.apptaurus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.taurus.apptaurus.external.Apis
import com.taurus.apptaurus.request.Usuario
import com.taurus.apptaurus.response.UsuarioCadastro
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CadastroTela : AppCompatActivity() {

    lateinit var btnIntro2: TextView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_cadastro_tela)

        btnIntro2 = findViewById<TextView>(R.id.termosUso);

        btnIntro2.setOnClickListener {
            val intent = Intent(this, TelaLgpd::class.java)
            startActivity(intent)
        }
    }


    fun cadastrar(componente: View) {
        val name = findViewById<EditText>(R.id.et_cadastro_nome)
        val email = findViewById<EditText>(R.id.et_cadastro_email)
        val password = findViewById<EditText>(R.id.et_cadastro_senha)

        val apiUsuarios = Apis.getApiUsuarios()
        val cadastro = UsuarioCadastro(name.text.toString(), null, email.text.toString(), password.text.toString(), null, 0.0)
        val request = apiUsuarios.postCadastrar(cadastro)
        val telaLogin = Intent(this, LoginTela::class.java)

        val erroLogin = findViewById<TextView>(R.id.erroLogin)

        val home = Intent(applicationContext,Home::class.java)


        request.enqueue(object: Callback<Usuario> {
            override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
                if(response.isSuccessful){

                    startActivity(telaLogin)

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