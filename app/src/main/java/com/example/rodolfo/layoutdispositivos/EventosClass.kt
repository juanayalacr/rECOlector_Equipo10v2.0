package com.example.rodolfo.layoutdispositivos

class EventosClass(
    var descripcion: String,
    var fecha: String,
    var direccion: String,
    var puntos: String,
    var userId: String // Agrega el campo userId para la relación con el usuario
) {
    constructor(descripcion: String, fecha: String, direccion: String, puntos: String) :
            this(descripcion, fecha, direccion, puntos, "") // Constructor secundario sin el campo userId
}
