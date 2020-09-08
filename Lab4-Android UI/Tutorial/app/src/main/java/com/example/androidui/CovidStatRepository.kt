package com.example.androidui

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.File

object CovidStatRepository {
    var covidStats = listOf<CovidStats>()

    init {
        val covidStatsData = File("data/covid-data.json").readText()

        //convert the data into CovidStats object

        covidStats = Json { ignoreUnknownKeys = true } //to ignore the other fields
                            .decodeFromString(covidStatsData)
    }


    fun totalPopulation() = covidStats.sumBy { it.population }
    fun display() = covidStats.forEach { println(it) }
    fun highestPopulation() = covidStats.sortedByDescending { it.population }.take(1)
}

fun main() {
//    CovidStatRepository.covidStats.forEach { println(it) }


    CovidStatRepository.apply {
        println(highestPopulation())
//        display()
        println(totalPopulation())
    }




}