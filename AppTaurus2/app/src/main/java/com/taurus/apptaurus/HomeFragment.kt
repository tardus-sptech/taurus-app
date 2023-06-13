package com.taurus.apptaurus

import GastoAdapter
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
import com.taurus.apptaurus.response.ResponseGanho
import com.taurus.apptaurus.response.ResponseGasto
import com.taurus.apptaurus.response.UsuarioDados
import com.taurus.apptaurus.util.UserManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.DecimalFormat
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*
import java.util.Collections.max
import kotlin.math.max

class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var emptyStateTextView: TextView
    private lateinit var adapter: GastoAdapter

    private val idUser = UserManager.userId
    private val apiGasto = Apis.getApiUsuarios().getGastos(idUser)
    private val apiGanho = Apis.getApiUsuarios().getGanhos(idUser)
    private val apiUsuario = Apis.getApiUsuarios().getDados(idUser)
    private val apiGastosTotal = Apis.getApiUsuarios().getGastosSoma(idUser)
    private val apiGanhosTotal = Apis.getApiUsuarios().getGanhosSoma(idUser)

    private var gastoResponse: List<ResponseGasto>? = null
    private var ganhoResponse: List<ResponseGanho>? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val valorTotal = view.findViewById<TextView>(R.id.valorTotal)
        val ganhoTotal = view.findViewById<TextView>(R.id.ganhoTotal)
        val gastoTotal = view.findViewById<TextView>(R.id.despesaTotal)

        val btnClick = view.findViewById<AppCompatButton>(R.id.adicButton)
        btnClick.setOnClickListener {
            val intent = Intent(activity, LancamentoGain::class.java)
            startActivity(intent)
        }

        val adicSpenties = view.findViewById<AppCompatButton>(R.id.adicSpent)
        adicSpenties.setOnClickListener {
            val intent = Intent(activity, LancamentoSpent::class.java)
            startActivity(intent)
        }

        recyclerView = view.findViewById(R.id.recycler_view_gastos_ganhos)
        emptyStateTextView = view.findViewById(R.id.emptyStateTextView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        adapter = GastoAdapter(listOf())
        recyclerView.adapter = adapter

        apiGasto.enqueue(object : Callback<List<ResponseGasto>> {
            override fun onResponse(call: Call<List<ResponseGasto>>, response: Response<List<ResponseGasto>>) {
                if (response.isSuccessful) {
                    gastoResponse = response.body()
                    onResponseComplete()
                } else {
                    // Handle error
                }
            }

            override fun onFailure(call: Call<List<ResponseGasto>>, t: Throwable) {
                // Handle failure
            }
        })

        apiGanho.enqueue(object : Callback<List<ResponseGanho>> {
            override fun onResponse(call: Call<List<ResponseGanho>>, response: Response<List<ResponseGanho>>) {
                if (response.isSuccessful) {
                    ganhoResponse = response.body()
                    onResponseComplete()
                } else {
                    // Handle error
                }
            }

            override fun onFailure(call: Call<List<ResponseGanho>>, t: Throwable) {
                // Handle failure
            }
        })

        apiGastosTotal.enqueue(object : Callback<Double> {
            override fun onResponse(call: Call<Double>, response: Response<Double>) {
                if (response.isSuccessful) {
                    val gastoTotalValue = response.body()
                    gastoTotal.text = formatCurrency(gastoTotalValue ?: 0.0)
                } else {
                    // Handle error
                }
            }

            override fun onFailure(call: Call<Double>, t: Throwable) {
                // Handle failure
            }
        })

        apiGanhosTotal.enqueue(object : Callback<Double> {
            override fun onResponse(call: Call<Double>, response: Response<Double>) {
                if (response.isSuccessful) {
                    val ganhoTotalValue = response.body()
                    ganhoTotal.text = formatCurrency(ganhoTotalValue ?: 0.0)
                } else {
                    // Handle error
                }
            }

            override fun onFailure(call: Call<Double>, t: Throwable) {
                // Handle failure
            }
        })

        apiUsuario.enqueue(object : Callback<UsuarioDados> {
            override fun onResponse(call: Call<UsuarioDados>, response: Response<UsuarioDados>) {
                if (response.isSuccessful) {
                    val usuario = response.body()
                    valorTotal.text = usuario?.valueInAccount.toString()
                } else {
                    // Handle error
                }
            }

            override fun onFailure(call: Call<UsuarioDados>, t: Throwable) {
                // Handle failure
            }
        })

        return view
    }

    private fun onResponseComplete() {
        if (gastoResponse != null && ganhoResponse != null) {
            val combinedList = combineLists(gastoResponse!!, ganhoResponse!!)
            if (combinedList.isEmpty()) {
                emptyStateTextView.visibility = View.VISIBLE
                recyclerView.visibility = View.GONE
            } else {
                emptyStateTextView.visibility = View.GONE
                recyclerView.visibility = View.VISIBLE
                adapter.setData(combinedList)
            }
        }
    }

    private fun combineLists(gastos: List<ResponseGasto>, ganhos: List<ResponseGanho>): List<CombinedData> {
        val combinedList: MutableList<CombinedData> = mutableListOf()

        combinedList.addAll(gastos.map { CombinedData(it, null) })
        combinedList.addAll(ganhos.map { CombinedData(null, it) })

        return combinedList.sortedByDescending { it.getData() as? String }
    }

    private fun formatCurrency(value: Double): String {
        val formatter: NumberFormat = DecimalFormat("#,##0.00")
        return "R$ ${formatter.format(value)}"
    }
}