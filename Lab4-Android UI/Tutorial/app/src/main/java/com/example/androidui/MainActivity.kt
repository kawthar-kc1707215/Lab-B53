package com.example.androidui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

data class Country(val name: String , val capital : String)

class MainActivity : AppCompatActivity() {

    var countries = listOf(Country("Qatar", "Doha"),Country("Saudi", "Riyad"))
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //two lines
        myRecyclerView.adapter = MyAdapter(countries, this)
        myRecyclerView.layoutManager = LinearLayoutManager(this)
//        myRecyclerView.layoutManager = GridLayoutManager(this, 2)
    }
}