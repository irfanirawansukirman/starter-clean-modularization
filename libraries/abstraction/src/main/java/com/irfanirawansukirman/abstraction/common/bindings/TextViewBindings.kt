package com.irfanirawansukirman.abstraction.common.bindings

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.irfanirawansukirman.abstraction.common.ext.textStrikeThrough

object TextViewBindings {
    @BindingAdapter("app:textStrikeThrough")
    @JvmStatic
    fun setupTextStrikeThrough(textView: TextView, textStrikeThrough: String) {
        textView.textStrikeThrough(textStrikeThrough)
    }
}