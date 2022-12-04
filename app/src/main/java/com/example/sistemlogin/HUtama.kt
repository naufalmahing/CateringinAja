package com.example.sistemlogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class HUtama : AppCompatActivity() {

    val controlMitra = ControlMitra(this)
    val daftarMitra = DaftarMitra()
    val controlMasakan = ControlMasakan(this)
    val controlPesanan = ControlPesanan(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)

        daftarMitra.showList()

        val etSearch = findViewById<EditText>(R.id.editText)

        findViewById<Button>(R.id.button).setOnClickListener {
            // input email, nama atribut, value

//            controlMitra.ubahProfil("nopal", "noHP", "087734982389")

//            var res = "masakan\n"
//            for (item in controlMasakan.search(etSearch.text.toString())) {
//                res += item.getNama() + "\n"
//            }
//            findViewById<TextView>(R.id.textView2).text = res

//            controlMasakan.aturMasakan("nanda", "EDIT", "kari", "deskripsi", "coto makassar bang")

//            controlPesanan.tambahPesanan(Masakan("gulai kambing", "daging lembut", 25000, "nopal"), 50, "balikpapan", "mobile bank", "nanda", "nopal")
        }

        findViewById<Button>(R.id.button3).setOnClickListener {
            daftarMitra.showList()
        }
    }
}