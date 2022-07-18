package com.example.programovilfinal.room.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.programovilfinal.room.Models.PosicionRoom

@Dao
interface PosicionRoomDAO {
    @Query("SELECT * FROM PosicionRoom")
    fun getallPosiciones() :List<PosicionRoom>

    @Query("SELECT * FROM PosicionRoom where piso=:pisoUno" )
    fun getPosicion(pisoUno : String) :List<PosicionRoom>

    @Insert
    fun insertPosiciones(posicion: PosicionRoom)

    @Query("DELETE FROM PosicionRoom")
    fun borrarAll ()
}