package com.example.androidui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val countries : List<Country>, val context: Context)
    : RecyclerView.Adapter<MyAdapter.ViewHolder>() {  ////STEP 2


    //STEP 1
    class ViewHolder(item : View) : RecyclerView.ViewHolder(item){
        //intialization of our views
        val countryName : TextView = item.findViewById(R.id.countryName)
        val capitalCity : TextView = item.findViewById(R.id.capitalCity)
    }

    ////STEP 3
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val item = LayoutInflater
            .from(context)
            .inflate(R.layout.list_item, parent , false)

        return ViewHolder(item)
    }

    //STEP 4
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //is used to add data to the inflated view
        holder.countryName.text = countries[position].name
        holder.capitalCity.text = countries[position].capital

    }

    //STEP 5 - O
    override fun getItemCount() = countries.size

}