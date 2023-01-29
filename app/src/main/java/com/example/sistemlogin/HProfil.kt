package com.example.sistemlogin

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class HProfil: AppCompatActivity() {

    val controlMitra = ControlMitra(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)

        val etNama = findViewById<EditText>(R.id.etNamaProfil)
        val etEmail = findViewById<EditText>(R.id.etEmaiLProfil)
        val etNoHp = findViewById<EditText>(R.id.etNoHpProfil)

        etNama.setText("naufal")
        etEmail.setText("zaki@gmail")
        etNoHp.setText( "082234981123")

        val daftarMitra = DaftarMitra()
        var email = etEmail.text.toString()
        var key = daftarMitra.getKey(email)

        findViewById<Button>(R.id.saveButtonProfil).setOnClickListener {
//            controlMitra.ubahProfil(key, "noHP", key)
            controlMitra.ubahProfil("mahing", "nama", "nopal")
            etNama.setText(etNama.text)
            etEmail.setText(etEmail.text)
            etNoHp.setText(etNoHp.text)
            Toast.makeText(this, "berhasil ubah profil", Toast.LENGTH_SHORT).show()
        }
    }
}