package com.heysaladin.karmagroupmodern


import android.os.Bundle
//import android.support.v4.app.Fragment
//import androidx.appcompat.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
//import androidx.fragment.app.Fragment
//import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
//import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_bottom_nav.*

//import kotlinx.android.synthetic.main.fragment_bottom_nav.*

/**
 * A simple [Fragment] subclass.
 */
class BottomNavFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
//        activity!!.active_fragment_logo.visibility = View.VISIBLE
//        activity!!.active_fragment_title.visibility = View.GONE
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bottom_nav, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = Navigation.findNavController(requireActivity(), R.id.bottomNavFragment)
        bottomNavigation.setupWithNavController(navController)
    }
}
