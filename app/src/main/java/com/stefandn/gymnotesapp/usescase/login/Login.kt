package com.stefandn.gymnotesapp.usescase.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.stefandn.gymnotesapp.R
import com.stefandn.gymnotesapp.databinding.ActivityLoginBinding
import com.stefandn.gymnotesapp.usescase.createAccount.CreateAccount

class Login : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setup()
    }


    fun setup(){
        goToSignUp()
    }

    fun goToSignUp(){
        binding.txtSignUpText.setOnClickListener {
            val intent = Intent(this, CreateAccount::class.java)
            startActivity(intent)
        }
    }
}