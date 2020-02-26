package com.app.androidexercise.feeds.ui

import androidx.lifecycle.ViewModel
import com.app.androidexercise.feeds.data.FeedsRepository
import javax.inject.Inject

class FeedsViewModel @Inject constructor(repository: FeedsRepository) : ViewModel() {

    val feedsResult = repository.feeds
}