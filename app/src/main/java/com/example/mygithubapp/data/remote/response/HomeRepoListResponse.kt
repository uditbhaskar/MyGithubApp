package com.example.mygithubapp.data.remote.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class HomeRepoListResponse (
    @Expose
    @SerializedName("name")
    var name:String,

    @Expose
    @SerializedName("description")
    var description: String,

    @Expose
    @SerializedName("stargazers_count")
    var stargazers_count:Int,

    @Expose
    @SerializedName("language")
    var language:String,

    @Expose
    @SerializedName("updated_at")
    var updated_at:String

)