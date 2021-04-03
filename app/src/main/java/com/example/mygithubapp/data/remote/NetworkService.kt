package com.example.mygithubapp.data.remote


import com.example.mygithubapp.data.remote.response.SearchUserResponse
import io.reactivex.Single
import retrofit2.http.*
import javax.inject.Singleton

@Singleton
interface NetworkService {

    @GET(Endpoints.SEARCH_USER)
    fun doSearchUserCall(
        @Query("q") emailId: String
    ): Single<SearchUserResponse>

}