package com.stefandn.gymnotesapp.usescase.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.stefandn.gymnotesapp.R
import com.stefandn.gymnotesapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

    }
}