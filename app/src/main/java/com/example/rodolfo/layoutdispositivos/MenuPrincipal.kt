package com.example.rodolfo.layoutdispositivos

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity


class MenuPrincipal: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_index)

        val eventosDisp: LinearLayout = findViewById(R.id.eventosDisponibles)
        eventosDisp.setOnClickListener{
            val intent = Intent(this, ListaEventos::class.java)
            startActivity(intent)
        }

        val crearEvento: LinearLayout = findViewById(R.id.crearEvento)
        crearEvento.setOnClickListener {
            val intent = Intent(this, FormEventos::class.java)
            startActivity(intent)
        }

        val verRecompensas: LinearLayout = findViewById(R.id.recompensas)
        verRecompensas.setOnClickListener {
            val intent = Intent(this, RecompensasActivity::class.java)
            startActivity(intent)
        }
    }
}