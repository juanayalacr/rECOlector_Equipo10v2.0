package com.example.rodolfo.layoutdispositivos

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Signup: AppCompatActivity() {
    lateinit var nombre: EditText
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var confirmPassword : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        var almacenarDatos: Button = findViewById(R.id.btnCrear)
        nombre = findViewById(R.id.descripcionEvento)
        email = findViewById(R.id.fechaEvento)
        password = findViewById(R.id.direccionEvento)
        confirmPassword = findViewById(R.id.puntosEvento)

        almacenarDatos.setOnClickListener {
            if(testData()){
                var datos = UsuarioClass(nombre.text.toString(),email.text.toString(), password.text.toString())
                var sqlManager = SQLManager(this)
                var response = sqlManager.controlEmail(this,email.text.toString())
                if(response){
                    Toast.makeText(this, "Este usuario ya se encuentra registrado", Toast.LENGTH_SHORT).show()
                }
                else{
                    response = sqlManager.addUsuario(this, datos)
                    if(response){
                        Toast.makeText(this, "El usuario se ha registrado con éxito.", Toast.LENGTH_SHORT).show()
                        cleanForm()
                        toLogin()
                    }
                    else{
                        Toast.makeText(this, "Ocurrió un problema. Intente nuevamente.", Toast.LENGTH_SHORT).show()
                        cleanForm()
                    }
                }
            }
            else{
                Toast.makeText(this, "Completar correctamente todos los datos.", Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun testData(): Boolean{
        var response = true
        if(nombre.text.isEmpty() || email.text.isEmpty() || password.text.toString() != confirmPassword.text.toString()){
                response = false
            }
        return response
    }
    fun cleanForm(){
        email.text.clear()
        nombre.text.clear()
        password.text.clear()
        confirmPassword.text.clear()
    }

    fun toLogin(){
        val intent = Intent(this, Login::class.java)
        startActivity(intent)
    }
}