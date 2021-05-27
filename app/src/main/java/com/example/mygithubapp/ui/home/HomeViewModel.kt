package com.example.mygithubapp.ui.home

import androidx.lifecycle.MutableLiveData
import com.example.mygithubapp.R
import com.example.mygithubapp.data.remote.response.HomeRepoListResponse
import com.example.mygithubapp.data.repository.HomeRepository
import com.example.mygithubapp.data.repository.SearchUserRepository
import com.example.mygithubapp.ui.base.BaseViewModel
import com.example.mygithubapp.utils.common.Event
import com.example.mygithubapp.utils.common.Resource
import com.example.mygithubapp.utils.network.NetworkHelper
import com.example.mygithubapp.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable


class HomeViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper,
    private val searchUserRepository: SearchUserRepository,
    private val homeRepository: HomeRepository,
    private val reposList: ArrayList<HomeRepoListResponse>
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper) {

    val launchLogin: MutableLiveData<Event<Map<String, String>>> = MutableLiveData()
    val loading: MutableLiveData<Boolean> = MutableLiveData()
    val userName: MutableLiveData<String> = MutableLiveData()
    val userImageUrl: MutableLiveData<String> = MutableLiveData()
    private val userLoginName = searchUserRepository.getCurrentSearchUSerData()?.login
    val repos: MutableLiveData<Resource<List<HomeRepoListResponse>>> = MutableLiveData()



    override fun onCreate() {
        val nameCurrent = searchUserRepository.getCurrentSearchUSerData()?.login
        val imageUrlCurrent = searchUserRepository.getCurrentSearchUSerData()?.avatar_url
        fetchRepoList(nameCurrent)
        userName.postValue(nameCurrent)
        userImageUrl.postValue(imageUrlCurrent)

    }



    private fun fetchRepoList(username : String?){
        if(checkInternetConnectionWithMessage() && !username.isNullOrEmpty()){
                compositeDisposable.addAll(
                    homeRepository.fetchHomeReposList(username)
                        .subscribeOn(schedulerProvider.io())
                        .subscribe(
                            {
                                repos.postValue(Resource.success(it))
                                loading.postValue(false)
                            },
                            {
                                handleNetworkError(it)
                                loading.postValue(false)
                            }
                        )
                )
        }
    }




    fun onLogoutClicked() {
        searchUserRepository.removeCurrentSearchUserData()
        launchLogin.postValue(Event(emptyMap()))
        messageStringId.postValue(Resource.success(R.string.logged_out))
    }
}