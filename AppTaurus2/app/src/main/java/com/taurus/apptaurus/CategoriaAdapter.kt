import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.taurus.apptaurus.CombinedData
import com.taurus.apptaurus.R
import com.taurus.apptaurus.response.CategoriasSoma
import java.text.DecimalFormat
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Locale

class CategoriaAdapter(private var listaDados: List<CategoriasSoma>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_categoria, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = listaDados[position]
        (holder as ViewHolder).bind(item)
    }

    override fun getItemCount(): Int {
        return listaDados.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textCategory: TextView = itemView.findViewById(R.id.categoria_desc)
        private val textValue: TextView = itemView.findViewById(R.id.categoria_soma)

        fun bind(item: CategoriasSoma) {
            textCategory.text = item.description
            textValue.text = "R$ ${formatarValor(item.totalValue)}"
        }
    }

    private fun formatarValor(valor: Double): String {
        val format = NumberFormat.getInstance(Locale("pt", "BR")) as DecimalFormat
        format.applyPattern("#,##0.00")
        return format.format(valor)
    }
}