package com.example.examen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var loginEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginEditText = findViewById(R.id.loginEditText)
        passwordEditText = findViewById(R.id.passwordEditText)

        val accesoButton: Button = findViewById(R.id.accesoButton)
        accesoButton.setOnClickListener {
            val login = loginEditText.text.toString()
            val password = passwordEditText.text.toString()

            Log.d("MainActivity", "Login: $login, Password: $password")

            if ((login == "miUser" && password == "miContra") || (login == "nuevoUser" && password == "nuevaContra")) {
                Log.d("MainActivity", "Login correcto, iniciando BienvenidaActivity")

                val listaNombresApellidos = ArrayList<String>()
                listaNombresApellidos.add("Nombre1 Apellido1")
                listaNombresApellidos.add("Nombre2 Apellido2")

                val intent = Intent(this, BienvenidaActivity::class.java)
                intent.putStringArrayListExtra("nombresApellidos", listaNombresApellidos)
                intent.putExtra("usuario", login)  // Enviar el nombre de usuario
                startActivity(intent)
            } else {
                Log.d("MainActivity", "Login o contraseña incorrectos")
            }
        }
    }
}
