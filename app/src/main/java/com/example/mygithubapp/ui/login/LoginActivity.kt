package com.example.mygithubapp.ui.login

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.lifecycle.Observer
import com.example.mygithubapp.R
import com.example.mygithubapp.di.component.ActivityComponent
import com.example.mygithubapp.ui.base.BaseActivity
import com.example.mygithubapp.ui.home.HomeActivity
import com.example.mygithubapp.utils.common.DismissKeyboard
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity<LoginViewModel>() {


    companion object {
        const val TAG = "LoginActivity"
    }

    override fun provideLayoutId(): Int = R.layout.activity_login

    override fun injectDependencies(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun setupView(savedInstanceState: Bundle?) {
        et_email.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.onEmailChange(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        })

        bt_search.setOnClickListener {
            viewModel.onSearching()
            DismissKeyboard.hideSoftKeyBoard(
                this,
                window.decorView.findViewById(android.R.id.content)
            )
        }
    }




    override fun setupObservers() {
        super.setupObservers()

        viewModel.emailField.observe(this, Observer {
            if (et_email.text.toString() != it.toString()) et_email.setText(it)
        })

        viewModel.searching.observe(this, Observer {
            pb_loading.visibility = if (it) View.VISIBLE else View.GONE
        })

        viewModel.launchHome.observe(this, Observer {
            it.getIfNotHandled()?.run {
                startActivity(Intent(applicationContext, HomeActivity::class.java))
                finish()
            }
        })
    }
}