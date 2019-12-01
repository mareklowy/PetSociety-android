package com.frangovers.petsociety.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.frangovers.petsociety.R
import kotlinx.android.synthetic.main.fragment_article_content_image.view.*

class ArticleContentImageFragment : Fragment() {

    var imageUrl = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_article_content_image, container, false)
    }

    override fun onStart() {
        super.onStart()
        updateUI()
    }

    private fun updateUI() {
        view?.apply {
            context?.also {
                Glide.with(it)
                    .load(imageUrl)
                    .into(article_content_image_imageview)
            }
        }
    }
}
