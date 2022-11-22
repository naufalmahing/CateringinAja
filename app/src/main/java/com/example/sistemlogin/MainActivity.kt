package com.example.sistemlogin

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var buttonLogin : Button
    private lateinit var userNameEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonLogin = findViewById(R.id.btnLogin)
        userNameEditText = findViewById(R.id.username_field)
        passwordEditText = findViewById(R.id.password_fields)

        val daoUser = DAOUser()
        buttonLogin.setOnClickListener {
            val user = User(userNameEditText.text.toString(), passwordEditText.text.toString())
            daoUser.add(user).addOnSuccessListener{
                Toast.makeText(this, "Berhasil tambah user", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(this, it.message.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }

}