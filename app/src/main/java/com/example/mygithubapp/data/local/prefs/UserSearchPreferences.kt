package com.example.mygithubapp.data.local.prefs

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserSearchPreferences @Inject constructor(private val prefs: SharedPreferences) {

    companion object {
        const val KEY_LOG_IN_NAME = "PREF_KEY_LOG_IN"
        const val KEY_AVATAR_URL = "PREF_KEY_AVATAR_URL"
        const val KEY_USER_URL = "PREF_KEY_USER_URL"
        const val KEY_REPOS_URL = "PREF_KEY_REPOS_URL"
    }

    fun getLoginName(): String? =
        prefs.getString(KEY_LOG_IN_NAME, null)

    fun setLoginName(loginName: String) =
        prefs.edit().putString(KEY_LOG_IN_NAME, loginName).apply()

    fun removeLoginName() =
        prefs.edit().remove(KEY_LOG_IN_NAME).apply()

    fun getAvatarUrl(): String? =
        prefs.getString(KEY_AVATAR_URL, null)

    fun setAvatarUrl(avatarUrl: String) =
        prefs.edit().putString(KEY_AVATAR_URL, avatarUrl).apply()

    fun removeAvatarUrl() =
        prefs.edit().remove(KEY_AVATAR_URL).apply()

    fun getUserUrl(): String? =
        prefs.getString(KEY_USER_URL, null)

    fun setUserUrl(userUrl: String) =
        prefs.edit().putString(KEY_USER_URL, userUrl).apply()

    fun removeUserUrl() =
        prefs.edit().remove(KEY_USER_URL).apply()

    fun getReposUrl(): String? =
        prefs.getString(KEY_REPOS_URL, null)

    fun setReposUrl(reposUrl: String) =
        prefs.edit().putString(KEY_REPOS_URL, reposUrl).apply()

    fun removeReposUrl() =
        prefs.edit().remove(KEY_REPOS_URL).apply()
}