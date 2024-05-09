package com.example.estebesova_hw_m5_3

import com.example.estebesova_hw_m5_3.data.model.LoveModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApiService {

    //https://love-calculator.p.rapidapi.com/getPercentage?sname=Alice&fname=John
    @GET("getPercentage")
    fun getPercentage(
        @Header("X-RapidAPI-Key") apiKey: String = "a9a2247cdfmsh6f4df638e5338d7p1c26a1jsnb1531fd9178f",
        @Header("X-RapidAPI-Host") host: String = "love-calculator.p.rapidapi.com",
        @Query("fname") firstName: String,
        @Query("sname") secondName: String,

        ): Call<LoveModel>
}
