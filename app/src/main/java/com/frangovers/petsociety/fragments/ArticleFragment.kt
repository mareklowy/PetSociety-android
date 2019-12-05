package com.frangovers.petsociety.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.frangovers.petsociety.MainActivity
import com.frangovers.petsociety.R
import com.frangovers.petsociety.api.data.Article
import com.frangovers.petsociety.api.data.ArticleContent
import com.frangovers.petsociety.helpers.ArticleContentTypes
import kotlinx.android.synthetic.main.fragment_article.*

class ArticleFragment : Fragment() {

    var article: Article? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_article, container, false)
    }

    override fun onStart() {
        super.onStart()
        updateUI()
    }

    override fun onResume() {
        super.onResume()
        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun updateUI() {
        article?.also {
            article_title_textview.text = it.title
            it.coverImage?.also { coverUrl ->
                this@ArticleFragment.context?.also { context ->
                    Glide.with(context)
                        .load(coverUrl)
                        .into(article_cover_imageview)
                }
            }
            loadArticleContents(it.data ?: listOf())
        }
    }

    private fun loadArticleContents(content: List<ArticleContent>) {
        content.forEach {
            when (it.type) {
                ArticleContentTypes.SUBTITLE.type -> {
                    val subtitleFragment = ArticleContentSubtitleFragment().apply {
                        subtitle = it.content ?: ""
                    }
                    addFragmentToLayout(subtitleFragment)
                }
                ArticleContentTypes.PARAGRAPH.type -> {
                    val paragraphFragment = ArticleContentParagraphFragment().apply {
                        paragraphText = it.content ?: ""
                    }
                    addFragmentToLayout(paragraphFragment)
                }
                ArticleContentTypes.IMAGE.type -> {
                    val imageFragment = ArticleContentImageFragment().apply {
                        imageUrl = it.content ?: ""
                    }
                    addFragmentToLayout(imageFragment)
                }
            }
        }
    }

    private fun addFragmentToLayout(fragment: Fragment) {
        activity?.supportFragmentManager?.beginTransaction()
            ?.add(R.id.article_content_layout, fragment)
            ?.commit()
    }

}
