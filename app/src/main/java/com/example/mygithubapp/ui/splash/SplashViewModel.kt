package com.example.mygithubapp.ui.splash

import androidx.lifecycle.MutableLiveData
import com.example.mygithubapp.ui.base.BaseViewModel
import com.example.mygithubapp.utils.common.Event
import com.example.mygithubapp.utils.network.NetworkHelper
import com.example.mygithubapp.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class SplashViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper
): BaseViewModel(schedulerProvider, compositeDisposable, networkHelper) {

    val launchLogin: MutableLiveData<Event<Map<String, String>>> = MutableLiveData()


    override fun onCreate() {
        launchLogin.postValue(Event(emptyMap()))
    }
}