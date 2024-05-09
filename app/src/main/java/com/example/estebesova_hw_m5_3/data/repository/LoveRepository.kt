package com.example.estebesova_hw_m5_3.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.estebesova_hw_m5_3.LoveApiService
import com.example.estebesova_hw_m5_3.data.model.LoveModel
import com.example.estebesova_hw_m5_3.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class LoveRepository @Inject constructor(
    private val api: LoveApiService
) {


    private val lovePercentageLv = MutableLiveData<LoveModel>()
    val error = MutableLiveData<String>()
    val loading = MutableLiveData<Boolean>()

    fun getLovePercentage(firstName: String, secondName: String): MutableLiveData<LoveModel> {
        api?.getPercentage(
            apiKey = Constants.API_KEY,
            host = Constants.HOST,
            firstName = firstName,
            secondName = secondName
        )?.enqueue(object :
            Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful && response.body() != null) {
                    lovePercentageLv.postValue(response.body())
                    loading.value = false
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                error.value = t.localizedMessage
                loading.value = false
            }
        })
        return lovePercentageLv
    }

}