package com.uti.coralconnect

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.uti.coralconnect.database.DatabaseHelper
import com.uti.coralconnect.databinding.ActivityLoginBinding
import com.uti.coralconnect.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        databaseHelper = DatabaseHelper(this)


        binding.butonContinueRegister.setOnClickListener {

            val valueInputUser = binding.username.text.toString()
            val valuePassword = binding.password.text.toString()

            registerMove(valueInputUser,valuePassword)
        }

    }

    private fun registerMove(username: String, password: String){
        val inputData = databaseHelper.insertUser(username,password)

        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}