package com.example.mygithubapp.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.mygithubapp.R
import com.example.mygithubapp.di.component.ActivityComponent
import com.example.mygithubapp.ui.base.BaseActivity
import com.example.mygithubapp.ui.home.repos.RepoAdapter
import com.example.mygithubapp.ui.login.LoginActivity
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject


class HomeActivity : BaseActivity<HomeViewModel>() {

    @Inject
    lateinit var linearLayoutManager: LinearLayoutManager

    @Inject
    lateinit var repoAdapter: RepoAdapter

    companion object {
        const val TAG = "HomeActivity"
    }

    override fun provideLayoutId(): Int = R.layout.activity_home

    override fun injectDependencies(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun setupView(savedInstanceState: Bundle?) {

        rv_repos_list.apply {
            layoutManager = linearLayoutManager
            adapter = repoAdapter
        }

        onOptionMenuClicked()
    }


    private fun onOptionMenuClicked() {
        toolbar.inflateMenu(R.menu.logout_home_activity).also {
            toolbar.setOnMenuItemClickListener {
                if (it.itemId == R.id.log_out_home) {
                    viewModel.onLogoutClicked()
                    true
                } else {
                    false
                }
            }
        }


    }

    override fun setupObservers() {
        super.setupObservers()

        viewModel.launchLogin.observe(this, Observer {
            it.getIfNotHandled()?.run {
                startActivity(Intent(applicationContext, LoginActivity::class.java))
                finish()
            }
        })


        viewModel.loading.observe(this, Observer {
            pb_loading_home.visibility = if (it) View.VISIBLE else View.GONE
        })

        viewModel.repos.observe(this, Observer {
            it.data?.run {
                repoAdapter.appendData(this)
            }
        })

        viewModel.userName.observe(this, Observer {
            it?.run { tv_username.text = it }
        })
        viewModel.userImageUrl.observe(this, Observer {
            it?.run {
                Glide.with(this@HomeActivity).load(it).into(iv_profile_image)
            }
        })
    }

}