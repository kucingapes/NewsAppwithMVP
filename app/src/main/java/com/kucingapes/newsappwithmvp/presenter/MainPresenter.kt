/*
 * MainPresenter.kt on NewsAppwithMVP
 * Developed by Muhammad Utsman on 10/10/18 12:31 PM
 * Last modified 10/10/18 12:31 PM
 * Copyright (c) 2018 kucingapes
 */

package com.kucingapes.newsappwithmvp.presenter

import com.androidnetworking.error.ANError
import com.kucingapes.newsappwithmvp.view.MainContract
import com.kucingapes.newsappwithmvp.model.News

class MainPresenter(private var mainView: MainContract.MainView,
                    private var getDataNews: MainContract.GetDataNews): MainContract.Presenter, MainContract.GetDataNews.OnSuccessListener {

    override fun requestData() {
        getDataNews.getNewsList(this)
    }

    override fun onFinished(newsList: ArrayList<News>) {
        mainView.setDataToList(newsList)
        mainView.hideProgress()
    }

    override fun onFailed(anError: ANError) {
        mainView.onFailedResponse(anError)
        mainView.hideProgress()
    }
}