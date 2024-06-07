package com.uti.coralconnect

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.uti.coralconnect.R.id.main
import com.uti.coralconnect.databinding.ActivityOnBoardingAppBinding
import com.uti.coralconnect.fragment.LoginFragment

class onBoardingApp : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityOnBoardingAppBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_on_boarding_app)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN or WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)

        val btnMoveGetStartlogin : Button = findViewById(R.id.btn_start)
        btnMoveGetStartlogin.setOnClickListener(this)

    }
    override fun onClick(v: View?) {
        when (v?.id){
            R.id.btn_start -> {
                replaceFragment(LoginFragment.newInstance("param1", "param2"))
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.onboardingcontainer, fragment).addToBackStack(null).commit()
    }
}