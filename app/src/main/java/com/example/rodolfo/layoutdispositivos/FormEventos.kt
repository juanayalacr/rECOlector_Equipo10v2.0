package com.example.rodolfo.layoutdispositivos

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class FormEventos: AppCompatActivity() {
    lateinit var nombreEvento: EditText
    lateinit var fechaEvento: EditText
    lateinit var direccionEvento: EditText
    lateinit var puntosEvento: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crearevento)

        var almacenaDatos: Button = findViewById(R.id.btnCrear)
        nombreEvento = findViewById(R.id.descripcionEvento)
        fechaEvento = findViewById(R.id.fechaEvento)
        direccionEvento = findViewById(R.id.direccionEvento)
        puntosEvento = findViewById(R.id.puntosEvento)

        almacenaDatos.setOnClickListener {
            if (testData()) {
                var datos = EventosClass(nombreEvento.text.toString(), fechaEvento.text.toString(), direccionEvento.text.toString(), puntosEvento.text.toString())
                var sqlManager = SQLManager(this)
                var response = sqlManager.addEvento(this, datos)
                if (response) {
                    Toast.makeText(this, "Evento Creado Correctamente", Toast.LENGTH_SHORT).show()
                    toEventos()
                } else {
                    Toast.makeText(this, "El evento no ha podido ser creado", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Completar todos los datos", Toast.LENGTH_SHORT).show()
            }
        }


    }
    fun testData(): Boolean{
        var response = true
        if(nombreEvento.text.isEmpty() || fechaEvento.text.isEmpty() || direccionEvento.text.isEmpty() || puntosEvento.text.isEmpty()){
            response = false
        }
        return response
    }

    fun toEventos(){
        val intent = Intent(this, ListaEventos::class.java)
        startActivity(intent)
    }
}