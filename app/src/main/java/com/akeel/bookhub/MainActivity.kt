package com.akeel.bookhub

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout

    @SuppressLint("ResourceType", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        openDashBoard()




        // Find the navigation view
        val navigationView = findViewById<NavigationView>(R.id.navigation_drawer)

        // Set the navigation item selected listener
        navigationView.setNavigationItemSelectedListener { menuItem ->
            // Handle navigation view item clicks here
            when (menuItem.itemId) {
                R.id.dashboard -> {


                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame,DashboardFragment())
                        .addToBackStack("Dashboard")
                        .commit()
                    supportActionBar?.title="Dashboard"
                }
                R.id.favourite -> {

                    supportFragmentManager.beginTransaction().replace(R.id.frame,FavouriteFragment())
                        .addToBackStack("Favourites")
                        .commit()
                    supportActionBar?.title="Favourites"
                }
                R.id.profile ->{
                    supportFragmentManager.beginTransaction().replace(R.id.frame,ProfileFragment())
                        .addToBackStack("Profile")
                        .commit()
                    supportActionBar?.title="Profile"


                }
                R.id.about_app -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frame,AboutAppFragment())
                        .addToBackStack("About App")
                        .commit()
                    supportActionBar?.title="About App"
                }
            }
            // Close the drawer after handling the click
            drawerLayout.closeDrawer(GravityCompat.START)
            true

        }

        // Find the drawer layout
        drawerLayout = findViewById(R.id.drawer_layout)


        // Find the image button
       val imageButton = findViewById<ImageButton>(R.id.button_driver)

        // Set click listener to open drawer
        imageButton.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }
    }

    private fun openDashBoard(){
        val fragment = DashboardFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame,fragment)
        transaction.commit()
    }


}
