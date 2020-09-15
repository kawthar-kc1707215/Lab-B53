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
import kotlinx.android.synthetic.main.list_item_stadium.view.*

class StadiumAdapter(val stadiums: List<Stadium>, private val context: Context)
    : RecyclerView.Adapter<StadiumAdapter.StadiumViewHolder>() {

    //step 1 create the view holder
    class StadiumViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(stadium: Stadium){
            itemView.apply {
                nameTv.text = stadium.name
                cityTv.text = stadium.name
                statusTv.text = stadium.name

                val imageName = stadium.imageName
                val imageId = context.resources.getIdentifier(imageName, "drawable" , context.packageName)

                stadiumIv.setImageResource(imageId)
            }
        }
    }

    //step 3
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StadiumViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.list_item_stadium, parent , false)
        return StadiumViewHolder(view)
    }
    //step 4 injecting the data
    override fun onBindViewHolder(holder: StadiumViewHolder, position: Int) {
        holder.bind(stadiums[position])
    }
    //step 2
    override fun getItemCount() = stadiums.size


}