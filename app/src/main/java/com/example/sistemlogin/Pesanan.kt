package com.example.sistemlogin

import java.util.*

class Pesanan( // id pake input dari push firebase atau pake fungsi sendiri yang berdasarkan waktu ato lain-lain dengan liat dari internet
    private val masakan: Masakan? = null,
    private var porsi: Int = 0,
    private var id: String = "",
    private var konfirmasiMitra: Boolean = false,
    private var totalPembayaran: Int = 0,
    private var emailPembeli: String = "",
    private var emailMitra: String = "",
    private var statusPembayaran: Boolean = false,
    private val metodePembayaran: String = ""
) {

    init {
        if (masakan != null)
            totalPembayaran = porsi * masakan.getHarga()
        id = UUID.randomUUID().toString()
    }

    fun getMasakan() = masakan
    fun getPorsi() = porsi
    fun getId() = id
    fun setId(id: String) {this.id = id}
    fun getTotalPembayaran() = totalPembayaran
    fun getKonfirmasiMitra() = konfirmasiMitra
    fun getEmailPembeli() = emailPembeli
    fun getEmailMitra() = emailMitra
    fun getStatusPembayaran() = statusPembayaran

}