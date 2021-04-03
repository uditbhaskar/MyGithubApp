package com.example.mygithubapp.ui.login

import androidx.lifecycle.MutableLiveData
import com.example.mygithubapp.data.repository.SearchUserRepository
import com.example.mygithubapp.ui.base.BaseViewModel
import com.example.mygithubapp.utils.common.DismissKeyboard
import com.example.mygithubapp.utils.common.Resource

import com.example.mygithubapp.utils.network.NetworkHelper
import com.example.mygithubapp.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class LoginViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper,
    private val searchUserRepository: SearchUserRepository
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper) {


    val emailField: MutableLiveData<String> = MutableLiveData()
    val searching: MutableLiveData<Boolean> = MutableLiveData()


    override fun onCreate() {

    }

    fun onEmailChange(email: String) = emailField.postValue(email)

    fun onSearching(){
        val email = emailField.value
        if(email.isNullOrBlank()){
            messageString.postValue(
                Resource.error("Email id can't be empty.")
            )
        }
        else if(checkInternetConnectionWithMessage()){
            searching.postValue(true)
            compositeDisposable.addAll(
                searchUserRepository.fetchSearchUser(email)
                    .subscribeOn(schedulerProvider.io())
                    .subscribe(
                        {
                            if(it.isEmpty()){
                                messageString.postValue(Resource.error("Check your Email id."))
                            }
                            searching.postValue(false)
                        },
                        {
                            handleNetworkError(it)
                            searching.postValue(false)
                        }
                    )
            )
        }

    }
}