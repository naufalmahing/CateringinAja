package com.example.sistemlogin

import android.content.Context
import android.widget.Toast

class ControlUser(val context: Context) {
    private val daftarUser = DaftarUser()

    fun register(nama: String, email: String, noHP: String, username: String, password: String) {
        val user = User(nama, email, noHP, username, password)
        daftarUser.addUser(user).addOnSuccessListener{
            Toast.makeText(context, "berhasil daftar", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener {
            Toast.makeText(context, "gagal daftar", Toast.LENGTH_SHORT).show()
        }
    }

    fun validasi(username: String) {
//        daftarUser.validasi(username).addOnSuccessListener{
//            Toast.makeText(context, "berhasil validasi", Toast.LENGTH_SHORT).show()
//        }.addOnFailureListener {
//            Toast.makeText(context, "gagal validasi", Toast.LENGTH_SHORT).show()
//        }
        if (daftarUser.validasi(username)) {
            Toast.makeText(context, "berhasil login", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "gagal login", Toast.LENGTH_SHORT).show()
        }
    }

    fun loadData() {
        daftarUser.showList()
        daftarUser.loadData()
//        daftarUser.showList()
    }
}