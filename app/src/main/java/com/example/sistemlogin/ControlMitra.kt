package com.example.sistemlogin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity

class ControlMitra(val context: Context): AppCompatActivity() {
    private val daftarMitra = DaftarMitra()

    fun ubahProfil(email: String, atribut: String, value: String) {
        daftarMitra.setProfil(email, atribut, value)
    }

    fun getListMitra() = daftarMitra.getListMitra()
}