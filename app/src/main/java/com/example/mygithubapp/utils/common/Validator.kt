package com.example.mygithubapp.utils.common

import com.example.mygithubapp.R
import java.util.regex.Pattern

object Validator {

    private val EMAIL_ADDRESS = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )

    fun validateEmail(email: String?): Boolean {
        var z:Boolean = true
        when{
            !EMAIL_ADDRESS.matcher(email).matches() ->
                z=false
        }
        return z
    }
}