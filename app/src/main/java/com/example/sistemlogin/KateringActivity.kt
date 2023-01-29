package com.example.sistemlogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class KateringActivity : AppCompatActivity() {
    private lateinit var rvMasakan: RecyclerView
    private lateinit var rvRekomendasi : RecyclerView
    private var list: ArrayList<Masakan> = arrayListOf()

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_LOKASI = "extra_lokasi"
        const val EXTRA_PHOTO = "extra_photo"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_katering)

        rvMasakan = findViewById(R.id.rv_makanan_tersedia)
        rvMasakan.setHasFixedSize(true)

        rvRekomendasi = findViewById(R.id.rv_rekomendasi_makanan)
        rvRekomendasi.setHasFixedSize(true)

        list.addAll(MasakansData.listData)
        showRecyclerList()
        showRecyclerListRekomendasi()

        val tvNamaMitra: TextView = findViewById(R.id.tv_nama_mitra)
        val tvLokasiMitra: TextView = findViewById(R.id.tv_item_lokasi)
        val tvPhotoMitra: ImageView = findViewById(R.id.tv_img_photo_mitra)

        val nama = intent.getStringExtra(EXTRA_NAME)
        val lokasi = intent.getStringExtra(EXTRA_LOKASI)
        val photo = intent.getIntExtra(EXTRA_PHOTO, 0)

        tvNamaMitra.text = nama
        tvLokasiMitra.text = lokasi
        tvPhotoMitra.setImageResource(photo)
    }

    private fun showRecyclerList() {
        rvMasakan.layoutManager = LinearLayoutManager(this)
        val listMasakanAdapter = ListMasakanAdapter(list)

        rvMasakan.adapter = listMasakanAdapter
    }

    private fun showRecyclerListRekomendasi() {
        rvRekomendasi.layoutManager = LinearLayoutManager(this)
        val listMasakanAdapter = ListMasakanAdapter(list)
        rvRekomendasi.adapter = listMasakanAdapter
    }
}