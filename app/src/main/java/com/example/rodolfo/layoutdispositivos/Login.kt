package com.example.rodolfo.layoutdispositivos

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Login: AppCompatActivity() {
    lateinit var emailLogin: EditText
    lateinit var passwordLogin: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginButton: Button = findViewById(R.id.btnCrear)
        emailLogin = findViewById(R.id.direccionEvento)
        passwordLogin = findViewById(R.id.puntosEvento)

        loginButton.setOnClickListener {
            val inputEmail = emailLogin.text.toString()
            val inputPassword = passwordLogin.text.toString()

            val sqlManager = SQLManager(this)
            val accountExists = sqlManager.controlEmail(this, inputEmail)
            if(!accountExists){
                Toast.makeText(this, "Esta cuenta no existe.", Toast.LENGTH_SHORT).show()
            }else{
                val passwordMatches = sqlManager.checkPassword(this, inputEmail, inputPassword)
                if(passwordMatches){
                    Toast.makeText(this, "Inicio de sesión exitoso.", Toast.LENGTH_SHORT).show()
                    toIndex()
                }else{
                    Toast.makeText(this, "La contaseña no coincide.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    fun toIndex(){
        val intent = Intent(this, MenuPrincipal::class.java)
        startActivity(intent)
    }
}