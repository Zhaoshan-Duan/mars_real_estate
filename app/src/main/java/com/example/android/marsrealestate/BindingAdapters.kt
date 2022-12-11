/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.example.android.marsrealestate

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.android.marsrealestate.network.MarsProperty
import com.example.android.marsrealestate.overview.PhotoGridAdapter

// Create the Binding Adapter, converting the imgSrcUrl to a URI with http schemes
@BindingAdapter("imageUrl") // execute when the XML item has an imageUrl attribute
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {

        // convert the imageUrl to a URI with https: scheme
        val imgUri = it.toUri().buildUpon().scheme("https").build()

        Glide.with(imgView.context)
            .load(imgUri)
            .apply(RequestOptions()
                .placeholder(R.drawable.loading_animation) // add loading animation
                .error(R.drawable.ic_broken_image))
            .into(imgView)

    }
}

// called automatically when the Mars property list changes
@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<MarsProperty>?){
    val adapter = recyclerView.adapter as PhotoGridAdapter

    adapter.submitList(data)
}

// Use Glide to load the imgUri into the imgView

// add the requestOptions for the placeholder and error into the Glide call