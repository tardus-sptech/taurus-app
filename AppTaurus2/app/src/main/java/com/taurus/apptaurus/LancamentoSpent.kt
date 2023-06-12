package com.taurus.apptaurus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import com.taurus.apptaurus.external.ApiEntry
import com.taurus.apptaurus.external.Apis
import com.taurus.apptaurus.request.Category
import com.taurus.apptaurus.request.Spent
import com.taurus.apptaurus.request.SpentRequest
import com.taurus.apptaurus.response.CategoryResponse
import com.taurus.apptaurus.util.UserManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LancamentoSpent : AppCompatActivity() {

    private lateinit var spinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lancamento_spent)

        spinner = findViewById(R.id.spinner_spent)
        val apiEntry = Apis.getApiEntry()

        val call = apiEntry.categoryResponse()


        call.enqueue(object : Callback<List<CategoryResponse>> {
            override fun onResponse(call: Call<List<CategoryResponse>>, response: Response<List<CategoryResponse>>) {
                if (response.isSuccessful){
                    val categoryResponseList = response.body()
                    if(categoryResponseList != null){
                        val categories: List<Category> = categoryResponseList.map { response ->
                            Category(response.id, response.description.toString())
                        }

                        val adapter = ArrayAdapter(this@LancamentoSpent, android.R.layout.simple_spinner_item,categories)
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                        spinner.adapter = adapter

                        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                                val selectedCategory = parent?.getItemAtPosition(position) as Category
                                val selectedCategoryId = selectedCategory.id
                                val selectedCategoryDescription = selectedCategory.description
                            }

                            override fun onNothingSelected(p0: AdapterView<*>?) {
                                TODO("Not yet implemented")
                            }
                        }
                    }
                }else{
                    TODO("Not yet implemented")
                }
            }

            override fun onFailure(call: Call<List<CategoryResponse>>, t: Throwable) {
                // Trate a falha na chamada aqui
            }
        })





    }

    private fun setupSpinner() {

    }

    fun addSpent(componente: View){
        val spentValue = findViewById<EditText>(R.id.et_spent_value)
        val spentDescription = findViewById<EditText>(R.id.et_spent_description)
        val selectedCategory = spinner.selectedItem as Category
        val selectedCategoryId = selectedCategory.id
        val idUser = UserManager.userId

        val apiEntry = Apis.getApiEntry()

        val entrySpent = SpentRequest(
            spentDescription.text.toString(),
            spentValue.text.toString().toDouble(),
            selectedCategoryId,
            idUser)

        val request = apiEntry.SpentResponse(entrySpent)

        val homeIntent = Intent(applicationContext, Home::class.java)

        request.enqueue(object : Callback<Spent> {
            override fun onResponse(call: Call<Spent>, response: Response<Spent>) {
                if(response.isSuccessful){
                    startActivity(homeIntent)
                }else{
                    TODO("Not yet implemented")
                }
            }

            override fun onFailure(call: Call<Spent>, t: Throwable) {
                println(t.printStackTrace())
            }
        })

    }
}