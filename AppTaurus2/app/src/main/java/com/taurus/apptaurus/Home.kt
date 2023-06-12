package com.taurus.apptaurus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.google.android.material.bottomnavigation.BottomNavigationView
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

        verificarAutenticacao()

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        window.statusBarColor = ContextCompat.getColor(this, R.color.primary_color)

        val defaultFragment = HomeFragment()
        val bundle = Bundle()
        bundle.putString("nome", intent.getStringExtra("nome"))
        bundle.putString("personId", intent.getStringExtra("personId"))
        defaultFragment.arguments = bundle
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, defaultFragment)
            .commit()
        bottomNavigationView.setOnItemSelectedListener { menuItem ->

            when (menuItem.itemId) {
                R.id.menu_home -> {
                    val fragment = HomeFragment()
                    val bundle = Bundle()
                    bundle.putString("personId", intent.getStringExtra("personId"))
                    fragment.arguments = bundle
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, fragment)
                        .commit()
                    true
                }
                R.id.menu_analise -> {
                    val fragment = CategoriasFragment()
                    fragment.arguments = bundle
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, fragment)
                        .commit()
                    true
                }
                R.id.menu_noticias -> {
                    val fragment = HomeFragment()
                    val bundle = Bundle()
                    bundle.putString("personId", intent.getStringExtra("personId"))
                    fragment.arguments = bundle
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, fragment)
                        .commit()
                    true
                }
                R.id.menu_usuario -> {
                    val fragment = PerfilFragment()
                    fragment.arguments = bundle
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, fragment)
                        .commit()
                    true
                }
                else -> false
            }
        }

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