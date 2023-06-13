package com.taurus.apptaurus

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.taurus.apptaurus.external.NewsService
import com.taurus.apptaurus.response.NewsResponse
import com.taurus.apptaurus.util.NewsAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var newsAdapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerView)
        newsAdapter = NewsAdapter()

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = newsAdapter

        fetchData()
    }

    private fun fetchData() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val newsService = retrofit.create(NewsService::class.java)

        newsService.getNews("pt", "6973c530c90647c8ac7221d9b3bcdfe6", "business")
            .enqueue(object : Callback<NewsResponse> {
                override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                    if (response.isSuccessful) {
                        val newsList = response.body()?.articles
                        if (newsList != null) {
                            newsAdapter.setData(newsList)
                        } else {
                            Toast.makeText(requireContext(), "No news articles available", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        Toast.makeText(requireContext(), "Failed to fetch news", Toast.LENGTH_SHORT).show()
                        Log.e("NewsFragment", "API Error: ${response.code()}")
                    }
                }

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    Toast.makeText(requireContext(), "Error fetching news", Toast.LENGTH_SHORT).show()
                    Log.e("NewsFragment", "API Exception: ${t.message}", t)
                }
            })
    }
}
