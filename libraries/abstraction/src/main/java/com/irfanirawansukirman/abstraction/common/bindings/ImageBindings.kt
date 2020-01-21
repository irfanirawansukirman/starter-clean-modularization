package com.irfanirawansukirman.abstraction.common.bindings

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.irfanirawansukirman.abstraction.common.ext.load

object ImageBindings {
    @BindingAdapter("app:imageUrl")
    @JvmStatic
    fun loadImage(imageView: ImageView, imageUrl: String) {
        imageView.load(imageUrl)
    }
}