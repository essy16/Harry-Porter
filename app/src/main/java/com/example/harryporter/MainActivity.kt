package com.example.harryporter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.harryporter.ui.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_place, HomeFragment())
                .commit()
//        val navHostFragment =
//            supportFragmentManager.findFragmentById(R.id.nav_graph) as NavHostFragment
//        val navController = navHostFragment.navController

    }
}