package com.example.sistemlogin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity

class ControlMitra(val context: Context): AppCompatActivity() {
    private val daftarMasakan = DaftarMitra()

    fun ubahProfil(email: String, atribut: String, value: String) {
        daftarMasakan.setProfil(email, atribut, value)
    }
}