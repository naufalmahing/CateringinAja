package com.example.sistemlogin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity

class ControlMasakan(val context: Context): AppCompatActivity() {
    private val daftarMasakan = DaftarMasakan()

    fun search(keyword: String): ArrayList<Masakan> {
        return daftarMasakan.read(keyword)
    }

    fun aturMasakan(email: String, aksi: String, idMasakan: String, atribut: String, value: String, masakan: Masakan? = null) {
        daftarMasakan.update(email, aksi, idMasakan, atribut, value, masakan)
    }
}