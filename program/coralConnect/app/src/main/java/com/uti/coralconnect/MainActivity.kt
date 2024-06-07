package com.uti.coralconnect

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.uti.coralconnect.databinding.ActivityMainBinding
import com.uti.coralconnect.fragment.EventFragment
import com.uti.coralconnect.fragment.HomeFragment
import com.uti.coralconnect.fragment.LoginFragment
import com.uti.coralconnect.fragment.NotificationFragment
import com.uti.coralconnect.fragment.ProfileFragment

class MainActivity : AppCompatActivity(){

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN or WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)
        replaceFragment(HomeFragment())


        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.navigation_home -> replaceFragment(HomeFragment())
                R.id.navigation_event -> replaceFragment(EventFragment())
                R.id.navigation_notif -> replaceFragment(NotificationFragment())
                R.id.navigation_profile -> replaceFragment(ProfileFragment())
            }
            true
        }

    }

     private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment).addToBackStack(null).commit()
    }

}