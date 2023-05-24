package com.taurus.apptaurus

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction

class TelaIntro1 : AppCompatActivity() {

    lateinit var btnIntro1: Button;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        btnIntro1 = findViewById(R.id.btn_prox_intro1);

        btnIntro1.setOnClickListener {
            val intent = Intent(this, TelaIntro2::class.java)
            startActivity(intent)
        }
    }
}