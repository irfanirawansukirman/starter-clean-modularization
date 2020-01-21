package com.irfanirawansukirman.abstraction.common.ext

import android.graphics.Paint
import android.widget.TextView

fun TextView.textStrikeThrough(textStrikethrough: String) {
    text = textStrikethrough
    paintFlags = this.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
}