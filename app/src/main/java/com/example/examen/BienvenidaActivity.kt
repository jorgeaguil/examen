package com.example.examen

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BienvenidaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenida)

        val tituloBienvenida: TextView = findViewById(R.id.tituloBienvenida)
        val nombreApellidoTextView: TextView = findViewById(R.id.nombreApellidoTextView)
        val salirButton: Button = findViewById(R.id.salirButton)

        val nombresApellidos: ArrayList<String>? = intent.getStringArrayListExtra("nombresApellidos")
        val usuario: String? = intent.getStringExtra("usuario")  // Obtener el nombre de usuario

        if (nombresApellidos != null && nombresApellidos.isNotEmpty()) {
            val nombreApellido = nombresApellidos[0]
            nombreApellidoTextView.text = nombreApellido
            Log.d("BienvenidaActivity", "Nombre y apellido recibido: $nombreApellido")
        } else {
            Log.d("BienvenidaActivity", "No se recibieron nombres y apellidos o la lista está vacía")
        }

        // Mostrar un mensaje de bienvenida personalizado según el usuario
        if (usuario == "miUser") {
            tituloBienvenida.text = "Bienvenido de nuevo, $usuario!"
        } else if (usuario == "nuevoUser") {
            tituloBienvenida.text = "Hola, $usuario! Gracias por unirte."
        } else {
            tituloBienvenida.text = "Bienvenid@ a la APP"
        }

        salirButton.setOnClickListener {
            finish()
        }
    }
}
