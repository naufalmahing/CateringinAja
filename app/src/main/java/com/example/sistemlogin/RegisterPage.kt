package com.example.sistemlogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegisterPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_page)

        val etUsername = findViewById<EditText>(R.id.et_username)
        val etPassword = findViewById<EditText>(R.id.et_password)
        val etConfirmPassword = findViewById<EditText>(R.id.et_confirm_password)
        val etNoHP = findViewById<EditText>(R.id.et_numphone)
        val etEmail = findViewById<EditText>(R.id.et_email)

        val registerButton = findViewById<Button>(R.id.btn_next)
        val backButton = findViewById<Button>(R.id.btn_cancel)

        val controlUser = ControlUser(this)
        controlUser.loadData()

        registerButton.setOnClickListener {
//             fungsi validasi copas dari main activity nanda

//            controlUser.register(etUsername.text.toString(), etEmail.text.toString(), etNoHP.text.toString(), etUsername.text.toString(), etPassword.text.toString())
//            startActivity(Intent(this, MainActivity::class.java))

            controlUser.validasi(etUsername.text.toString())
        }

        backButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

}