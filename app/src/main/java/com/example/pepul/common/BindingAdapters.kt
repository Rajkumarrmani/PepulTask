package com.example.pepul.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.pepul.R


@BindingAdapter("imageUrl")
fun ImageView.loadImage(url: String?) {
    if (url.isNullOrEmpty()) return
    val requestOptions = RequestOptions()
    Glide.with(this)
        .load(url)
        .placeholder(R.drawable.ic_baseline_android_24)
        .error(R.drawable.ic_baseline_android_24)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .apply(requestOptions)
        .thumbnail(Glide.with(this).load(url))
        .into(this)
}
