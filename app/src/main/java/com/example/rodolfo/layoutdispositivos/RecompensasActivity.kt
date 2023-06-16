package com.example.rodolfo.layoutdispositivos

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class RecompensasActivity : AppCompatActivity() {
    lateinit var totalPuntosTextView: TextView
    lateinit var sqlManager: SQLManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recompensas2)


        totalPuntosTextView = findViewById(R.id.totalPuntosTextView)
        sqlManager = SQLManager(this)

        val totalPuntos = sqlManager.obtenerTotalPuntos()
        totalPuntosTextView.text = "Total de puntos: $totalPuntos"


    }
}