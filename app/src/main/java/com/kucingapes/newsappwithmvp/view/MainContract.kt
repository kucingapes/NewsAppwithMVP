/*
 * MainContract.kt on NewsAppwithMVP
 * Developed by Muhammad Utsman on 10/10/18 12:31 PM
 * Last modified 10/10/18 12:23 PM
 * Copyright (c) 2018 kucingapes
 */

package com.kucingapes.newsappwithmvp.view

import com.androidnetworking.error.ANError
import com.kucingapes.newsappwithmvp.model.News

interface MainContract {
    interface Presenter {
        fun requestData()
    }

    interface MainView {
        fun showProgress()
        fun hideProgress()
        fun setDataToList(newsList: ArrayList<News>)
        fun onFailedResponse(anError: ANError)
    }

    interface GetDataNews {
        interface OnSuccessListener {
            fun onFinished(newsList: ArrayList<News>)
            fun onFailed(anError: ANError)
        }

        fun getNewsList(onSuccessListener: OnSuccessListener)
    }
}