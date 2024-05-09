package com.example.estebesova_hw_m5_3.ui.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.estebesova_hw_m5_3.ui.ui.onBoard.OnBoardActivity
import com.example.homework_5_4_mvvm.databinding.ActivityStartBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StartActivity : AppCompatActivity() {

    private val binding by lazy { ActivityStartBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            startActivity(Intent(this@StartActivity, OnBoardActivity::class.java))
        }
    }
}