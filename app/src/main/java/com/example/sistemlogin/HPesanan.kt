package com.example.sistemlogin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HPesanan: AppCompatActivity() {

    private var  listPesanan = ArrayList<Pesanan>()
    private var listDaftarPesananAdapter = ListDaftarPesananAdapter(listPesanan)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar_pesanan)

//        listDaftarPesananAdapter.listPesanan.addAll(listPesanan)
        val rv = findViewById<RecyclerView>(R.id.rv_daftar_pesanan)
        rv.layoutManager = LinearLayoutManager(this)
        rv.setHasFixedSize(true)
        rv.adapter = listDaftarPesananAdapter
    }
}