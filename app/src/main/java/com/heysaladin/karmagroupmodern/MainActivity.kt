package com.heysaladin.karmagroupmodern

import android.os.Bundle
//import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = findNavController(R.id.mainNavFragment)
        val toolbar = this.findViewById(R.id.toolbar) as Toolbar?

        // Set up ActionBar
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)

//        active_fragment_logo.visibility = View.VISIBLE
//        active_fragment_title.visibility = View.GONE

//        changeTitle(false, "")

//        if(TITLE_VIEW == "") {
//            active_fragment_logo.visibility = View.VISIBLE
//            active_fragment_title.visibility = View.GONE
//        } else {
//            active_fragment_logo.visibility = View.GONE
//            active_fragment_title.visibility = View.VISIBLE
//            active_fragment_title.text = TITLE_VIEW
//        }

        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)

//        // setting title according to fragment
//        navController.addOnDestinationChangedListener {
//            controller, destination, arguments ->
//            toolbar.title = navController.currentDestination?.label
//        }
        val navigationView: NavigationView =  this.findViewById(R.id.navigationView)
        // Set up navigation menu
        navigationView.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {

//        active_fragment_logo.visibility = View.VISIBLE
//        active_fragment_title.visibility = View.GONE

//        changeTitle(false, "")

        return NavigationUI.navigateUp(
                Navigation.findNavController(this, R.id.mainNavFragment), drawerLayout)
    }

    /*
        *** reference source developer.android.com ***

        boolean onCreateOptionsMenu (Menu menu)
            Initialize the contents of the Activity's standard options menu.
            You should place your menu items in to menu.

            This is only called once, the first time the options menu is displayed

        Parameters
            menu Menu : The options menu in which you place your items.
        Returns
            boolean : You must return true for the menu to be displayed;
                      if you return false it will not be shown.


        MenuInflater
            This class is used to instantiate menu XML files into Menu objects.
            For performance reasons, menu inflation relies heavily on pre-processing of XML files
            that is done at build time.

        void inflate (int menuRes, Menu menu)
            Inflate a menu hierarchy from the specified XML resource.
            Throws InflateException if there is an error.

        Parameters
            menuRes int : Resource ID for an XML layout resource to load (e.g., R.menu.main_activity)
            menu Menu : The Menu to inflate into. The items and submenus will be added to this Menu.
    */
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu to use in the action bar
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_option, menu)
                val menuItem = menu.findItem(R.id.notificationFragment)
        menuItem.icon = Converter.convertLayoutToImage(this@MainActivity, 1, R.drawable.ic_notifications_black_24dp)
        return super.onCreateOptionsMenu(menu)
    }

    /*
        *** reference source developer.android.com ***

        boolean onOptionsItemSelected (MenuItem item)
            This hook is called whenever an item in your options menu is selected. The default
            implementation simply returns false to have the normal processing happen (calling the
            item's Runnable or sending a message to its Handler as appropriate). You can use this
            method for any items for which you would like to do processing
            without those other facilities.

            Derived classes should call through to the base class for it to
            perform the default menu handling.

        Parameters
            item MenuItem : The menu item that was selected.
        Returns
            boolean : boolean Return false to allow normal menu processing to proceed,
                      true to consume it here.
    */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle presses on the action bar menu items
        when (item.itemId) {
            R.id.notificationFragment -> {
                //Toast.makeText(this, "you press BELL", Toast.LENGTH_SHORT).show()
                val navController = findNavController(R.id.mainNavFragment)
                navController.navigate(R.id.notificationFragment)
//                active_fragment_logo.visibility = View.GONE
//                active_fragment_title.visibility = View.VISIBLE
//                active_fragment_title.setText("Notif")
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

//    private fun changeTitle(isText: Boolean, title: String) {
//        if(isText) {
//            active_fragment_logo.visibility = View.GONE
//            active_fragment_title.visibility = View.VISIBLE
//            active_fragment_title.text = title
//        } else {
//            active_fragment_logo.visibility = View.VISIBLE
//            active_fragment_title.visibility = View.GONE
//        }
//    }

}
