package com.stefandn.gymnotesapp.usescase.onboarding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.stefandn.gymnotesapp.databinding.ActivityOnboardingBinding
import com.stefandn.gymnotesapp.usescase.onboarding.pages.OnboardingAdapter


class OnboardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnboardingBinding
    private lateinit var viewModel: OnboardingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //ViewModel
        viewModel = ViewModelProvider(this).get(OnboardingViewModel::class.java)
    }

    fun slider(){
        binding.vwPagerOnboarding.adapter = OnboardingAdapter(this, viewModel.data)
    }
}