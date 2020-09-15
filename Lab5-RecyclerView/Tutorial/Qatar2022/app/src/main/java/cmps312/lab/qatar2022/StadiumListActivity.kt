package cmps312.lab.qatar2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import cmps312.lab.qatar2022.adapter.StadiumAdapter
import cmps312.lab.qatar2022.model.StadiumRepository
import com.example.qatar2022.R
import kotlinx.android.synthetic.main.activity_stadium_list.*

class StadiumListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stadium_list)

        StadiumRepository.initStadiums(this) //this will read and populate data

        stadiumsRv.apply {
            adapter = StadiumAdapter(StadiumRepository.stadiums, context)
            layoutManager = LinearLayoutManager(context)
        }
        setSupportActionBar(toolbar as Toolbar?)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.close ->Toast.makeText(this, "Close Menu", Toast.LENGTH_LONG).show()
        }
        return super.onOptionsItemSelected(item)
    }
}