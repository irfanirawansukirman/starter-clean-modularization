package com.irfanirawansukirman.abstraction.common.ext

import androidx.recyclerview.widget.*

fun RecyclerView.verticalList(isReverse: Boolean = false, isDividerVisible: Boolean = false) {
    layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, isReverse)
    itemAnimator = DefaultItemAnimator()
    isNestedScrollingEnabled = false
    if (isDividerVisible) {
        addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
    }
}

fun RecyclerView.horizontalList(isReverse: Boolean) {
    layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, isReverse)
    itemAnimator = DefaultItemAnimator()
    isNestedScrollingEnabled = false
}

fun RecyclerView.gridList() {
    layoutManager = GridLayoutManager(context, 2)
    itemAnimator = DefaultItemAnimator()
    isNestedScrollingEnabled = false
}

