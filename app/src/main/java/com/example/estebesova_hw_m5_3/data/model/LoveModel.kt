package com.example.estebesova_hw_m5_3.data.model

import com.google.gson.annotations.SerializedName

class LoveModel(
    @SerializedName("fname")
    val firstName: String,
    @SerializedName("sname")
    val secondName: String,
    @SerializedName("Percentage")
    val percentage: String,
    @SerializedName("result")
    val result: String
)