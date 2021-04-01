package com.example.mygithubapp.data.remote

import com.example.mygithubapp.data.remote.Endpoints
import com.example.mygithubapp.data.remote.Networking
import com.example.mygithubapp.data.remote.request.DummyRequest
import com.example.mygithubapp.data.remote.response.DummyResponse
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import javax.inject.Singleton

@Singleton
interface NetworkService {

    @POST(Endpoints.DUMMY)
    fun doDummyCall(
        @Body request: DummyRequest,
        @Header(Networking.HEADER_API_KEY) apiKey: String = Networking.API_KEY // default value set when Networking create is called
    ): Single<DummyResponse>


}