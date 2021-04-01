package com.example.mygithubapp.di.module


import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mygithubapp.ui.base.BaseActivity
import dagger.Module
import dagger.Provides


/**
 * Kotlin Generics Reference: https://kotlinlang.org/docs/reference/generics.html
 * Basically it means that we can pass any class that extends BaseActivity which take
 * BaseViewModel subclass as parameter
 */

@Module
class ActivityModule(private val activity: BaseActivity<*>) {

    @Provides
    fun provideLinearLayoutManager(): LinearLayoutManager = LinearLayoutManager(activity)

}

