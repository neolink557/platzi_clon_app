package com.example.platziappclon.ui

import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.platziappclon.R
import com.example.platziappclon.databinding.ActivityMainBinding
import com.example.platziappclon.ui.home.HomeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(),ActivityController {

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


    private fun setActionBarTittle(tittle:String) {
        getActionBarToolbar()
        binding.actionBar.title = tittle
        setSupportActionBar(binding.actionBar)
    }

    private fun getActionBarToolbar(): Toolbar {
        val mActionBarToolbar:Toolbar = binding.actionBar
        setSupportActionBar(mActionBarToolbar)
        return mActionBarToolbar
    }

    private fun disable(boolean: Boolean){
        binding.container.disabled = boolean
    }

    override fun turnToGrayscale(boolean: Boolean){
       disable(boolean)
    }

    override fun setActionBarName(string: String) {
        setActionBarTittle(string)
    }

    override fun showLoading(isLoading: Boolean) {
        if (isLoading){
            binding.progressBar.visibility = View.VISIBLE
        }else{
            binding.progressBar.visibility = View.GONE
        }

    }

}