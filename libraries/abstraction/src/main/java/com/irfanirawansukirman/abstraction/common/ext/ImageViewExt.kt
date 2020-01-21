package com.irfanirawansukirman.abstraction.common.ext

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.irfanirawansukirman.abstraction.BuildConfig
import com.irfanirawansukirman.abstraction.R

fun ImageView.load(path: String) {
    val baseImage = BuildConfig.BASE_IMAGE_MOVIE
    Glide.with(this)
        .load(baseImage + path.replace("\\", ""))
        .placeholder(R.drawable.cv_progress)
        .error(R.drawable.ic_error404)
        .into(this)
}

fun ImageView.loadWithCircleTransform(path: String) {
    val baseImage = BuildConfig.BASE_IMAGE_MOVIE
    Glide.with(this)
        .load(baseImage + path)
        .placeholder(R.drawable.cv_progress)
        .error(R.drawable.ic_error404)
        .circleCrop()
        .into(this)
}