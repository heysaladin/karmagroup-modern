package com.heysaladin.karmamodern.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.heysaladin.karmamodern.R

class HomeFragment : Fragment(), View.OnClickListener {

    internal lateinit var view: View
    internal lateinit var technology_panel: CardView
    internal lateinit var business_panel: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.view = inflater.inflate(R.layout.category_fragment, container, false)
        initComponent()
        return view
    }

    fun initComponent() {
        technology_panel = this.view.findViewById(R.id.categ_technology)
        business_panel = this.view.findViewById(R.id.categ_business)
        technology_panel.setOnClickListener(this)
        business_panel.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.categ_technology -> {
                val categoryTech = Bundle()
                categoryTech.putString("category", "technology")
                Navigation.findNavController(v).navigate(R.id.action_homeFragment_to_listNewsFragment, categoryTech)
            }
            R.id.categ_business -> {
                val categoryBusiness = Bundle()
                categoryBusiness.putString("category", "business")
                Navigation.findNavController(v).navigate(R.id.action_homeFragment_to_listNewsFragment, categoryBusiness)
            }
        }
    }
}
