package com.taurus.apptaurus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity

class TelaLgpd : AppCompatActivity() {

    lateinit var btnIntro2: Button;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_lgpd)

        btnIntro2 = findViewById(R.id.voltar);

        btnIntro2.setOnClickListener {
            val intent = Intent(this, CadastroTela::class.java)
            startActivity(intent)
        }

    }
}