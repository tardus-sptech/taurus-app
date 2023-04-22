package com.taurus.apptaurus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class CadastroTela : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_cadastro_tela)
    }
}