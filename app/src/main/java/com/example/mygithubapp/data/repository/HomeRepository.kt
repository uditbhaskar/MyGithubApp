package com.example.mygithubapp.data.repository

import com.example.mygithubapp.data.local.db.DatabaseService
import com.example.mygithubapp.data.remote.NetworkService
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val networkService: NetworkService,
    private val databaseService: DatabaseService
) {

}