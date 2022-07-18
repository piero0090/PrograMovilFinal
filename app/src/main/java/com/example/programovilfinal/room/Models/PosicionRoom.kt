package com.example.programovilfinal.room.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PosicionRoom (
    @ColumnInfo(name = "Discp")
    val Discp : Boolean,
    @ColumnInfo(name = "Estado")
    val Estado : Boolean,
    @ColumnInfo(name = "Numero")
    val Numero : Int,
    @ColumnInfo(name = "Piso")
    val Piso : Int,
    @ColumnInfo(name = "Seccion")
    val Seccion : String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)