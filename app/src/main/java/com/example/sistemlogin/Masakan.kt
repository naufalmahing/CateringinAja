package com.example.sistemlogin

import android.os.Parcel
import android.os.Parcelable

class Masakan(
    private val nama: String = "",
    private val deskripsi: String = "",
    private val harga: Int = 0,
    private val email: String = "",
) {



    fun getNama() = nama
    fun getDeskripsi() = deskripsi
    fun getHarga() = harga
    fun getEmail() = email

}