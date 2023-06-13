import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.taurus.apptaurus.CombinedData
import com.taurus.apptaurus.R
import java.text.SimpleDateFormat
import java.util.Locale

class GastoAdapter(private var listaDados: List<CombinedData>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TIPO_GASTO = 1
    private val TIPO_GANHO = 2

    // ViewHolder para gastos
    class GastoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoria: TextView = itemView.findViewById(R.id.categoria_gasto)
        val data: TextView = itemView.findViewById(R.id.data_gasto)
        val valor: TextView = itemView.findViewById(R.id.valor_gasto)
    }

    // ViewHolder para ganhos
    class GanhoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoria: TextView = itemView.findViewById(R.id.categoria_ganho)
        val data: TextView = itemView.findViewById(R.id.data_ganho)
        val valor: TextView = itemView.findViewById(R.id.valor_ganho)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            TIPO_GASTO -> {
                val view = inflater.inflate(R.layout.item_gasto, parent, false)
                GastoViewHolder(view)
            }
            TIPO_GANHO -> {
                val view = inflater.inflate(R.layout.item_ganho, parent, false)
                GanhoViewHolder(view)
            }
            else -> throw IllegalArgumentException("Tipo de ViewHolder desconhecido")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = listaDados[position]

        when (holder.itemViewType) {
            TIPO_GASTO -> {
                val gastoHolder = holder as GastoViewHolder
                val gasto = item.getGasto()
                gastoHolder.categoria.text = gasto?.category?.description
                gastoHolder.data.text = gasto?.created_at?.let { formatarData(it) }
                gastoHolder.valor.text = "R$ ${gasto?.value}"
            }
            TIPO_GANHO -> {
                val ganhoHolder = holder as GanhoViewHolder
                val ganho = item.getGanho()
                ganhoHolder.categoria.text = "Receita"
                ganhoHolder.data.text = ganho?.created_at?.let { formatarData(it) }
                ganhoHolder.valor.text = "R$ ${ganho?.value}"
            }
            else -> throw IllegalArgumentException("Tipo de ViewHolder desconhecido")
        }
    }

    override fun getItemViewType(position: Int): Int {
        val item = listaDados[position]
        return if (item.getGasto() != null) {
            TIPO_GASTO
        } else if (item.getGanho() != null) {
            TIPO_GANHO
        } else {
            throw IllegalArgumentException("Tipo de item desconhecido")
        }
    }

    fun formatarData(data: String): String {
        val formatoEntrada = SimpleDateFormat("dd/MM/yy HH:mm:ss", Locale.getDefault())
        val formatoSaida = SimpleDateFormat("dd/MM/yy HH:mm", Locale.getDefault())

        val dataObjeto = formatoEntrada.parse(data)
        return formatoSaida.format(dataObjeto)
    }

    override fun getItemCount(): Int {
        return listaDados.size
    }

    fun setData(combinedList: List<CombinedData>) {
        this.listaDados = combinedList
        notifyDataSetChanged()
    }
}