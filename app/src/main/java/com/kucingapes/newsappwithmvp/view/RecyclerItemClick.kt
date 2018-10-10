/*
 * RecyclerItemClick.kt on NewsAppwithMVP
 * Developed by Muhammad Utsman on 10/10/18 12:33 PM
 * Last modified 10/10/18 12:31 PM
 * Copyright (c) 2018 kucingapes
 */

package com.kucingapes.newsappwithmvp.view

import com.kucingapes.newsappwithmvp.model.News

interface RecyclerItemClick {
    fun onItemClick(news: News)
}