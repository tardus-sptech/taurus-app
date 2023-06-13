package com.taurus.apptaurus.response

import com.taurus.apptaurus.request.News

data class NewsResponse(
    val articles: List<News>
)
