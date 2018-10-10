/*
 * News.kt on NewsAppwithMVP
 * Developed by Muhammad Utsman on 10/10/18 12:22 PM
 * Last modified 10/10/18 10:19 AM
 * Copyright (c) 2018 kucingapes
 */

package com.kucingapes.newsappwithmvp.model

class News(var source: Source,
           var author: String,
           var title: String,
           var description: String,
           var url: String,
           var urlToImage: String,
           var publishedAt: String)