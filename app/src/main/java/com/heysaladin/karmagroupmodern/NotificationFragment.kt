package com.heysaladin.karmagroupmodern


import android.os.Bundle
import androidx.fragment.app.Fragment
//import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*

/**
 * A simple [Fragment] subclass.
 */
@Suppress("UNREACHABLE_CODE")
class NotificationFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        activity!!.active_fragment_logo.visibility = View.GONE
        activity!!.active_fragment_title.visibility = View.VISIBLE
        activity!!.active_fragment_title.setText("Notif Aja")
//        activity!!.
//        changeTitle(false, "")

//        TITLE_VIEW = "Info kece"

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notification, container, false)
    }
}
