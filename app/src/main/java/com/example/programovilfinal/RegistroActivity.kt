package com.example.programovilfinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class RegistroActivity : AppCompatActivity() {

    private lateinit var edtUser:EditText
    private lateinit var edtPass:EditText
    private lateinit var edtCelular:EditText
    private lateinit var edtMatricula:EditText
    private lateinit var edtCorreo:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        val btnRegistro =findViewById<Button>(R.id.btnRegistrar)

        edtUser=findViewById(R.id.edtUserReg)
        edtPass=findViewById(R.id.edtPassReg)
        edtCelular=findViewById(R.id.edtPhoneReg)
        edtMatricula=findViewById(R.id.edtMatriculaReg)
        edtCorreo=findViewById(R.id.edtCorreoReg)

        btnRegistro.setOnClickListener {
            GestUsers.getInstance().RegistroUsers(edtUser.text.toString().toInt(),
                edtPass.text.toString(),edtCorreo.text.toString(),edtMatricula.text.toString(),
                edtCelular.text.toString().toInt())
            val toast= Toast.makeText(applicationContext, "Registro satisfactorio", Toast.LENGTH_SHORT)
            toast.show()
            finish()
        }
    }

}