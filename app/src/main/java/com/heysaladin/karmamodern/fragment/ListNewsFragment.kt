package com.heysaladin.karmamodern.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.heysaladin.karmamodern.R
import com.heysaladin.karmamodern.adapter.NewsAdapter
import com.heysaladin.karmamodern.repository.NewsRepository
import com.heysaladin.karmamodern.viewmodel.NewsModel
import java.util.*

class ListNewsFragment : Fragment() {

    internal lateinit var view: View
    internal var category: String? = "technology"
    internal lateinit var viewModel: NewsModel
    internal lateinit var rc_list: RecyclerView
    internal lateinit var adapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.view = inflater.inflate(R.layout.list_news_fragment, container, false)
        this.getPassedData()
        this.initComponent()
        this.initList()
        return view
    }

    fun getPassedData() {
        val bundle = this.arguments
        try {
            category = bundle!!.getString("category")
        } catch (ex: NullPointerException) {

        }

    }

    fun initComponent() {
        rc_list = view.findViewById(R.id.rc_list)
        // Assign View Model from News View Model
        viewModel = ViewModelProviders.of(this).get(NewsModel::class.java)
        viewModel.init(NewsRepository())
        //instantiate news adapter
        adapter = NewsAdapter(context, ArrayList())
        val layoutManager = LinearLayoutManager(
            context, RecyclerView.HORIZONTAL,
            false
        )
        rc_list.layoutManager = layoutManager
        val snapHelper = PagerSnapHelper() // Or PagerSnapHelper
        snapHelper.attachToRecyclerView(rc_list)
        rc_list.adapter = adapter
    }

    fun initList() {
        // put observer when news data is downloaded
        this.category?.let {
            viewModel.getNewsByCategory(it).observe(this, Observer { news ->
                adapter.setData(news)
                adapter.notifyDataSetChanged()
            })
        }
    }
}
