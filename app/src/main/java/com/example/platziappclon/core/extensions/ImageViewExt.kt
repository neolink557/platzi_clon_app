package com.example.platziappclon.core.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.load(url: String) {
    if (url.isNotEmpty()) {
        Glide.with(this.context).load(url).override(400, 400).centerCrop().into(this)
    }
}