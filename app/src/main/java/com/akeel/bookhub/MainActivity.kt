package com.akeel.bookhub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Find the navigation view
        val navigationView = findViewById<NavigationView>(R.id.navigation_drawer)

        // Set the navigation item selected listener
        navigationView.setNavigationItemSelectedListener { menuItem ->
            // Handle navigation view item clicks here
            when (menuItem.itemId) {
                R.id.dashboard -> {

                        showToast("Clicked on dashboard btn")

                }
                R.id.favourite -> {
                    showToast("Clicked on favourite btn")
                }
                R.id.profile -> {
                    showToast("Clicked on profile btn")
                }
                R.id.about_app -> {
                    showToast("Clicked on about app btn")
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

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}
