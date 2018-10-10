/*
 * GetApi.kt on NewsAppwithMVP
 * Developed by Muhammad Utsman on 10/10/18 12:33 PM
 * Last modified 10/10/18 12:31 PM
 * Copyright (c) 2018 kucingapes
 */

package com.kucingapes.newsappwithmvp.presenter

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.kucingapes.newsappwithmvp.BuildConfig
import com.kucingapes.newsappwithmvp.view.MainContract
import com.kucingapes.newsappwithmvp.model.Articles

class GetApi(private val sites: String) : MainContract.GetDataNews {

    override fun getNewsList(onSuccessListener: MainContract.GetDataNews.OnSuccessListener) {
        AndroidNetworking.get(BuildConfig.BaseUrl)
                .addHeaders("X-Api-Key", BuildConfig.apiKey)
                .addQueryParameter("domains", sites)
                .addQueryParameter("pageSize", "100")
                .setTag(this)
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsObject(Articles::class.java, object : ParsedRequestListener<Articles> {
                    override fun onResponse(response: Articles?) {
                        onSuccessListener.onFinished(response!!.articles)
                    }

                    override fun onError(anError: ANError?) {
                        onSuccessListener.onFailed(anError!!)
                    }

                })
    }
}