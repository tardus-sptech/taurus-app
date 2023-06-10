package com.taurus.apptaurus

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.taurus.apptaurus.response.ResponseGasto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.DecimalFormat
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*
import java.util.zip.DataFormatException

class GastoAdapter(private val listaGastos: List<ResponseGasto>)
    : RecyclerView.Adapter<GastoAdapter.GastoViewHolder>() {

    class GastoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoria: TextView = itemView.findViewById(R.id.categoria_gasto)
        val data: TextView = itemView.findViewById(R.id.data_gasto)
        val valor: TextView = itemView.findViewById(R.id.valor_gasto)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GastoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recentes, parent, false)
        return GastoViewHolder(view)
    }

    override fun onBindViewHolder(holder: GastoViewHolder, position: Int) {
        val item = listaGastos[position]

        val formatoSaida = SimpleDateFormat("dd/MM/yy", Locale.getDefault())
        val format = NumberFormat.getInstance(Locale("pt", "BR")) as DecimalFormat
        format.applyPattern("#,##0.00")

        holder.categoria.text = item.category?.description
        holder.data.text = item.created_at?.let { formatarData(it) }
        val valorFormatado = format.format(item.value)
        holder.valor.text = "R$ ${valorFormatado}"
    }

    fun formatarData(data: String): String {
        val formatoEntrada = SimpleDateFormat("dd/MM/yy HH:mm:ss", Locale.getDefault())
        val formatoSaida = SimpleDateFormat("dd/MM/yy", Locale.getDefault())

        val dataObjeto = formatoEntrada.parse(data)
        return formatoSaida.format(dataObjeto)
    }

    override fun getItemCount(): Int {
        return listaGastos.size
    }
}

