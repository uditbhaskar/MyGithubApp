package com.example.mygithubapp.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.mygithubapp.R
import com.example.mygithubapp.di.component.ActivityComponent
import com.example.mygithubapp.ui.base.BaseActivity
import com.example.mygithubapp.ui.login.LoginActivity

class SplashActivity : BaseActivity<SplashViewModel>(){

    companion object {
        const val TAG = "SplashActivity"
    }

    override fun provideLayoutId(): Int = R.layout.activity_splash

    override fun injectDependencies(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun setupView(savedInstanceState: Bundle?) {

    }

    override fun setupObservers() {
        viewModel.launchLogin.observe(this, Observer {
            it.getIfNotHandled()?.run {
                startActivity(Intent(applicationContext, LoginActivity::class.java))
            }
        })
    }
}