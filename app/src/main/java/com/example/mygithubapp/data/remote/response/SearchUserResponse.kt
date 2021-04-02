package com.example.mygithubapp.data.remote.response

import com.example.mygithubapp.data.model.UserData
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SearchUserResponse(
    @Expose
    @SerializedName("total_count")
    var total_count: Int,

    @Expose
    @SerializedName("incomplete_results")
    var incomplete_results: Boolean,

    @Expose
    @SerializedName("items")
    val items: List<UserData>
)