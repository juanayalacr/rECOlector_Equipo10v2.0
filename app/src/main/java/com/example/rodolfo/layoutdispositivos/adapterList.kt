package com.example.rodolfo.layoutdispositivos

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class adapterList: BaseAdapter{
    var context: Context? = null
    var arrayList = ArrayList<EventosClass>()

    constructor(context: Context?, arrayList: ArrayList<EventosClass>) : super() {
        this.context = context
        this.arrayList = arrayList
    }

    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getItem(position: Int): Any {
        return arrayList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
        var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var row = inflater.inflate(R.layout.row_list, null)
        var nombre = row.findViewById<TextView>(R.id.listDescripcion)
        var fecha = row.findViewById<TextView>(R.id.listFecha)
        var direccion = row.findViewById<TextView>(R.id.listDireccion)
        var puntos = row.findViewById<TextView>(R.id.listPuntos)
        nombre.text = arrayList[position].descripcion
        fecha.text = arrayList[position].fecha
        direccion.text = arrayList[position].direccion
        puntos.text = arrayList[position].puntos
        return row
    }
}