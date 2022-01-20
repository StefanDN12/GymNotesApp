package com.stefandn.gymnotesapp.provider.services

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import com.stefandn.gymnotesapp.R
import com.stefandn.gymnotesapp.model.User
import kotlinx.coroutines.*
import kotlinx.coroutines.tasks.await


object FirebaseService {

    private var userAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private var fireStoreUsers: FirebaseFirestore = FirebaseFirestore.getInstance()
    private lateinit var userFb: FirebaseUser

    fun registerUser(user: User, context: Context):Boolean{
        var success = true
        if(user.email.isNotEmpty() && user.password.isNotEmpty()){

            CoroutineScope(Dispatchers.IO).launch {
                try {
                    userAuth.createUserWithEmailAndPassword(user.email, user.password).await()

                    userFb= userAuth.currentUser!!

                    fireStoreUsers.collection(context.getString(R.string.users_firebase_coll)).document(userFb.uid).set(
                        hashMapOf(  "uuid" to userFb.uid,
                                    "name" to user.name,
                                    "email" to user.email,
                                    "photo" to null,
                                    "exercises" to user.exercises
                                    )
                    )
                }catch (ex: Exception){
                    withContext(Dispatchers.Main){
                        success = false
                    }
                }
            }
        }
        return success
    }

    fun logIn(email:String, password:String, context: Context){
        if(email.isNotEmpty() && password.isNotEmpty()){
            CoroutineScope(Dispatchers.IO).launch {
                try{
                    userAuth.signInWithEmailAndPassword(email, password).await()
                    withContext(Dispatchers.Main){
                        checkLoggerIntState()
                    }
                }catch (ex: Exception){
                    withContext(Dispatchers.Main){
                        Toast.makeText(context, ex.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }



    fun checkLoggerIntState(){
        val user = userAuth.currentUser


        if(user == null){
            Log.e("Logg Firebase", "Not Loggin")
        }else{
            Log.e("Logged", "You are logged")
        }
    }

}