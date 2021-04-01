package com.example.mygithubapp

import android.app.Application
import com.example.mygithubapp.di.component.ApplicationComponent
import com.example.mygithubapp.di.component.DaggerApplicationComponent
import com.example.mygithubapp.di.module.ApplicationModule

class MyGithubApp :Application(){

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
    }

    private fun injectDependencies() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }
}

