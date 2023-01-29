package com.example.sistemlogin

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HPencarian: AppCompatActivity() {

    val controlMasakan = ControlMasakan(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pencarian)

        var etCari = findViewById<EditText>(R.id.et_cari)
        val tvHasilPencarian = findViewById<TextView>(R.id.tv_hasil_pencarian)

        findViewById<Button>(R.id.cari_button).setOnClickListener {
            if (etCari.text.toString() != "") {
                val list = controlMasakan.search(etCari.text.toString())
                for (item in list) {
                    tvHasilPencarian.text = item.getNama() + "\n"
                }
            } else {
                tvHasilPencarian.text = ""
            }
        }
    }
}