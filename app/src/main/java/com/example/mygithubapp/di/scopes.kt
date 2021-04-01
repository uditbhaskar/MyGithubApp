package com.example.mygithubapp.di

import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.SOURCE)
annotation class ActivityScope


@Scope
@Retention(AnnotationRetention.SOURCE)
annotation class FragmentScope

@Scope
@Retention(AnnotationRetention.SOURCE)
annotation class ViewModelScope