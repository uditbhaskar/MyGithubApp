package com.example.mygithubapp.di.module

import androidx.lifecycle.LifecycleRegistry
import com.example.mygithubapp.di.ViewModelScope
import com.example.mygithubapp.ui.base.BaseItemViewHolder
import dagger.Module
import dagger.Provides

@Module
class ViewHolderModule(private val viewHolder: BaseItemViewHolder<*, *>) {

    @Provides
    @ViewModelScope
    fun provideLifecycleRegistry(): LifecycleRegistry = LifecycleRegistry(viewHolder)
}