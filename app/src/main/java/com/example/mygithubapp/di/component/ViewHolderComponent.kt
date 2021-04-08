package com.example.mygithubapp.di.component

import com.example.mygithubapp.di.ViewModelScope
import com.example.mygithubapp.di.module.ViewHolderModule
import com.example.mygithubapp.ui.home.repos.RepoItemViewHolder

import dagger.Component

@ViewModelScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ViewHolderModule::class]
)
interface ViewHolderComponent {

    fun inject(itemViewHolder: RepoItemViewHolder)
}