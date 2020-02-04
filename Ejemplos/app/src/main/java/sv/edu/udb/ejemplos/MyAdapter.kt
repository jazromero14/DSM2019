package sv.edu.udb.ejemplos

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import sv.edu.udb.ejemplos.database.Pet

class MyAdapter(private val mutableList: MutableList<Pet>, var context: Context) :
    RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.rv_list,
            parent,
            false
        ) as View

        return MyViewHolder(view)
    }


    override fun getItemCount(): Int = mutableList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        context = holder.itemView.context
        holder.bind(mutableList[position])
    }
}

class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    private val categoryText: TextView = itemView.findViewById(R.id.mascota_rv)
    private val segmentText: TextView = itemView.findViewById(R.id.dueno_rv)
    private val skuText: TextView = itemView.findViewById(R.id.raza_rv)

    fun bind(value: Pet) {
        categoryText.text = value.name
        segmentText.text = value.owner
        skuText.text = value.breed
    }
}
