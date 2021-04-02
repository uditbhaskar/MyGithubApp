package com.example.mygithubapp.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserData(
    @Expose
    @SerializedName("login")
    val login:String,

    @Expose
    @SerializedName("avatar_url")
    val avatar_url: String,

    @Expose
    @SerializedName("url")
    val url:String,

    @Expose
    @SerializedName("repos_url")
    val repos_url:String
)