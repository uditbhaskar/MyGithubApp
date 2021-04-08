package com.example.mygithubapp.data.repository

import com.example.mygithubapp.data.local.db.DatabaseService
import com.example.mygithubapp.data.local.prefs.UserSearchPreferences
import com.example.mygithubapp.data.model.UserData
import com.example.mygithubapp.data.remote.NetworkService
import com.example.mygithubapp.data.remote.response.HomeRepoListResponse
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchUserRepository @Inject constructor(
    private val networkService: NetworkService,
    private val databaseService: DatabaseService,
    private val userSearchPreferences: UserSearchPreferences

) {

    fun saveCurrentSearchUSerData(userData: UserData) {
        userSearchPreferences.setLoginName(userData.login)
        userSearchPreferences.setAvatarUrl(userData.avatar_url)
        userSearchPreferences.setUserUrl(userData.url)
        userSearchPreferences.setReposUrl(userData.repos_url)

    }

    fun removeCurrentSearchUserData(){
        userSearchPreferences.removeLoginName()
        userSearchPreferences.removeAvatarUrl()
        userSearchPreferences.removeUserUrl()
        userSearchPreferences.removeReposUrl()
    }

    fun getCurrentSearchUSerData(): UserData? {
        val loginName = userSearchPreferences.getLoginName()
        val avatarUrl = userSearchPreferences.getAvatarUrl()
        val userUrl = userSearchPreferences.getUserUrl()
        val reposUrl = userSearchPreferences.getReposUrl()

        return if (loginName != null && avatarUrl != null && userUrl != null && reposUrl != null)
            UserData(loginName, avatarUrl, userUrl, reposUrl)
        else
            null
    }

    fun fetchSearchUser(emailId: String): Single<List<UserData>> =
        networkService.doSearchUserCall(emailId).map {
            it.items }


}

