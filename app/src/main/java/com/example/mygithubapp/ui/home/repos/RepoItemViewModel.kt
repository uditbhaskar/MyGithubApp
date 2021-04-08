package com.example.mygithubapp.ui.home.repos

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.mygithubapp.data.remote.response.HomeRepoListResponse
import com.example.mygithubapp.data.repository.HomeRepository
import com.example.mygithubapp.data.repository.SearchUserRepository
import com.example.mygithubapp.ui.base.BaseItemViewModel
import com.example.mygithubapp.utils.network.NetworkHelper
import com.example.mygithubapp.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class RepoItemViewModel @Inject constructor(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper,
    private val searchUserRepository: SearchUserRepository,
    private val homeRepository: HomeRepository
) : BaseItemViewModel<HomeRepoListResponse>(schedulerProvider, compositeDisposable, networkHelper) {

    val repoName:LiveData<String> = Transformations.map(data){ it.name}
    val lastCreatedTime:LiveData<String> = Transformations.map(data){ formatDate(it.created_at)}
    val description :LiveData<String> = Transformations.map(data){it.description}
    val countStars:LiveData<Int> = Transformations.map(data){it.stargazers_count}
    val language:LiveData<String> = Transformations.map(data){it.language}
    val url:LiveData<String> = Transformations.map(data){it.html_url}

    companion object {
        const val TAG = "RepoItemViewModel"
    }

    override fun onCreate() {

    }


    private fun formatDate(stringDate: String): String {

            return stringDate.substring(0,10)

    }



}