package com.example.rodolfo.layoutdispositivos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLogIn = findViewById<Button>(R.id.button2)
        btnLogIn.setOnClickListener {
            val intent = Intent(this@MainActivity, Login::class.java)
            startActivity(intent)
        }

        val btnSignUp = findViewById<Button>(R.id.button)
        btnSignUp.setOnClickListener {
            val intent = Intent(this@MainActivity, Signup::class.java)
            startActivity(intent)
        }
    }
}