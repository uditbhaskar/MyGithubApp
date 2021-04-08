package com.example.mygithubapp.utils.common

import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders

object GlideHelper {

    fun getProtectedUrl(url: String): GlideUrl {
        return GlideUrl(url)
    }
}
