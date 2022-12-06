package com.example.sistemlogin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity

class ControlUser(val context: Context) {
    private val daftarUser = DaftarUser()

    fun register(nama: String, email: String, noHP: String, username: String, password: String) {
        val user = User(nama, email, noHP, username, password)
        daftarUser.addUser(user).addOnSuccessListener{
            Toast.makeText(context, "berhasil daftar", Toast.LENGTH_SHORT).show()

            // intent ke main page
            val intent = Intent(context, HUtama::class.java)
            startActivity(context, intent, Bundle())
        }.addOnFailureListener {
            Toast.makeText(context, "gagal daftar", Toast.LENGTH_SHORT).show()
        }

    }

    fun login(username: String, password: String) {
        val intent = Intent(context, KateringActivity::class.java)
        startActivity(context, intent, Bundle())

//        if (daftarUser.validasi(username, password)) {
//            Toast.makeText(context, "berhasil login", Toast.LENGTH_SHORT).show()
//
//            // intent ke main page
//            val intent = Intent(context, KateringActivity::class.java)
//            startActivity(context, intent, Bundle())
//        } else {
//            Toast.makeText(context, "gagal login", Toast.LENGTH_SHORT).show()
//        }
    }
}