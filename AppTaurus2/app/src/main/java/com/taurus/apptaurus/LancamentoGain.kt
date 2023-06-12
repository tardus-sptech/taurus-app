package com.taurus.apptaurus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.taurus.apptaurus.external.Apis
import com.taurus.apptaurus.request.Gain
import com.taurus.apptaurus.request.GainRequest
import com.taurus.apptaurus.util.UserManager
import retrofit2.*

class LancamentoGain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lancamento_gain)
    }

    fun addGain(componente: View) {
        val gainValue = findViewById<EditText>(R.id.et_gain_value)
        val gainDescription = findViewById<EditText>(R.id.et_gain_description)
        val idUser = UserManager.userId

        val apiEntry = Apis.getApiEntry()
        val entryGain = GainRequest(gainDescription.text.toString(), gainValue.text.toString().toDouble(), idUser)
        val request = apiEntry.GainResponse(entryGain)

        val homeIntent = Intent(applicationContext, Home::class.java)

        request.enqueue(object : Callback<Gain>{
            override fun onResponse(call: Call<Gain>, response: Response<Gain>) {
                if(response.isSuccessful){
                    startActivity(homeIntent)
                }
            }

            override fun onFailure(call: Call<Gain>, t: Throwable) {
                println(t.printStackTrace())
            }
        })

    }

}
