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
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView




class MainActivity : AppCompatActivity() {


    private val mDrawerLayout: DrawerLayout? = null
    private val mNavigationView: NavigationView? = null


    private fun hidedrawermenu() {
        val menu = mNavigationView?.getMenu()
        menu?.findItem(R.id.nav_home)!!.isVisible = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)



        //supportActionBar?.setDisplayShowTitleEnabled(false)

        val mDrawerLayout  = this.findViewById(R.id.drawerLayout) as Toolbar?
        val mNavigationView  = this.findViewById(R.id.shitstuff) as Toolbar?
        val toolbar = this.findViewById(R.id.toolbar) as Toolbar?
//        setSupportActionBar(toolbar)
//        toolbar?.title = "Androidly"
//        toolbar?.subtitle = "Sub"
//        toolbar?.navigationIcon = ContextCompat.getDrawable(this,R.drawable.logo_karma_group)
//        toolbar?.setNavigationOnClickListener { Toast.makeText(applicationContext,"Navigation icon was clicked",
//            Toast.LENGTH_SHORT).show() }

        setSupportActionBar(toolbar)
//
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//
////        setContentView(R.layout.activity_main)
//
////        ActionBarTitleGravity();
//

//        val mDrawerToggle = ActionBarDrawerToggle(
//            this,
//            mDrawerLayout,
//            toolbar,
//           R.string.app_name,
//            R.string.app_name
//        )
//
//        mDrawerLayout.addDrawerListener(mDrawerToggle)

//        mDrawerToggle.syncState()
//        hidedrawermenu()

//
//
//        drawerToggle = object : ActionBarDrawerToggle(
//            this,
//            drawerLayout,
//            toolbar,
//            R.string.drawer_open,
//            R.string.drawer_close
//        ) {
//            override fun onDrawerClosed(view: View) {
//                super.onDrawerClosed(view)
//                setTitle(R.string.app_name)
//            }
//
//            override fun onDrawerOpened(drawerView: View) {
//                super.onDrawerOpened(drawerView)
//                setTitle("OPTION")
//            }
//        }
//
//        drawerToggle.isDrawerIndicatorEnabled = true
//        drawerLayout.addDrawerListener(drawerToggle)
//        drawerToggle.syncState()





    }

//    override fun onNavigationItemSelected(item: MenuItem): Boolean {
//// Handle navigation view item clicks here.
//        when (item.itemId) {
////            R.id.nav_camera-> {
////// Handle the camera action
////            }
//            R.id.nav_gallery-> {
//
//            }
//            R.id.nav_slideshow-> {
//
//            }
////            R.id.nav_manage-> {
////
////            }
//            R.id.nav_share-> {
//
//            }
//            R.id.nav_send-> {
//
//            }
//        }
//
//        drawer_layout.closeDrawer(GravityCompat.START)
//        return true
//    }


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
