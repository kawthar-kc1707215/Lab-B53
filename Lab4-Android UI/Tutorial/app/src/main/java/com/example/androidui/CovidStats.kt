package com.example.androidui

import kotlinx.serialization.Serializable

//serializable
@Serializable
data class CovidStats(val country: String, val continent :String , val population : Int)
