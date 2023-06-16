package com.example.rodolfo.layoutdispositivos

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLManager(context: Context):SQLiteOpenHelper(context, "appreciclaje.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL("CREATE TABLE usuarios (nombre VARCHAR(100), email VARCHAR(100) PRIMARY KEY, password VARCHAR(100))")
        db!!.execSQL("CREATE TABLE eventos (id INTEGER PRIMARY KEY AUTOINCREMENT, nombrEvento VARCHAR(100), fecha Text, direccion VARCHAR(200), puntosObtenidos VARCHAR(100))")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun addUsuario(context: Context, datos: UsuarioClass): Boolean {
        var response = true
        var contentValues = ContentValues()
        contentValues.put("nombre", datos.nombre)
        contentValues.put("email", datos.email)
        contentValues.put("password", datos.password)

        var db = SQLManager(context)
        var manager = db.writableDatabase
        try {
            manager.insert("usuarios", null, contentValues)
        }
        catch (e: Exception){
            print(e.message)
            response = false
        }
        finally {
            db.close()
        }

            return response
    }
    fun controlEmail(context: Context, email: String):Boolean{
        var response: Boolean
        var sql: String = "SELECT email FROM usuarios where email Like '$email'"
        var sqlManager = SQLManager(context)
        var db = sqlManager.readableDatabase
        var data = db.rawQuery(sql, null)
        response = data.moveToFirst()
        return response
    }

    fun checkPassword(context: Context, email: String, password: String): Boolean {
        val db = this.readableDatabase
        val selection = "email = ? AND password= ?"
        val selectionArgs = arrayOf(email, password)
        val cursor: Cursor? = db.query("usuarios", null, selection, selectionArgs, null, null, null)
        val passwordMatches = cursor != null && cursor.count > 0
        cursor?.close()
        db.close()
        return passwordMatches
    }

    fun listEventosAll(context: Context): ArrayList<EventosClass>{
        var arrayList = ArrayList<EventosClass>()
        var SQL: String = "SELECT nombrEvento, fecha, direccion, puntosObtenidos FROM eventos order by fecha"
        var sqlManager = SQLManager(context)
        var db = sqlManager.readableDatabase
        var data = db.rawQuery(SQL, null)
        while (data.moveToNext()){
            arrayList.add(EventosClass(data.getString(0),data.getString(1), data.getString(2), data.getString(3)))
        }
        return arrayList
    }

    fun addEvento(context: Context, datos:EventosClass): Boolean{
        var response = true
        var contentValues = ContentValues()
        contentValues.put("nombrEvento", datos.descripcion)
        contentValues.put("fecha", datos.fecha)
        contentValues.put("direccion", datos.direccion)
        contentValues.put("puntosObtenidos", datos.puntos)
        var db = SQLManager(context)
        var manager = db.writableDatabase
        try{
            manager.insert("eventos", null, contentValues)
        }
        catch (e: Exception){
            print(e.message)
            response = false
        }
        finally {
            db.close()
        }
        return response

    }
    fun obtenerTotalPuntos(): Int {
        val db = this.readableDatabase
        val query = "SELECT SUM(puntosObtenidos) FROM eventos"
        val cursor: Cursor? = db.rawQuery(query, null)
        var totalPuntos = 0

        if (cursor != null && cursor.moveToFirst()) {
            totalPuntos = cursor.getInt(0)
            cursor.close()
        }

        db.close()
        return totalPuntos
    }

}