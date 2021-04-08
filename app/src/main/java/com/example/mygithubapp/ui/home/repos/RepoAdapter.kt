package com.example.mygithubapp.ui.home.repos

import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import com.example.mygithubapp.data.remote.response.HomeRepoListResponse
import com.example.mygithubapp.ui.base.BaseAdapter

class RepoAdapter(
    parentLifecycle: Lifecycle,
    repos: ArrayList<HomeRepoListResponse>
) : BaseAdapter<HomeRepoListResponse, RepoItemViewHolder>(parentLifecycle, repos) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = RepoItemViewHolder(parent)
}