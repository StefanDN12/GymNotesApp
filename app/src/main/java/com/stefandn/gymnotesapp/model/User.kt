package com.stefandn.gymnotesapp.model

import java.util.*
import kotlin.collections.ArrayList

data class User(
    val uuid: UUID,
    val name: String,
    val email: String,
    val password: String,
    val exercises: ArrayList<String>
)
