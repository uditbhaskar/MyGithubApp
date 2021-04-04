package com.example.mygithubapp.di.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.example.mygithubapp.BuildConfig
import com.example.mygithubapp.MyGithubApp
import com.example.mygithubapp.data.local.db.DatabaseService
import com.example.mygithubapp.data.remote.NetworkService
import com.example.mygithubapp.data.remote.Networking
import com.example.mygithubapp.di.ApplicationContext
import com.example.mygithubapp.utils.network.NetworkHelper
import com.example.mygithubapp.utils.rx.SchedulerProvider
import com.example.mygithubapp.utils.rx.RxSchedulerProvider


import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class ApplicationModule(private val applicationMy: MyGithubApp) {

    @Provides
    @Singleton
    fun provideApplication(): Application = applicationMy

    @Provides
    @Singleton
    @ApplicationContext
    fun provideContext(): Context = applicationMy

    /**
     * Since this function do not have @Singleton then each time CompositeDisposable is injected
     * then a new instance of CompositeDisposable will be provided
     */
    @Provides
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    fun provideSchedulerProvider(): SchedulerProvider = RxSchedulerProvider()

    @Provides
    @Singleton
    fun provideSharedPreferences(): SharedPreferences =
            applicationMy.getSharedPreferences("bootcamp-instagram-project-prefs", Context.MODE_PRIVATE)

    /**
     * We need to write @Singleton on the provide method if we are create the instance inside this method
     * to make it singleton. Even if we have written @Singleton on the instance's class
     */
    @Provides
    @Singleton
    fun provideDatabaseService(): DatabaseService =
            Room.databaseBuilder(
                    applicationMy, DatabaseService::class.java,
                    "bootcamp-instagram-project-db"
            ).build()

    @Provides
    @Singleton
    fun provideNetworkService(): NetworkService =
            Networking.create(
                    BuildConfig.BASE_URL,
                    applicationMy.cacheDir,
                    10 * 1024 * 1024 // 10MB
            )

    @Singleton
    @Provides
    fun provideNetworkHelper(): NetworkHelper = NetworkHelper(applicationMy)
}