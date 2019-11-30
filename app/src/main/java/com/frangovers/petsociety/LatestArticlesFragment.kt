package com.frangovers.petsociety


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.frangovers.petsociety.adapters.ArticleAdapter
import com.frangovers.petsociety.api.ApiResponseType
import com.frangovers.petsociety.api.DataProvider
import com.frangovers.petsociety.api.data.Article
import kotlinx.android.synthetic.main.fragment_latest_articles.*

/**
 * A simple [Fragment] subclass.
 */
class LatestArticlesFragment : Fragment() {

    private var articles: List<Article>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_latest_articles, container, false)
    }

    override fun onStart() {
        super.onStart()
        setupRecycler()
        getArticles {
            updateUI()
        }
    }

    private fun setupRecycler() {
        latest_articles_articles_recyclerview.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = ArticleAdapter(context, articles ?: listOf()) {
                //TODO: Open Article
            }
        }
    }

    fun updateUI() {
        setupRecycler()
    }

    fun getArticles(completion: () -> Unit) {
        DataProvider.getArticles { response, articles ->
            if (response.type == ApiResponseType.SUCCESS) {
                this.articles = articles
            }
            completion()
        }
    }

}
