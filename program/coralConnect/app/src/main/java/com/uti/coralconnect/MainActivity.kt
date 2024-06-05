package com.uti.coralconnect

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.uti.coralconnect.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){

    private lateinit var binding : ActivityMainBinding
//    private lateinit var btnAll : Button
//    private lateinit var btnFamous : Button
//    private lateinit var btnNewest : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN or WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)
        replaceFragment(HomeFragment())

//        // menginisialisasi tombol kategori
//        btnAll = findViewById(R.id.category_btn_all)
//        btnFamous = findViewById(R.id.category_btn_famous)
//        btnNewest = findViewById(R.id.category_btn_newest)
//
//        // menambahkan aksi ketika diclick
//
//        // ketika all categori diklik
//        btnAll.setOnClickListener(){
//            // panggil display dengan category all
//            displayCategory
//        }

//        val likeCountTextView : TextView = findViewById()


        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.navigation_home -> replaceFragment(HomeFragment())
                R.id.navigation_event -> replaceFragment(EventFragment())
                R.id.navigation_camera -> replaceFragment(CameraFragment())
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