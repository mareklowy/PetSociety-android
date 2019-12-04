package com.frangovers.petsociety.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.frangovers.petsociety.R
import kotlinx.android.synthetic.main.fragment_article_content_paragraph.view.*

class ArticleContentParagraphFragment : Fragment() {

    var paragraphText = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_article_content_paragraph, container, false)
    }

    override fun onStart() {
        super.onStart()
        updateUI()
    }

    private fun updateUI() {
        view?.apply {
            article_content_paragraph_textview.text = paragraphText
        }
    }

}
