package com.example.sistemlogin

class ControlPesanan {
    private val daftarPesanan = DaftarPesanan()


    fun tambahPesanan(masakan: Masakan, jumlah: Int, alamat: String, metodeP: String, ePembeli: String, eKatering: String) {
        daftarPesanan.addPesanan(Pesanan(masakan, jumlah, "", emailMitra = eKatering, emailPembeli = ePembeli, metodePembayaran = metodeP))
    }

    fun konfirmasi(idPesanan: String) {
        daftarPesanan.setKonfirmasi(idPesanan, true)
    }
}