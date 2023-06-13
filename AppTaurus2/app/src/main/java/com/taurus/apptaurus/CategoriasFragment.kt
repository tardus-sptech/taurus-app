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

        // Obtenha a referência do PieChart do layout
        val pieChart = view.findViewById<PieChart>(R.id.pieChart)

        // Crie uma lista de entradas de dados para o gráfico de pizza
        val entries = listOf(
            PieEntry(25f, "Categoria 1"),
            PieEntry(35f, "Categoria 2"),
            PieEntry(40f, "Categoria 3")
        )

        // Crie um conjunto de dados para o gráfico de pizza
        val dataSet = PieDataSet(entries, "Categorias")
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS, 255)

        // Crie um objeto PieData para encapsular o conjunto de dados
        val data = PieData(dataSet)

        // Personalize o gráfico de pizza, se necessário
        pieChart.description.isEnabled = false
        pieChart.setEntryLabelColor(Color.BLACK)

        // Defina os dados no gráfico de pizza
        pieChart.data = data

        // Atualize o gráfico
        pieChart.invalidate()



        return view
    }
    fun formatarValor(valor: Double): String {
        val format = NumberFormat.getInstance(Locale("pt", "BR")) as DecimalFormat
        format.applyPattern("#,##0.00")
        return format.format(valor)
    }
}