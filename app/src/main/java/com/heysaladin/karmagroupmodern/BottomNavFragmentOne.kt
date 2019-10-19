package com.heysaladin.karmagroupmodern

import android.os.Bundle
//import android.support.v4.app.Fragment
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.heysaladin.karmagroupmodern.adapter.BeachAdapter
import com.heysaladin.karmagroupmodern.adapter.DestinationAdapter
import com.heysaladin.karmagroupmodern.adapter.NewsAdapter
import com.heysaladin.karmagroupmodern.adapter.OffersAdapter
import com.heysaladin.karmagroupmodern.repository.BeachRepository
import com.heysaladin.karmagroupmodern.repository.DestinationRepository
import com.heysaladin.karmagroupmodern.repository.NewsRepository
import com.heysaladin.karmagroupmodern.repository.OffersRepository
import com.heysaladin.karmagroupmodern.viewmodel.BeachModel
import com.heysaladin.karmagroupmodern.viewmodel.DestinationModel
import com.heysaladin.karmagroupmodern.viewmodel.NewsModel
import com.heysaladin.karmagroupmodern.viewmodel.OffersModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

/**
 * A simple [Fragment] subclass.
 */
class BottomNavFragmentOne : Fragment() {

    internal lateinit var view: View
    internal var category: String? = "technology"
    internal lateinit var viewModel: DestinationModel
    internal lateinit var rc_list: RecyclerView
    internal lateinit var adapter: DestinationAdapter
    internal lateinit var viewModelNews: NewsModel
    internal lateinit var rc_listNews: RecyclerView
    internal lateinit var adapterNews: NewsAdapter

    internal lateinit var viewModelOffers: OffersModel
    internal lateinit var rc_listOffers: RecyclerView
    internal lateinit var adapterOffers: OffersAdapter

    internal lateinit var viewModelBeach: BeachModel
    internal lateinit var rc_listBeach: RecyclerView
    internal lateinit var adapterBeach: BeachAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
//                              savedInstanceState: Bundle?): View? {
//        activity!!.active_fragment_logo.visibility = View.VISIBLE
//        activity!!.active_fragment_title.visibility = View.GONE
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_bottom_nav_fragment_one, container, false)
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity!!.active_fragment_logo.visibility = View.VISIBLE
        activity!!.active_fragment_title.visibility = View.GONE
        this.view = inflater.inflate(R.layout.fragment_bottom_nav_fragment_one, container, false)
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
        viewModel = ViewModelProviders.of(this).get(DestinationModel::class.java)
        viewModel.init(DestinationRepository())
        //instantiate news adapter
        adapter = DestinationAdapter(context, ArrayList())
        val layoutManager = LinearLayoutManager(
            context, RecyclerView.HORIZONTAL,
            false
        )
        rc_list.layoutManager = layoutManager
        val snapHelper = PagerSnapHelper() // Or PagerSnapHelper
        snapHelper.attachToRecyclerView(rc_list)
        rc_list.adapter = adapter




        rc_listNews = view.findViewById(R.id.rc_list_news)
        // Assign View Model from News View Model
        viewModelNews = ViewModelProviders.of(this).get(NewsModel::class.java)
        viewModelNews.init(NewsRepository())
        //instantiate news adapter
        adapterNews = NewsAdapter(context, ArrayList())
        val layoutManagerNews = LinearLayoutManager(
            context, RecyclerView.HORIZONTAL,
            false
        )
        rc_listNews.layoutManager = layoutManagerNews
//        val snapHelperNews = PagerSnapHelper() // Or PagerSnapHelper
//        snapHelperNews.attachToRecyclerView(rc_listNews)
        rc_listNews.adapter = adapterNews




        rc_listOffers = view.findViewById(R.id.rc_list_offers)
        // Assign View Model from News View Model
        viewModelOffers = ViewModelProviders.of(this).get(OffersModel::class.java)
        viewModelOffers.init(OffersRepository())
        //instantiate news adapter
        adapterOffers = OffersAdapter(context, ArrayList())
        val layoutManagerOffers = LinearLayoutManager(
            context, RecyclerView.HORIZONTAL,
            false
        )
        rc_listOffers.layoutManager = layoutManagerOffers
//        val snapHelperNews = PagerSnapHelper() // Or PagerSnapHelper
//        snapHelperNews.attachToRecyclerView(rc_listNews)
        rc_listOffers.adapter = adapterOffers




        rc_listBeach = view.findViewById(R.id.rc_list_beach)
        // Assign View Model from News View Model
        viewModelBeach = ViewModelProviders.of(this).get(BeachModel::class.java)
        viewModelBeach.init(BeachRepository())
        //instantiate news adapter
        adapterBeach = BeachAdapter(context, ArrayList())
        val layoutManagerBeach = LinearLayoutManager(
            context, RecyclerView.HORIZONTAL,
            false
        )
        rc_listBeach.layoutManager = layoutManagerBeach
//        val snapHelperNews = PagerSnapHelper() // Or PagerSnapHelper
//        snapHelperNews.attachToRecyclerView(rc_listNews)
        rc_listBeach.adapter = adapterBeach


    }

    fun initList() {
        // put observer when news data is downloaded
        this.category?.let {
            viewModel.getDestinationByCategory(it).observe(this, Observer { destination ->
                adapter.setData(destination)
                adapter.notifyDataSetChanged()
            })

            viewModelNews.getNewsByCategory(it).observe(this, Observer { news ->
                adapterNews.setData(news)
                adapterNews.notifyDataSetChanged()
            })

            viewModelOffers.getOffersByCategory(it).observe(this, Observer { news ->
                adapterOffers.setData(news)
                adapterOffers.notifyDataSetChanged()
            })

            viewModelBeach.getBeachByCategory(it).observe(this, Observer { news ->
                adapterBeach.setData(news)
                adapterBeach.notifyDataSetChanged()
            })

        }

    }


}
