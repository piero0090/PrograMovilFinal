package com.example.programovilfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    private lateinit var edtUser:EditText
    private lateinit var edtPass:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val b: Bundle
        val btniniciosesion = findViewById<Button>(R.id.btnInicioSesion)
        val txtvRegistro = findViewById<TextView>(R.id.tvRegistrate)
        edtUser= findViewById(R.id.edtUserCod)
        edtPass= findViewById(R.id.edtPass)

        btniniciosesion.setOnClickListener {
            GestUsers.getInstance().LoginUsers(edtUser.text.toString().toInt(),edtPass.text.toString()){
                if (it==null){
                    val toast= Toast.makeText(applicationContext,"CONTRASEÑA/PASSWORD INCORRECTOS",Toast.LENGTH_SHORT)
                    toast.show()
                    //Log.i("GAA","NOOOOOOOOOOOOOOOO")
                }else{
                    val intent = Intent(this,MainActivity::class.java)
                    intent.putExtra("Usercod", edtUser.text.toString())//*************************
                    startActivity(intent)
                    //Log.i("asa","SUCCCESSSSS")
                }
            }

        }

        txtvRegistro.setOnClickListener {
            val intent = Intent(this,RegistroActivity::class.java)
            startActivity(intent)
        }
    }


}