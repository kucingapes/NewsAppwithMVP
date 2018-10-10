/*
 * NewsAdapter.kt on NewsAppwithMVP
 * Developed by Muhammad Utsman on 10/10/18 12:34 PM
 * Last modified 10/10/18 12:31 PM
 * Copyright (c) 2018 kucingapes
 */

package com.kucingapes.newsappwithmvp.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kucingapes.newsappwithmvp.R
import com.kucingapes.newsappwithmvp.view.RecyclerItemClick
import com.kucingapes.newsappwithmvp.model.News
import kotlinx.android.synthetic.main.item_row.view.*
import java.text.SimpleDateFormat
import java.util.*

class NewsAdapter(val context: Context,
                  val newsData: ArrayList<News>,
                  val itemClick: RecyclerItemClick) : RecyclerView.Adapter<NewsAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return newsData.size
    }

    @SuppressLint("SimpleDateFormat")
    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.setIsRecyclable(false)

        val news = newsData[position]
        val titleNews = holder.itemView.title_news
        val authorNews = holder.itemView.author_news
        val sourceNews = holder.itemView.source_news
        val descNews = holder.itemView.desc_news
        val dateNews = holder.itemView.date_news
        val imageNews = holder.itemView.image_news

        titleNews.text = news.title
        authorNews.text = news.author
        sourceNews.text = news.source.name
        descNews.text = news.description

        val parseDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
        val dateFormat = SimpleDateFormat("EEE dd MMM yyyy / HH:mm", Locale("id"))
        val date = parseDateFormat.parse(news.publishedAt)

        dateNews.text = dateFormat.format(date)

        if (authorNews.text == "") {
            authorNews.visibility = View.GONE
        }

        Glide.with(context).load(news.urlToImage).into(imageNews)
        //imageLoader(news.urlToImage, imageNews)

        holder.itemView.setOnClickListener {
            itemClick.onItemClick(news)
        }
    }

    /*private fun imageLoader(url: String, imgView: ImageView) {
        AndroidNetworking.get(url)
                .setPriority(Priority.HIGH)
                .setTag("imageloader")
                .setBitmapConfig(Bitmap.Config.ARGB_8888)
                .build()
                .getAsBitmap(object : BitmapRequestListener {
                    override fun onResponse(response: Bitmap?) {
                        imgView.setImageBitmap(response)
                    }

                    override fun onError(anError: ANError?) {
                        Log.d("bitmapError", anError!!.message)
                    }

                })
    }*/

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView)
}