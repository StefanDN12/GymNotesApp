package com.stefandn.gymnotesapp.usescase.createAccount

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.stefandn.gymnotesapp.R
import com.stefandn.gymnotesapp.databinding.ActivityCreateAccountBinding
import com.stefandn.gymnotesapp.usescase.login.Login

class CreateAccount : AppCompatActivity() {
    lateinit var binding: ActivityCreateAccountBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setup()
    }


    private fun setup(){
        comparePassword()
        goToLogin()
        buttonMessage()
    }

    private fun comparePassword(){

        binding.editCreateAccRepeatPassword.onFocusChangeListener = View.OnFocusChangeListener{view, focused ->
            var errTxt = ""
            if(!focused){
                if(binding.editCreateAccRepeatPassword.text.toString().isEmpty()){
                    errTxt = getString(R.string.required_repet_pass_create_acc_class)

                }else if(!binding.editCreateAccPassword.text.toString().equals(binding.editCreateAccRepeatPassword.text.toString())){
                    errTxt = getString(R.string.pass_no_same_create_acc_class)
                }
            }
            binding.inputCreateAccRepeatPassword.error = errTxt
        }
    }

    private fun goToLogin(){
        binding.txtGoToLogin.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    }

    private fun buttonMessage(){
        binding.btnSignUp.setOnClickListener {
            when{
                binding.editUser.text?.isEmpty()!! -> Toast.makeText(this,getString(R.string.btn_message_click_create_account_class), Toast.LENGTH_SHORT).show()
                binding.editEmail.text?.isEmpty()!! ->  Toast.makeText(this,getString(R.string.btn_message_click_create_account_class), Toast.LENGTH_SHORT).show()
                binding.editCreateAccPassword.text.toString()?.isEmpty()!! -> Toast.makeText(this,getString(R.string.btn_message_click_create_account_class), Toast.LENGTH_SHORT).show()
                binding.editCreateAccRepeatPassword.text.toString()?.isEmpty()!! -> Toast.makeText(this,getString(R.string.btn_message_click_create_account_class), Toast.LENGTH_SHORT).show()
            }
        }
    }

}