package com.uti.coralconnect

import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.uti.coralconnect.databinding.ActivityLoginBinding
import com.uti.coralconnect.databinding.ActivityOnBoardingAppBinding

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN or WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)


        val btnMoveGetStartlogin: Button = findViewById(R.id.btn_start)
        btnMoveGetStartlogin.setOnClickListener(this)

    }

    override

}