package com.heysaladin.karmagroupmodern


import android.os.Bundle
//import android.support.v4.app.Fragment
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*

/**
 * A simple [Fragment] subclass.
 */
class BottomNavFragmentTwo : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        activity!!.active_fragment_logo.visibility = View.GONE
        activity!!.active_fragment_title.visibility = View.VISIBLE
        activity!!.active_fragment_title.setText("Booking")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bottom_nav_fragment_two, container, false)
    }
}
