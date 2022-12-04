package com.example.sistemlogin

import android.os.Parcel
import android.os.Parcelable

class Mitra(
    private val nama: String = "",
    private val noHp: String = "",
    private val username: String = "",
    private val password: String = "",
    private val deskripsi: String = "",
    private val alamat: String = "",
    private val email: String = "",
) {

    fun getNama() = nama
    fun getNoHp() = noHp
    fun getUsername() = username
    fun getPassword() = password
    fun getDeskripsi() = deskripsi
    fun getAlamat() = alamat
    fun getEmail() = email

}