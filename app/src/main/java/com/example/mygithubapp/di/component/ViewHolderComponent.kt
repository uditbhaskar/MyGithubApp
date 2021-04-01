package com.example.mygithubapp.di.component

import com.example.mygithubapp.di.ViewModelScope
import com.example.mygithubapp.di.module.ViewHolderModule

import dagger.Component

@ViewModelScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ViewHolderModule::class]
)
interface ViewHolderComponent {


}