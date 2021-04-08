package com.example.mygithubapp.di.component



import com.example.mygithubapp.di.ActivityScope
import com.example.mygithubapp.di.module.ActivityModule
import com.example.mygithubapp.ui.home.HomeActivity
import com.example.mygithubapp.ui.login.LoginActivity
import com.example.mygithubapp.ui.splash.SplashActivity
import com.example.mygithubapp.ui.webView.WebViewActivity

import dagger.Component

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ActivityModule::class]
)
interface ActivityComponent {

    fun inject(activity: SplashActivity)

    fun inject(activity: LoginActivity)

    fun inject(activity: HomeActivity)

    fun inject(activity: WebViewActivity)
}