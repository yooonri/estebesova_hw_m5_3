package com.example.estebesova_hw_m5_3.ui.ui.onBoard

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.estebesova_hw_m5_3.Pref
import com.example.estebesova_hw_m5_3.ui.ui.activity.MainActivity
import com.example.homework_5_4_mvvm.databinding.ActivityOnBoardBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OnBoardActivity : AppCompatActivity() {

    @Inject
    lateinit var pref: Pref
    private var adapter = OnBoardAdapter(this::onClick)


    private val binding by lazy {
        ActivityOnBoardBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupViewPager()
        onClick()
    }

    private fun onClick() {
        pref.onBoardingShow()
        startActivity(Intent(this@OnBoardActivity, MainActivity::class.java))
    }

    private fun setupViewPager() {
        binding.viewPager2.adapter = adapter
    }
}