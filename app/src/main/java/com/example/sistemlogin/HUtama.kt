package com.example.sistemlogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class HUtama : AppCompatActivity() {

    val controlMasakan = ControlMitra(this)
    val daftarMitra = DaftarMitra()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)

        daftarMitra.showList()

        findViewById<Button>(R.id.button).setOnClickListener {
            // input email, nama atribut, value

            controlMasakan.ubahProfil("nopal", "noHP", "087734982389")
        }

        findViewById<Button>(R.id.button3).setOnClickListener {
            daftarMitra.showList()
        }
    }
}