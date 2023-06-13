package com.taurus.apptaurus

import CategoriaAdapter
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.components.Description
import android.graphics.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.mikephil.charting.utils.ColorTemplate
import com.taurus.apptaurus.external.Apis
import com.taurus.apptaurus.response.CategoriasSoma
import com.taurus.apptaurus.response.GastoPorCategoria
import com.taurus.apptaurus.response.ResponseGasto
import com.taurus.apptaurus.util.UserManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.Locale

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CategoriasFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CategoriasFragment : Fragment() {

    private val idUser = UserManager.userId
    private val apiGastosTotal = Apis.getApiUsuarios().getGastosSoma(idUser)
    private val apiCategoriasSoma = Apis.getApiEntry().getCategoriasSoma(idUser)

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CategoriaAdapter
    private var listaDados: List<CategoriasSoma> = listOf()
    

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_categorias, container, false)
        val gastoTotal = view.findViewById<TextView>(R.id.gastoTotal)
        val pieChart = view.findViewById<PieChart>(R.id.pieChart)

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

        apiCategoriasSoma.enqueue(object : Callback<List<CategoriasSoma>> {
            override fun onResponse(
                call: Call<List<CategoriasSoma>>,
                response: Response<List<CategoriasSoma>>
            ) {
                if (response.isSuccessful) {
                    val categoriaSomaList = response.body()

                    // Filtrar os valores nulos ou iguais a 0
                    val filteredList = categoriaSomaList?.filter { categoriaSoma ->
                        categoriaSoma.totalValue != null && categoriaSoma.totalValue > 0
                    }

                    // Crie uma lista de entradas de dados para o gráfico de pizza
                    val entries = filteredList?.map { categoriaSoma ->
                        PieEntry(categoriaSoma.totalValue!!.toFloat(), categoriaSoma.description)
                    }

                    // Crie um conjunto de dados para o gráfico de pizza
                    val dataSet = PieDataSet(entries, "")
                    dataSet.setColors(ColorTemplate.MATERIAL_COLORS, 255)

                    val data = PieData(dataSet)

                    // Personalize o gráfico de pizza, se necessário
                    pieChart.description.isEnabled = false

                    // Defina os dados no gráfico de pizza
                    pieChart.data = data

                    // Obtenha a legenda do gráfico de pizza
                    val legend = pieChart.legend

                    // Configurar legenda
                    legend.isEnabled = true
                    legend.setDrawInside(false)

                    val description = Description().apply {
                        text = "Gasto por Categorias"
                        textSize = 12f
                        textAlign = Paint.Align.RIGHT
                    }

                    pieChart.description = description
                    pieChart.legend.apply {
                        verticalAlignment = Legend.LegendVerticalAlignment.BOTTOM
                        horizontalAlignment = Legend.LegendHorizontalAlignment.LEFT
                        orientation = Legend.LegendOrientation.HORIZONTAL
                        setDrawInside(false)
                    }

                    // Atualize o gráfico
                    pieChart.invalidate()

                    // Configurar o RecyclerView
                    recyclerView = view.findViewById(R.id.recyclerView)
                    recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

                    // Criar uma instância do adaptador e atribuí-lo ao RecyclerView
                    adapter = CategoriaAdapter(filteredList ?: emptyList())
                    recyclerView.adapter = adapter
                } else {
                    // Trate a resposta não bem-sucedida aqui
                }
            }

            override fun onFailure(call: Call<List<CategoriasSoma>>, t: Throwable) {
                // Trate o erro de solicitação aqui
            }
        })



        return view
    }

    private fun formatarValor(valor: Double): String {
        val format = NumberFormat.getInstance(Locale("pt", "BR")) as DecimalFormat
        format.applyPattern("#,##0.00")
        return format.format(valor)
    }
}