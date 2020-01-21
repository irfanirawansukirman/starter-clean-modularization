/*
 * Copyright (C) 2017 Leonid Ustenko Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.irfanirawansukirman.lib_recyclerviewgenericadapter.decorator

import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView

/**
 * Item decorator {@link RecyclerView.ItemDecoration} which allows using
 * a custom drawable as a source.
 *
 * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
 * @since 1.0.0
 */

class DrawableItemDecorator(dividerDrawable: Drawable) :
    RecyclerView.ItemDecoration() {
    private val dividerDrawable: Drawable
    override fun onDrawOver(
        canvas: Canvas,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val adapter = parent.adapter ?: return
        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight
        for (i in 0 until adapter.itemCount - 2) {
            val child = parent.getChildAt(i) ?: continue
            val params =
                child.layoutParams as LinearLayout.LayoutParams
            val top = child.bottom + params.bottomMargin
            val bottom = top + dividerDrawable.intrinsicHeight
            dividerDrawable.setBounds(left, top, right, bottom)
            dividerDrawable.draw(canvas)
        }
    }

    /**
     * Validates a divider drawable.
     *
     * @param drawable which has to be used as a divider between [RecyclerView] items
     * @throws IllegalArgumentException in case drawable is `null` or has illegal size.
     * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
     * @since 1.0.0
     */
    @Throws(IllegalArgumentException::class)
    private fun validateDrawableOrThrow(drawable: Drawable?) {
        requireNotNull(drawable) { "Divider cannot be null" }
        require(!(drawable.intrinsicWidth <= 0 || drawable.intrinsicHeight <= 0)) { "Illegal divider drawable. Wrong size: width = " + drawable.intrinsicWidth + ", height = " + drawable.intrinsicHeight }
    }

    init {
        validateDrawableOrThrow(dividerDrawable)
        this.dividerDrawable = dividerDrawable
    }
}