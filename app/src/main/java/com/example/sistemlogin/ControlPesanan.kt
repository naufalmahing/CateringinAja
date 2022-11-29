package com.example.sistemlogin

import android.content.Context

class ControlPesanan(private val context: Context) {
    private val daftarPesanan = DaftarPesanan()


    fun tambahPesanan(masakan: Masakan, jumlah: Int, alamat: String, metodeP: String, ePembeli: String, eKatering: String) {
        daftarPesanan.addPesanan(Pesanan(masakan, jumlah, "", emailMitra = eKatering, emailPembeli = ePembeli, metodePembayaran = metodeP))
        Notifikasi(context).show("Pesanan berhasil dibuat")
    }

    fun konfirmasi(idPesanan: String) {
        daftarPesanan.setKonfirmasi(idPesanan, true)
        Notifikasi(context).show("Pesanan sudah dikonfirmasi")
    }
}