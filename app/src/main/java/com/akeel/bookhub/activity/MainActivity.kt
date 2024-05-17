package com.akeel.bookhub.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.akeel.bookhub.fragment.AboutAppFragment
import com.akeel.bookhub.fragment.DashboardFragment
import com.akeel.bookhub.fragment.FavouriteFragment
import com.akeel.bookhub.fragment.ProfileFragment
import com.akeel.bookhub.R
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        openDashBoard()

        val toolbar = findViewById<Toolbar>(R.id.toolbar)

        toolbar.setNavigationOnClickListener {
            // Handle navigation icon click here
            // For example, open/close the drawer
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                drawerLayout.openDrawer(GravityCompat.START)
            }
        }


        // Find the navigation view
        val navigationView = findViewById<NavigationView>(R.id.navigation_drawer)

        // Set the navigation item selected listener
        navigationView.setNavigationItemSelectedListener { menuItem ->
            // Handle navigation view item clicks here
            when (menuItem.itemId) {
                R.id.dashboard -> {


                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, DashboardFragment())
                        .commit()
                    supportActionBar?.title = "Dashboard"
                }

                R.id.favourite -> {

                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, FavouriteFragment())
                        .addToBackStack("Favourites")
                        .commit()
                    supportActionBar?.title = "Favourites"
                }

                R.id.profile -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frame, ProfileFragment())
                        .addToBackStack("Profile")
                        .commit()
                    supportActionBar?.title = "Profile"

                }

                R.id.about_app -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, AboutAppFragment())
                        .addToBackStack("About App")
                        .commit()
                    supportActionBar?.title = "About App"
                }
            }
            // Close the drawer after handling the click
            drawerLayout.closeDrawer(GravityCompat.START)
            true

        }

        // Find the drawer layout
        drawerLayout = findViewById(R.id.drawer_layout)

    }

    private fun openDashBoard() {
        val fragment = DashboardFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame, fragment)
        transaction.commit()
    }


}
