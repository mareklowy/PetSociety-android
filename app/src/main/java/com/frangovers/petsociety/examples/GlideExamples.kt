package com.frangovers.petsociety.examples

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.frangovers.petsociety.R

object GlideExamples {

    //Context can be accessed as property in fragment, or activity reference can be supplied
    //Anko makes accessing image views by id simple

    fun GlideLoadBasic(context: Context, imageView: ImageView) {
        Glide.with(context)
            .load("https://url")
            .into(imageView)
    }

    fun GlideLoadCircle(context: Context, imageView: ImageView) {
        Glide.with(context)
            .load("https://url")
            .apply(RequestOptions.circleCropTransform())
            .into(imageView)
    }

    fun GlideLoadDrawable(context: Context, imageView: ImageView) {
        Glide.with(context)
            .load(R.drawable.ic_launcher_foreground)
            .into(imageView)
    }
}