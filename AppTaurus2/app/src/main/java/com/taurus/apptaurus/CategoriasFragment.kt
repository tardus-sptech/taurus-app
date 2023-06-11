package com.taurus.apptaurus

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
import com.github.mikephil.charting.utils.ColorTemplate
import com.taurus.apptaurus.external.Apis
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

    val idUser = UserManager.userId
    val apiGasto = Apis.getApiUsuarios().getGastos(idUser)
    val apiGastosTotal = Apis.getApiUsuarios().getGastosSoma(idUser)



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

        apiGasto.enqueue(object : Callback<List<ResponseGasto>> {
            override fun onResponse(
                call: Call<List<ResponseGasto>>,
                response: Response<List<ResponseGasto>>
            ) {
                if (response.isSuccessful) {

                    val responseGastos: Response<List<ResponseGasto>> = response

                    val somaPorCategoria = mutableMapOf<String, Double>()

                    response.body()?.forEach { gasto ->
                        val categoria = gasto.category?.description
                        val valor = gasto.value ?: 0.0

                        if (categoria != null) {
                            if (somaPorCategoria.containsKey(categoria)) {
                                // Categoria já existe no mapa, adiciona o valor atual
                                val valorAnterior = somaPorCategoria[categoria] ?: 0.0
                                somaPorCategoria[categoria] = valorAnterior + valor
                            } else {
                                // Categoria não existe no mapa, adiciona com o valor atual
                                somaPorCategoria[categoria] = valor
                            }
                        }
                    }

                    val gastos = somaPorCategoria.map { (categoria, valor) ->
                        GastoPorCategoria(categoria, valor.toFloat())
                    }

                    val entries = mutableListOf<PieEntry>()
                    val labels = mutableListOf<String>()

                    for (gasto in gastos) {
                        entries.add(PieEntry(gasto.valor.toFloat(), gasto.categoria))
                    }

                    val dataSet = PieDataSet(entries, "Gastos por Categoria")
                    dataSet.colors = ColorTemplate.COLORFUL_COLORS.toList()

                    val data = PieData(dataSet)
                    data.setDrawValues(false)

                    pieChart.description.isEnabled = true
                    pieChart.description.text = "Gastos por Categoria"
                    pieChart.legend.isEnabled = true

                    pieChart.data = data
                    pieChart.invalidate()

// Configura os rótulos das categorias
                    pieChart.setDrawEntryLabels(true)
                    pieChart.setEntryLabelColor(Color.BLACK)
                    pieChart.setEntryLabelTextSize(12f)

                    val legend = pieChart.legend
                    legend.form = Legend.LegendForm.CIRCLE
                    legend.setDrawInside(false)
                    legend.orientation = Legend.LegendOrientation.VERTICAL
                    legend.horizontalAlignment = Legend.LegendHorizontalAlignment.RIGHT
                    legend.verticalAlignment = Legend.LegendVerticalAlignment.TOP
                    legend.textSize = 12f
                    legend.xEntrySpace = 8f
                    legend.yEntrySpace = 8f
                    legend.yOffset = 0f
                    legend.xOffset = 0f
                    legend.setDrawInside(false)


                    pieChart.invalidate()

                } else {
                    // Handle error
                }
            }

            override fun onFailure(call: Call<List<ResponseGasto>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

        return view
    }
    fun formatarValor(valor: Double): String {
        val format = NumberFormat.getInstance(Locale("pt", "BR")) as DecimalFormat
        format.applyPattern("#,##0.00")
        return format.format(valor)
    }
}