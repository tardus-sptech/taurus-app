package com.taurus.apptaurus

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.taurus.apptaurus.external.NewsService
import com.taurus.apptaurus.util.NewsAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class NewsFragment : Fragment() {

    private lateinit var newsAdapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_news, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        newsAdapter = NewsAdapter(emptyList())
        recyclerView.adapter = newsAdapter
        fetchData()
        return view
    }

    private fun fetchData(){
        val retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val newsService = retrofit.create(NewsService::class.java)

        GlobalScope.launch(Dispatchers.Main){
            try{
                val newsList = newsService.getNews()
                newsAdapter.setData(newsList)
            }catch (e: Exception){
                Toast.makeText(requireContext(), "Error fetching news", Toast.LENGTH_SHORT).show()
            }
        }
    }

}