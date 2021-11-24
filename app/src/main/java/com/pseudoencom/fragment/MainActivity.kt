package com.pseudoencom.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
   lateinit var sharedViewModel:SharedViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sharedViewModel = ViewModelProvider(this).get(SharedViewModel::class.java)
        sharedViewModel.getTitle().observe(this, Observer{
            supportActionBar?.title=it

        })
        val home = MainFragment()
        val code = CodeFragment()
        val info = InfoFragment()

        makeCurrentFragment(home)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.home -> makeCurrentFragment(home)
                R.id.code -> makeCurrentFragment(code)
                R.id.info -> makeCurrentFragment(info)
            }
            true
        }

    }

    private fun makeCurrentFragment( fragment: Fragment){
        supportFragmentManager.beginTransaction().apply{
            replace(R.id.frameL, fragment)
            commit()
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            super.onBackPressed()
        }

        return super.onOptionsItemSelected(item)
    }

}