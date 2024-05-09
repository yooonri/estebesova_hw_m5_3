package com.example.estebesova_hw_m5_3.ui.ui.activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.estebesova_hw_m5_3.data.model.LoveModel
import com.example.estebesova_hw_m5_3.data.repository.LoveRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: LoveRepository
) : ViewModel() {

    fun getLovePercentage(firstName: String, secondName: String): LiveData<LoveModel> =
        repository.getLovePercentage(firstName, secondName)
}
