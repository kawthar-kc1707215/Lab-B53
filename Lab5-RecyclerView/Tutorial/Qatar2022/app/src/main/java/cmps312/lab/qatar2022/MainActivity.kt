package cmps312.lab.qatar2022

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import cmps312.lab.qatar2022.model.StadiumRepository
import com.example.qatar2022.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_item_stadium.*
import kotlinx.android.synthetic.main.list_item_stadium.view.*

class MainActivity : AppCompatActivity() {
    var currentIndex = 0
    var stadiumsCount = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //get the data
        StadiumRepository.initStadiums(this)
        stadiumsCount = StadiumRepository.stadiums.size
        displayStadium(currentIndex)


    }

    fun onClick(view: View) {
        when(view.id){
            R.id.prevBtn ->  displayStadium(currentIndex--)
            R.id.nextBtn ->  displayStadium(currentIndex++)
        }
        currentIndex = (currentIndex + stadiumsCount) % stadiumsCount
    }

    private fun displayStadium(index : Int){

        nameTv.text = StadiumRepository.stadiums[index].name
        cityTv.text = StadiumRepository.stadiums[index].city
        statusTv.text = StadiumRepository.stadiums[index].status
        currentIndexTv.text = "${currentIndex+1} of ${stadiumsCount+1}"

        //reading the image
        val imageName = StadiumRepository.stadiums[index].imageName
        val imageId = resources.getIdentifier(imageName, "drawable" , packageName)
        stadiumIv.setImageResource(imageId)
    }
}