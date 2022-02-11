package com.example.android.videogameproject.util

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.android.videogameproject.R
import com.example.android.videogameproject.network.data.Results
import com.example.android.videogameproject.ui.main.MainAdapter

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    if(imgUrl != null)
    {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https")?.build()
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(
                RequestOptions()
                .override(450, 450)
                .fitCenter())
            .into(imgView)
    }
    else
    {
        Glide.with(imgView.context)
            .load(R.drawable.error_image)
            .apply(
                RequestOptions()
                .override(450, 450)
                .fitCenter())
            .into(imgView)
    }
}

@BindingAdapter("listVideoGames")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Results>?) {
    val adapter = recyclerView.adapter as MainAdapter
    adapter.submitList(data)
}
