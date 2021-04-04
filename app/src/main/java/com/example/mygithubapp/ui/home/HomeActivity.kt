package com.example.mygithubapp.ui.home

import android.os.Bundle
import com.example.mygithubapp.di.component.ActivityComponent
import com.example.mygithubapp.ui.base.BaseActivity

class HomeActivity :BaseActivity<HomeViewModel>(){

    override fun provideLayoutId(): Int {
        TODO("Not yet implemented")
    }

    override fun injectDependencies(activityComponent: ActivityComponent) {

    }

    override fun setupView(savedInstanceState: Bundle?) {
        
    }

    override fun setupObservers() {

    }

}