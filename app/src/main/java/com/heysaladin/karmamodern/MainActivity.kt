package com.heysaladin.karmamodern

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        //supportActionBar?.setDisplayShowTitleEnabled(false)

        val toolbar = this.findViewById(R.id.toolbar) as Toolbar?
//        setSupportActionBar(toolbar)
//        toolbar?.title = "Androidly"
//        toolbar?.subtitle = "Sub"
//        toolbar?.navigationIcon = ContextCompat.getDrawable(this,R.drawable.logo_karma_group)
//        toolbar?.setNavigationOnClickListener { Toast.makeText(applicationContext,"Navigation icon was clicked",
//            Toast.LENGTH_SHORT).show() }

        setSupportActionBar(toolbar)
//
//        setContentView(R.layout.activity_main)

//        ActionBarTitleGravity();





    }


    @SuppressLint("WrongConstant")
    private fun ActionBarTitleGravity() {
        // TODO Auto-generated method stub

        val actionbar = actionBar

        val textview = TextView(applicationContext)

        val layoutparams =
            RelativeLayout.LayoutParams(android.app.ActionBar.LayoutParams.MATCH_PARENT, android.app.ActionBar.LayoutParams.WRAP_CONTENT)

        textview.setLayoutParams(layoutparams)

        textview.setText("ACTIONBAR")

        textview.setTextColor(Color.BLACK)

        textview.setGravity(Gravity.CENTER)

        textview.setTextSize(20F)

        actionbar?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM)

        actionbar?.setCustomView(textview)

    }


}
