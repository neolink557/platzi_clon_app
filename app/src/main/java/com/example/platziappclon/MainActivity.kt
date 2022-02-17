package com.example.platziappclon

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.platziappclon.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getActionBarToolbar()

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_study, R.id.navigation_explore, R.id.navigation_downloads
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    fun setActionBarTittle(tittle:String) {
        binding.actionBar.title = tittle
        setSupportActionBar(binding.actionBar)
    }

    protected fun getActionBarToolbar(): Toolbar? {
        val mActionBarToolbar:Toolbar = binding.actionBar
        if (mActionBarToolbar != null) {
            setSupportActionBar(mActionBarToolbar)
        }
        return mActionBarToolbar
    }

}