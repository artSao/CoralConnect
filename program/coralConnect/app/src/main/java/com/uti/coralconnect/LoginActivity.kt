package com.uti.coralconnect

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.uti.coralconnect.database.DatabaseHelper
import com.uti.coralconnect.databinding.ActivityLoginBinding
import com.uti.coralconnect.databinding.ActivityOnBoardingAppBinding
import com.uti.coralconnect.databinding.ActivityRegisterBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var databaseHelper: DatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        databaseHelper = DatabaseHelper(this)

        binding.buttonLogin.setOnClickListener {
//            val usernameBinding = binding.usernameLogin.text.toString()
//            val passwordBinding = binding.passwordLogin.text.toString()
//            loginToMain(usernameBinding,passwordBinding)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.loginWithUsername.setOnClickListener{
            val intent = Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }
    }
    private fun loginToMain(username: String, password: String){
        val userExist = databaseHelper.readUser(username,password)
        if (userExist){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }else{
            Log.d(null,"Failed login")
        }
    }

}