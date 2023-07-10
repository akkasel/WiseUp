package com.akka.wiseup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setupWithNavController(navController)

        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_home -> {
                    // Handle home item click
                    navController.navigate(R.id.destination_home)
                    true
                }
                R.id.menu_search -> {
                    // Handle search item click
                    navController.navigate(R.id.destination_search)
                    true
                }
                R.id.menu_saved -> {
                    // Handle saved item click
                    navController.navigate(R.id.destination_saved)
                    true
                }
                R.id.menu_profile -> {
                    // Handle profile item click
                    navController.navigate(R.id.destination_profile)
                    true
                }
                else -> false
            }
        }


    }

    override fun onBackPressed() {
        // Get the current destination fragment
        val navController = findNavController(R.id.nav_host_fragment)
        val currentDestination = navController.currentDestination?.id

        // Check if the current destination is Home, Search, Saved, or Profile
        if (currentDestination == R.id.destination_home||
            currentDestination == R.id.destination_search ||
            currentDestination == R.id.destination_saved ||
            currentDestination == R.id.destination_profile) {
            // If yes, quit the app
            finish()
        } else {
            // If not, navigate back using the default behavior
            super.onBackPressed()
        }
    }

}