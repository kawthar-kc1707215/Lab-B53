package cmps312.lab.qatar2022.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cmps312.lab.qatar2022.model.Stadium
import com.example.qatar2022.R

class StadiumAdapter(val stadiums: List<Stadium>, private val context: Context)
    : RecyclerView.Adapter<StadiumAdapter.StadiumViewHolder>() {

    //step 1 create the view holder
    class StadiumViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val nameTv = itemView.findViewById<TextView>(R.id.nameTv)
        val cityTv = itemView.findViewById<TextView>(R.id.cityTv)
        val statusTv = itemView.findViewById<TextView>(R.id.statusTv)
        val stadiumIv = itemView.findViewById<ImageView>(R.id.stadiumIv)
    }

    //step 3
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StadiumViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.list_item_stadium, parent , false)
        return StadiumViewHolder(view)
    }
    //step 4 injecting the data
    override fun onBindViewHolder(holder: StadiumViewHolder, position: Int) {
        holder.nameTv.text = stadiums[position].name
        holder.cityTv.text = stadiums[position].name
        holder.statusTv.text = stadiums[position].name

        val imageName = stadiums[position].imageName
        val imageId = context.resources.getIdentifier(imageName, "drawable" , context.packageName)
        holder.stadiumIv.setImageResource(imageId)
    }
    //step 2
    override fun getItemCount() = stadiums.size


}