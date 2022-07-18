package com.example.programovilfinal

import android.content.Context
import com.example.programovilfinal.models.Posiciones
import com.example.programovilfinal.room.AppDatabase
import com.example.programovilfinal.room.DAO.PosicionRoomDAO
import com.example.programovilfinal.room.Models.PosicionRoom

class GestorPosiciones {
    fun obtenerListaPosicionesRoom(context: Context, piso : String): List<Posiciones>{

        val daoPosiciones: PosicionRoomDAO = AppDatabase.getInstance(context).getPosicionesDao()

        val listaPosicionesRoom= daoPosiciones.getallPosiciones()

        println(listaPosicionesRoom.size)

        val listaPosiciones = listaPosicionesRoom.map {
            Posiciones(it.Discp, it.Estado, it.Numero, it.Piso, it.Seccion)
        }
        return listaPosiciones
    }
}