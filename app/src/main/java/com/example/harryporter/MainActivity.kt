package com.example.harryporter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.harryporter.ui.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fr=supportFragmentManager.beginTransaction()
        fr.replace(R.id.fragment_place, HomeFragment())
        fr.commit()
    }
}