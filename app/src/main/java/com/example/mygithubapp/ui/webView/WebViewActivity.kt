package com.example.mygithubapp.ui.webView

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.lifecycle.Observer
import com.example.mygithubapp.R
import com.example.mygithubapp.di.component.ActivityComponent
import com.example.mygithubapp.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_webview.*


class WebViewActivity : BaseActivity<WebViewModel>() {

    companion object {
        const val TAG = "WebViewActivity"
    }


    override fun provideLayoutId(): Int = R.layout.activity_webview

    override fun injectDependencies(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun setupView(savedInstanceState: Bundle?) {

        web_view.apply {
            settings.javaScriptEnabled = true
            webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                    view?.loadUrl(url)
                    return true
                }

                override fun onPageCommitVisible(view: WebView?, url: String?) {
                    super.onPageCommitVisible(view, url)
                    progressBar.visibility = View.GONE
                }
            }

            web_view.loadUrl(intent.getStringExtra("url"))

        }



        iv_back.setOnClickListener {
            viewModel.onBackPressed()
        }
    }

    override fun setupObservers() {
        super.setupObservers()

        viewModel.launchHome.observe(this, Observer {
            it.getIfNotHandled()?.run {
                finish()
            }
        })
    }
}