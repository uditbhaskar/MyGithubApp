package com.example.mygithubapp.ui.login

import androidx.lifecycle.MutableLiveData
import com.example.mygithubapp.R
import com.example.mygithubapp.data.repository.SearchUserRepository
import com.example.mygithubapp.ui.base.BaseViewModel
import com.example.mygithubapp.utils.common.Resource
import com.example.mygithubapp.utils.common.Validator
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

    fun onSearching() {

        val email = emailField.value

        if (!email.isNullOrEmpty()) {
            if (!Validator.validateEmail(email)) {
                messageStringId.postValue(
                    Resource.error(R.string.email_field_invalid)
                )

            } else if (checkInternetConnectionWithMessage()) {
                searching.postValue(true)
                compositeDisposable.addAll(
                    searchUserRepository.fetchSearchUser(email)
                        .subscribeOn(schedulerProvider.io())
                        .subscribe(
                            {
                                if (it.isEmpty()) {
                                    messageString.postValue(Resource.error("Check your Email id."))
                                }else{
                                    searchUserRepository.saveCurrentSearchUSerData(it[0])
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
        } else messageStringId.postValue(
            Resource.error(R.string.email_field_empty)
        )

    }
}