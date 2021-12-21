package com.stefandn.gymnotesapp.usescase.launch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.stefandn.gymnotesapp.R
import com.stefandn.gymnotesapp.usescase.home.HomeActivity
import com.stefandn.gymnotesapp.usescase.onboarding.OnboardingActivity

class LaunchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, OnboardingActivity::class.java))
    }
}