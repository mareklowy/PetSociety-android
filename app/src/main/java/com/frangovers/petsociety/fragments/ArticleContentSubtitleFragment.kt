package com.frangovers.petsociety.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.frangovers.petsociety.R
import kotlinx.android.synthetic.main.fragment_article_content_subtitle.view.*

class ArticleContentSubtitleFragment : Fragment() {

    var subtitle = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_article_content_subtitle, container, false)
    }

    override fun onStart() {
        super.onStart()
        updateUI()
    }

    private fun updateUI() {
        view?.apply {
            article_content_subtitle_textview.text = subtitle
        }
    }

}
