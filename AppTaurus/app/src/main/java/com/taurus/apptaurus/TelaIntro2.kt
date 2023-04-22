package com.taurus.apptaurus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class TelaIntro2 : AppCompatActivity() {

    lateinit var btnIntro2: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_tela_intro2)

        btnIntro2 = findViewById(R.id.btn_prox_intro2);

        btnIntro2.setOnClickListener {
            val intent = Intent(this, TelaIntro3::class.java)
            startActivity(intent)
        }
    }
}