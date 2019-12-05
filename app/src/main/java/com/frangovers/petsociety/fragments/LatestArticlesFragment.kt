package com.frangovers.petsociety.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.frangovers.petsociety.MainActivity
import com.frangovers.petsociety.R
import com.frangovers.petsociety.adapters.ArticleAdapter
import com.frangovers.petsociety.api.ApiResponseType
import com.frangovers.petsociety.api.DataProvider
import com.frangovers.petsociety.api.data.Article
import com.frangovers.petsociety.helpers.ArticleCategories
import com.frangovers.petsociety.helpers.ScreenManager
import kotlinx.android.synthetic.main.fragment_latest_articles.*
import org.jetbrains.anko.backgroundDrawable
import org.jetbrains.anko.sdk25.coroutines.onClick

class LatestArticlesFragment : Fragment() {

    private var articles: List<Article>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_latest_articles, container, false)
    }

    override fun onStart() {
        super.onStart()
        setupRecycler()
        setupCategoriesOnClicks()
        getArticles {
            updateUI()
        }
    }

    override fun onResume() {
        super.onResume()
        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)

        updateCategoryButtonsBackgrouds()
    }

    private fun setupRecycler() {
        latest_articles_articles_recyclerview.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = ArticleAdapter(context, listOf()) {
                openArticle(it)
            }
        }
    }

    private fun updateRecycler() {
        latest_articles_articles_recyclerview.apply {
            (adapter as ArticleAdapter).articles = buildArticles()
            (adapter as ArticleAdapter).notifyDataSetChanged()
        }
    }

    private fun updateUI() {
        updateRecycler()
    }

    private fun getArticles(completion: () -> Unit) {
        DataProvider.getArticles { response, articles ->
            if (response.type == ApiResponseType.SUCCESS) {
                this.articles = articles
            }
            completion()
        }
    }

    private fun openArticle(article: Article) {
        val articleFragment = ArticleFragment().apply {
            this.article = article
        }
        ScreenManager.replaceFrame(activity, articleFragment, true)
    }

    private fun setupCategoriesOnClicks() {
        latest_articles_filter_health_button.onClick {
            latest_articles_filter_health_button.backgroundDrawable =
                if (ArticleCategories.HEALTH.selected) ContextCompat.getDrawable(
                    activity!!,
                    R.drawable.dw_articles_filter_button_rounded
                )
                else ContextCompat.getDrawable(
                    activity!!,
                    R.drawable.dw_articles_filter_button_selected_rounded
                )
            ArticleCategories.HEALTH.selected = !ArticleCategories.HEALTH.selected
            updateRecycler()
        }

        latest_articles_filter_training_button.onClick {
            latest_articles_filter_training_button.backgroundDrawable =
                if (ArticleCategories.TRAINING.selected) ContextCompat.getDrawable(
                    activity!!,
                    R.drawable.dw_articles_filter_button_rounded
                )
                else ContextCompat.getDrawable(
                    activity!!,
                    R.drawable.dw_articles_filter_button_selected_rounded
                )
            ArticleCategories.TRAINING.selected = !ArticleCategories.TRAINING.selected
            updateRecycler()
        }

        latest_articles_filter_care_button.onClick {
            latest_articles_filter_care_button.backgroundDrawable =
                if (ArticleCategories.CARE.selected) ContextCompat.getDrawable(
                    activity!!,
                    R.drawable.dw_articles_filter_button_rounded
                )
                else ContextCompat.getDrawable(
                    activity!!,
                    R.drawable.dw_articles_filter_button_selected_rounded
                )
            ArticleCategories.CARE.selected = !ArticleCategories.CARE.selected
            updateRecycler()
        }

        latest_articles_filter_breeds_button.onClick {
            latest_articles_filter_breeds_button.backgroundDrawable =
                if (ArticleCategories.BREEDS.selected) ContextCompat.getDrawable(
                    activity!!,
                    R.drawable.dw_articles_filter_button_rounded
                )
                else ContextCompat.getDrawable(
                    activity!!,
                    R.drawable.dw_articles_filter_button_selected_rounded
                )
            ArticleCategories.BREEDS.selected = !ArticleCategories.BREEDS.selected
            updateRecycler()
        }

        latest_articles_filter_food_button.onClick {
            latest_articles_filter_food_button.backgroundDrawable =
                if (ArticleCategories.FOOD.selected) ContextCompat.getDrawable(
                    activity!!,
                    R.drawable.dw_articles_filter_button_rounded
                )
                else ContextCompat.getDrawable(
                    activity!!,
                    R.drawable.dw_articles_filter_button_selected_rounded
                )
            ArticleCategories.FOOD.selected = !ArticleCategories.FOOD.selected
            updateRecycler()
        }
    }

    private fun updateCategoryButtonsBackgrouds() {
        latest_articles_filter_health_button.backgroundDrawable =
            if (ArticleCategories.HEALTH.selected) ContextCompat.getDrawable(
                activity!!,
                R.drawable.dw_articles_filter_button_selected_rounded
            )
            else ContextCompat.getDrawable(
                activity!!,
                R.drawable.dw_articles_filter_button_rounded
            )
        latest_articles_filter_training_button.backgroundDrawable =
            if (ArticleCategories.TRAINING.selected) ContextCompat.getDrawable(
                activity!!,
                R.drawable.dw_articles_filter_button_selected_rounded
            )
            else ContextCompat.getDrawable(
                activity!!,
                R.drawable.dw_articles_filter_button_rounded
            )
        latest_articles_filter_care_button.backgroundDrawable =
            if (ArticleCategories.CARE.selected) ContextCompat.getDrawable(
                activity!!,
                R.drawable.dw_articles_filter_button_selected_rounded
            )
            else ContextCompat.getDrawable(
                activity!!,
                R.drawable.dw_articles_filter_button_rounded
            )
        latest_articles_filter_breeds_button.backgroundDrawable =
            if (ArticleCategories.BREEDS.selected) ContextCompat.getDrawable(
                activity!!,
                R.drawable.dw_articles_filter_button_selected_rounded
            )
            else ContextCompat.getDrawable(
                activity!!,
                R.drawable.dw_articles_filter_button_rounded
            )
        latest_articles_filter_food_button.backgroundDrawable =
            if (ArticleCategories.FOOD.selected) ContextCompat.getDrawable(
                activity!!,
                R.drawable.dw_articles_filter_button_selected_rounded
            )
            else ContextCompat.getDrawable(
                activity!!,
                R.drawable.dw_articles_filter_button_rounded
            )
    }

    private fun buildArticles(): List<Article> {
        val result = mutableListOf<Article>()
        if (!ArticleCategories.HEALTH.selected &&
            !ArticleCategories.TRAINING.selected &&
            !ArticleCategories.CARE.selected &&
            !ArticleCategories.BREEDS.selected &&
            !ArticleCategories.FOOD.selected
        ) {
            result.addAll(articles ?: mutableListOf())
        } else {
            if (ArticleCategories.HEALTH.selected) {
                result.addAll(articles?.filter { it.category == ArticleCategories.HEALTH.string }
                    ?: mutableListOf())
            }
            if (ArticleCategories.TRAINING.selected) {
                result.addAll(articles?.filter { it.category == ArticleCategories.TRAINING.string }
                    ?: mutableListOf())
            }
            if (ArticleCategories.CARE.selected) {
                result.addAll(articles?.filter { it.category == ArticleCategories.CARE.string }
                    ?: mutableListOf())
            }
            if (ArticleCategories.BREEDS.selected) {
                result.addAll(articles?.filter { it.category == ArticleCategories.BREEDS.string }
                    ?: mutableListOf())
            }
            if (ArticleCategories.FOOD.selected) {
                result.addAll(articles?.filter { it.category == ArticleCategories.FOOD.string }
                    ?: mutableListOf())
            }
        }
        return result
    }

}
