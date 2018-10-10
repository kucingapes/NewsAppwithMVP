/*
 * MainActivity.kt on NewsAppwithMVP
 * Developed by Muhammad Utsman on 10/10/18 12:31 PM
 * Last modified 10/10/18 12:27 PM
 * Copyright (c) 2018 kucingapes
 */

package com.kucingapes.newsappwithmvp.view

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.LinearLayoutManager
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.kucingapes.newsappwithmvp.presenter.GetApi
import com.kucingapes.newsappwithmvp.adapter.NewsAdapter
import com.kucingapes.newsappwithmvp.R
import com.kucingapes.newsappwithmvp.decoration.ItemOffsetDecoration
import com.kucingapes.newsappwithmvp.model.News
import com.kucingapes.newsappwithmvp.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.MainView {

    private val sites = "liputan6.com," +
            "kompas.com," +
            "detik.com"

    private lateinit var presenter: MainContract.Presenter
    private val itemClick = object : RecyclerItemClick {
        override fun onItemClick(news: News) {
            val builder = CustomTabsIntent.Builder().apply {
                setToolbarColor(resources.getColor(R.color.colorPrimary))
                setShowTitle(true)
            }
            val customTab = builder.build()
            customTab.launchUrl(this@MainActivity, Uri.parse(news.url))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidNetworking.initialize(this)

        val layoutManager = LinearLayoutManager(this)
        val offsetDecoration = ItemOffsetDecoration(15)
        recycler_list.layoutManager = layoutManager
        recycler_list.addItemDecoration(offsetDecoration)

        presenter = MainPresenter(this, GetApi(sites))
        presenter.requestData()

    }

    override fun showProgress() {
        progress_bar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress_bar.visibility = View.GONE
    }

    override fun setDataToList(newsList: ArrayList<News>) {
        val adapter = NewsAdapter(this, newsList, itemClick)
        recycler_list.adapter = adapter
    }

    override fun onFailedResponse(anError: ANError) {
        Log.d("gagal", anError.message)
        Toast.makeText(this, "Gagal", Toast.LENGTH_SHORT).show()
    }
}
