package com.example.sistemlogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class KateringActivity : AppCompatActivity() {
    private lateinit var rvMasakan: RecyclerView
    private var list: ArrayList<Masakan> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_katering)

        rvMasakan = findViewById(R.id.rv_makanan_tersedia)
        rvMasakan.setHasFixedSize(true)

        list.addAll(MasakansData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvMasakan.layoutManager = LinearLayoutManager(this)
        val listMitraAdapter = ListMasakanAdapter(list)
        rvMasakan.adapter = listMitraAdapter

    }
}