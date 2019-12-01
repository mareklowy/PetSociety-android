package com.frangovers.petsociety.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.frangovers.petsociety.R
import com.frangovers.petsociety.api.data.Article
import kotlinx.android.synthetic.main.cell_article.view.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class ArticleAdapter(
    private val context: Context?,
    var articles: List<Article>,
    var onClick: (article: Article) -> Unit
) : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {

    override fun getItemCount() = articles.size

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        articles[position].let {
            holder.bind(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.cell_article, parent, false)

        return ArticleViewHolder(view)
    }

    //MARK: ViewHolder
    inner class ArticleViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(article: Article) {
            view.apply {
                article_cell_title_textview.text = article.title
                article_cell_text_imageview.text = article.description
                article.coverImage?.also {
                    Log.d("COVER", it)
                    Glide.with(context)
                        .load(it)
                        .into(article_cell_image_imageview)
                }
                view.onClick {
                    this@ArticleAdapter.onClick(article)
                }
            }
        }
    }
}