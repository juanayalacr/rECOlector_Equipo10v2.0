package com.example.rodolfo.layoutdispositivos

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class ListaEventos : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eventos)

        var listaView: ListView = findViewById(R.id.lista)
        var sqlManager = SQLManager(this)
        var arrayList = sqlManager.listEventosAll(this)
        var adapterList = adapterList(this, arrayList)
        listaView.adapter = adapterList
    }
}