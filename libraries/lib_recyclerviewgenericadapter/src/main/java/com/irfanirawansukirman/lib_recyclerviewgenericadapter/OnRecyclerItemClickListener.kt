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

/**
 * The most commonly used listener with the [GenericRecyclerViewAdapter].
 * It is sutable for all cases where one click listener for a RecyclerView item is enough.
 * Otherwise (if for instance, you have multiple Butoons on an item), you will have to create a custom listener and define there as many callbacks as you need. Just make sure it extends from [BaseRecyclerListener] or [OnRecyclerItemClickListener]
 *
 * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
 * @since 1.0.0
 */
interface OnRecyclerItemClickListener : BaseRecyclerListener {
    /**
     * Returns clicked item position [androidx.recyclerview.widget.RecyclerView.ViewHolder.getAdapterPosition]
     *
     * @param position clicked item position.
     */
    fun onItemClick(position: Int)
}