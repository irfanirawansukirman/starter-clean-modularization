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
package com.irfanirawansukirman.lib_recyclerviewgenericadapter

import androidx.recyclerview.widget.DiffUtil

/**
 * Abstract diff util calback [DiffUtil.Callback]
 * which simplifies concrete implementation by doing some basics.
 * Just extend it with specifying a Type and implement remaining abstract methods,
 * such as [DiffUtil.Callback.areItemsTheSame] and
 * [DiffUtil.Callback.areContentsTheSame]
 *
 * @param <T> type of objects used in the adapter's datasetzx
 * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
 * @since 1.0.0
</T> */
abstract class BaseDiffCallback<T>(
    val oldItems: List<T>,
    val newItems: List<T>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldItems.size
    }

    override fun getNewListSize(): Int {
        return newItems.size
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        return super.getChangePayload(oldItemPosition, newItemPosition)
    }

}