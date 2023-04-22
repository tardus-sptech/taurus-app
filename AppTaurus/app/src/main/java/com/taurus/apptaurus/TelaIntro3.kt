package com.taurus.apptaurus

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class TelaIntro3 : AppCompatActivity() {

    lateinit var btnCad: Button;
    lateinit var btnLog: Button;

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_tela_intro3)

        btnCad = findViewById(R.id.btn_cad);
        btnLog = findViewById(R.id.btn_log);

        btnCad.setOnClickListener {
            val intent = Intent(this, CadastroTela::class.java)
            startActivity(intent)
        }

        btnLog.setOnClickListener {
            val intent = Intent(this, LoginTela::class.java)
            startActivity(intent)
        }
    }
}