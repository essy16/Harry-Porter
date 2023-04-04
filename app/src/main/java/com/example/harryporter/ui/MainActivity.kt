package com.example.harryporter.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.harryporter.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fr=supportFragmentManager.beginTransaction()
        fr.replace(R.id.fragment_place,HomeFragment())
        fr.commit()
    }
}