package com.example.mygithubapp.ui.webView

import androidx.lifecycle.MutableLiveData
import com.example.mygithubapp.data.repository.SearchUserRepository
import com.example.mygithubapp.ui.base.BaseViewModel
import com.example.mygithubapp.utils.common.Event
import com.example.mygithubapp.utils.network.NetworkHelper
import com.example.mygithubapp.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class WebViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper,
    private val searchUserRepository: SearchUserRepository
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper) {


    val launchHome: MutableLiveData<Event<Map<String, String>>> = MutableLiveData()

    override fun onCreate() {

    }

    fun onBackPressed(){
        launchHome.postValue(Event(emptyMap()))
    }
}