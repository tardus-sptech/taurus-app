package com.taurus.apptaurus

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.taurus.apptaurus.external.Apis
import com.taurus.apptaurus.response.ResponseGasto
import com.taurus.apptaurus.response.UsuarioDados
import com.taurus.apptaurus.util.UserManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var emptyStateTextView: TextView
    private lateinit var adapter: GastoAdapter



    val idUser = UserManager.userId
    val apiGasto = Apis.getApiUsuarios().getGastos(idUser)
    val apiUsuario = Apis.getApiUsuarios().getDados(idUser)
    val apiGastosTotal = Apis.getApiUsuarios().getGastosSoma(idUser)
    val apiGanhosTotal = Apis.getApiUsuarios().getGanhosSoma(idUser)


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        val view = inflater.inflate(R.layout.fragment_home  , container, false)
        val valorTotal = view.findViewById<TextView>(R.id.valorTotal)
        val ganhoTotal = view.findViewById<TextView>(R.id.ganhoTotal)
        val gastoTotal = view.findViewById<TextView>(R.id.despesaTotal)

        val btnClick = view.findViewById<AppCompatButton>(R.id.adicButton)

        btnClick.setOnClickListener {
            // Código para chamar a Activity
            val intent = Intent(activity, LancamentoGain::class.java)
            startActivity(intent)
        }

        recyclerView = view.findViewById(R.id.recycler_view_gastos_ganhos)
        emptyStateTextView = view.findViewById(R.id.emptyStateTextView) // Inicializa o emptyStateTextView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        apiGasto.enqueue(object : Callback<List<ResponseGasto>> {
            override fun onResponse(call: Call<List<ResponseGasto>>, response: Response<List<ResponseGasto>>) {
                if (response.isSuccessful) {
                    val dataList = response?.body()
                    if (dataList.isNullOrEmpty()) {
                        showEmptyState()
                    } else {
                        adapter = GastoAdapter(dataList)
                        recyclerView.adapter = adapter
                    }
                } else {
                    // Handle error
                }
            }

            override fun onFailure(call: Call<List<ResponseGasto>>, t: Throwable) {
                t.printStackTrace()
                Toast.makeText(
                    requireContext(),
                    t.message,
                    Toast.LENGTH_SHORT
                ).show()
            }

        })

        apiGanhosTotal.enqueue(object : Callback<Double> {
            override fun onResponse(call: Call<Double>, response: Response<Double>) {
                if (response.isSuccessful) {
                    val valor = response.body()
                    val valorFormatado = valor?.let { formatarValor(it) }
                    ganhoTotal.text = "R$ ${valorFormatado}"
                } else {
                    ganhoTotal.text = "R$ 0,00"
                }
            }

            override fun onFailure(call: Call<Double>, t: Throwable) {
                ganhoTotal.text = "R$ 0,00"
            }
        })

        apiGastosTotal.enqueue(object : Callback<Double> {
            override fun onResponse(call: Call<Double>, response: Response<Double>) {
                if (response.isSuccessful) {
                    val valor = response.body()
                    val valorFormatado = valor?.let { formatarValor(it) }
                    gastoTotal.text = "R$ ${valorFormatado}"
                } else {
                    gastoTotal.text = "R$ 0,00"
                }
            }

            override fun onFailure(call: Call<Double>, t: Throwable) {
                gastoTotal.text = "R$ 0,00"
            }
        })

        apiUsuario.enqueue(object : Callback<UsuarioDados> {
            override fun onResponse(call: Call<UsuarioDados>, response: Response<UsuarioDados>) {
                if (response.isSuccessful) {
                    if (response.body()?.id != null) {
                        val valor = response.body()?.valueInAccount?.let { formatarValor(it) }
                        valorTotal.text = valor
                    }
                }
            }

            override fun onFailure(call: Call<UsuarioDados>, t: Throwable) {
                valorTotal.text = "Erro no valor"
                println(t.printStackTrace())
            }

        })

        return view
    }

    private fun showEmptyState() {
        recyclerView.visibility = View.GONE
        emptyStateTextView.visibility = View.VISIBLE
    }

    fun formatarValor(valor: Double): String {
        val format = NumberFormat.getInstance(Locale("pt", "BR")) as DecimalFormat
        format.applyPattern("#,##0.00")
        return format.format(valor)
    }



}

