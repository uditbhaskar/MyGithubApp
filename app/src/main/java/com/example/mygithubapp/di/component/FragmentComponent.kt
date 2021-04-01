package com.example.mygithubapp.di.component

import com.example.mygithubapp.di.FragmentScope
import com.example.mygithubapp.di.module.FragmentModule

import dagger.Component

@FragmentScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [FragmentModule::class]
)
interface FragmentComponent {


}