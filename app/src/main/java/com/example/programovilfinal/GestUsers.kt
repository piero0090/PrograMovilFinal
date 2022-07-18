package com.example.programovilfinal

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.auth.User
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import javax.security.auth.callback.Callback

class GestUsers {
    val db= Firebase.firestore

    companion object{
        private var instance: GestUsers?=null
        fun getInstance():GestUsers{
            if(instance==null){
                instance= GestUsers()
            }
            return instance!!
        }
    }

    fun LoginUsers (usercod: Number, password : String,callback: (Usuarios?) ->Unit){
        db.collection("Usuarios").whereEqualTo(
            "usercod", usercod).whereEqualTo(
            "contrass",password).get().addOnSuccessListener {
            if (it!!.documents.size>0){
               val usuario=Usuarios(
                   it.documents[0].id,
                   it.documents[0]["usercod"].toString().toInt(),
                   it.documents[0]["password"].toString()
               )
                callback(usuario)
            }else{
                callback(null)
            }
        }
    }

   fun RegistroUsers(usercod: Number, password : String, correo: String, matricula: String,
                     celular:Number) {
       val data = hashMapOf("usercod" to usercod, "contrass" to password, "correo" to correo,
           "matricula" to matricula, "numcelular" to celular)
        db.collection("Usuarios").add(data)
   }

    fun ActualizarUsers (newpass: String, newmatricula: String, newphone: Number){
        db.collection("Usuarios").document("kcRHbcqxQko5MGiktw5i").update(
            "contrass",newpass,
            "matricula",newmatricula,
            "numcelular",newphone
        )
    }
}