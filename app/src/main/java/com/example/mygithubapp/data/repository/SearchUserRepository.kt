package com.example.mygithubapp.data.repository

import com.example.mygithubapp.data.model.UserData
import com.example.mygithubapp.data.remote.NetworkService
import io.reactivex.Single
import javax.inject.Inject

class SearchUserRepository @Inject constructor(
    private val networkService: NetworkService
) {

    fun fetchSearchUser(emailId : String): Single<List<UserData>> =
        networkService.doSearchUserCall(emailId).map { it.items }

}