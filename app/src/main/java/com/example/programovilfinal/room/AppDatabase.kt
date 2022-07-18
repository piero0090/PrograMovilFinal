package com.example.programovilfinal.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.programovilfinal.room.DAO.PosicionRoomDAO
import com.example.programovilfinal.room.Models.PosicionRoom

@Database(entities = arrayOf(PosicionRoom::class), version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun getPosicionesDao(): PosicionRoomDAO
    companion object{
        private var mInstance : AppDatabase?= null
        fun getInstance(context: Context): AppDatabase{
            if(mInstance==null){
                mInstance = Room.inMemoryDatabaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java
                ).allowMainThreadQueries().build()
            }
            return mInstance!!
        }
    }
}