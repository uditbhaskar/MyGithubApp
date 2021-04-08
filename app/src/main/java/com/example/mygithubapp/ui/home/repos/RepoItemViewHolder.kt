package com.example.mygithubapp.ui.home.repos

import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.mygithubapp.R
import com.example.mygithubapp.data.remote.response.HomeRepoListResponse
import com.example.mygithubapp.di.component.ViewHolderComponent
import com.example.mygithubapp.ui.base.BaseItemViewHolder
import kotlinx.android.synthetic.main.item_view_repos.view.*

class RepoItemViewHolder(parent: ViewGroup) :
    BaseItemViewHolder<HomeRepoListResponse, RepoItemViewModel>(R.layout.item_view_repos, parent) {


    override fun injectDependencies(viewHolderComponent: ViewHolderComponent) =
        viewHolderComponent.inject(this)


    override fun setupView(view: View) {

    }

    override fun setupObservers() {
        super.setupObservers()

        viewModel.countStars.observe(this, Observer {
            itemView.tv_stargazers.text = it.toString()

        })

        viewModel.description.observe(this, Observer {
                itemView.tv_description.text = it

        })

        viewModel.language.observe(this, Observer {

            itemView.tv_language.text = it

        })

        viewModel.repoName.observe(this, Observer {
            itemView.tv_repo_name.text = it
        })

        viewModel.lastCreatedTime.observe(this, Observer {
            itemView.tv_updated_at.text = "Created: $it"
        })
    }

}