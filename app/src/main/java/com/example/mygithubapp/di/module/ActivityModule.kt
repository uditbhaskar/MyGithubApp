package com.example.mygithubapp.di.module


import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mygithubapp.data.remote.response.HomeRepoListResponse
import com.example.mygithubapp.data.repository.HomeRepository
import com.example.mygithubapp.data.repository.SearchUserRepository
import com.example.mygithubapp.ui.base.BaseActivity
import com.example.mygithubapp.ui.home.HomeViewModel
import com.example.mygithubapp.ui.home.repos.RepoAdapter
import com.example.mygithubapp.ui.login.LoginViewModel
import com.example.mygithubapp.ui.splash.SplashViewModel
import com.example.mygithubapp.utils.ViewModelProviderFactory
import com.example.mygithubapp.utils.network.NetworkHelper
import com.example.mygithubapp.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.processors.PublishProcessor


/**
 * Kotlin Generics Reference: https://kotlinlang.org/docs/reference/generics.html
 * Basically it means that we can pass any class that extends BaseActivity which take
 * BaseViewModel subclass as parameter
 */

@Module
class ActivityModule(private val activity: BaseActivity<*>) {

    @Provides
    fun provideLinearLayoutManager(): LinearLayoutManager = LinearLayoutManager(activity)

    @Provides
    fun provideRepoAdapter() = RepoAdapter(activity.lifecycle,ArrayList())

    @Provides
    fun providesSplashViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        searchUserRepository: SearchUserRepository
    ): SplashViewModel = ViewModelProviders.of(
        activity, ViewModelProviderFactory(SplashViewModel::class) {
            SplashViewModel(
                schedulerProvider,
                compositeDisposable,
                networkHelper,
                searchUserRepository
            )
        }).get(SplashViewModel::class.java)

    @Provides
    fun providesLoginViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        searchUserRepository: SearchUserRepository

    ): LoginViewModel = ViewModelProviders.of(
        activity, ViewModelProviderFactory(LoginViewModel::class) {
            LoginViewModel(
                schedulerProvider,
                compositeDisposable,
                networkHelper,
                searchUserRepository
            )
        }).get(LoginViewModel::class.java)

    @Provides
    fun providesHomeViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        searchUserRepository: SearchUserRepository,
        homeRepository: HomeRepository
    ): HomeViewModel = ViewModelProviders.of(
        activity, ViewModelProviderFactory(HomeViewModel::class) {
            HomeViewModel(
                schedulerProvider,
                compositeDisposable,
                networkHelper,
                searchUserRepository,
                homeRepository,
                ArrayList<HomeRepoListResponse>()
            )
        }).get(HomeViewModel::class.java)
}

