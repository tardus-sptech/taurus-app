package com.taurus.apptaurus.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.taurus.apptaurus.R
import com.taurus.apptaurus.request.News

class NewsAdapter(private var newsList: List<News>) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = newsList[position]
        holder.bind(news)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    fun setData(data: List<News>) {
        newsList = data
        notifyDataSetChanged()
    }

    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(news: News) {
            itemView.findViewById<TextView>(R.id.title_news).text = news.title
            itemView.findViewById<TextView>(R.id.author_news).text = news.author
            itemView.findViewById<TextView>(R.id.description_news).text = news.description
            itemView.findViewById<TextView>(R.id.published_at_news).text = news.publishedAt
        }
    }
}