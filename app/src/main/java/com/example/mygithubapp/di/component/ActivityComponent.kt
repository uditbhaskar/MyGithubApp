package com.example.mygithubapp.di.component



import com.example.mygithubapp.di.ActivityScope
import com.example.mygithubapp.di.module.ActivityModule
import com.example.mygithubapp.ui.splash.SplashActivity

import dagger.Component

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ActivityModule::class]
)
interface ActivityComponent {

    fun inject(activity: SplashActivity)

}