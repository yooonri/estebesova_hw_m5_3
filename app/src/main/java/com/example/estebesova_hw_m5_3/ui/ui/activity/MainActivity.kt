package com.example.estebesova_hw_m5_3.ui.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.estebesova_hw_m5_3.Pref
import com.example.estebesova_hw_m5_3.data.model.LoveModel
import com.example.estebesova_hw_m5_3.ui.ui.onBoard.OnBoardActivity
import com.example.homework_5_4_mvvm.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var pref: Pref

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initClickers()

        if (pref.onShowed()) {
            startActivity(Intent(this@MainActivity, OnBoardActivity::class.java))
        }
    }

    private fun initClickers() = with(binding) {
        btnCalculate.setOnClickListener {
            viewModel.getLovePercentage(
                firstName = etFname.text.toString(),
                secondName = etSname.text.toString()
            ).observe(this@MainActivity) { data ->
                setupObservers(data)
            }
        }
    }

    private fun setupObservers(data: LoveModel) = with(viewModel) {
        startActivity(
            Intent(this@MainActivity, SecondActivity::class.java).apply {
                putExtra(ARG_FIRST_NAME, binding.etFname.text.toString())
                putExtra(ARG_SECOND_NAME, binding.etSname.text.toString())
                putExtra(ARG_PERCENTAGE, data.percentage)
                putExtra(ARG_RESULT, data.result)
            }
        )
    }

    companion object {
        const val ARG_FIRST_NAME = "firstName"
        const val ARG_SECOND_NAME = "secondName"
        const val ARG_PERCENTAGE = "percentage"
        const val ARG_RESULT = "result"
    }
}