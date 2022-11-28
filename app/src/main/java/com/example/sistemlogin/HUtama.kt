package com.example.sistemlogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class HUtama : AppCompatActivity() {

    val controlMasakan = ControlMasakan(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)

//        daftar.showList()
//        var frag_search = HPencarian()
//        val bundle = Bundle()

        val etSearch = findViewById<EditText>(R.id.editText)

//        supportFragmentManager.beginTransaction().apply {
//            replace(R.id.fragment_search, frag_search)
//            commit()
//            Log.w("pencarian", "load hutama")
//        }

        findViewById<Button>(R.id.button).setOnClickListener {
            var res = "masakan\n"
            for (item in controlMasakan.search(etSearch.text.toString())) {
                res += item.getNama() + "\n"
            }
            findViewById<TextView>(R.id.textView2).text = res
        }

//        findViewById<Button>(R.id.button).setOnClickListener {
//            supportFragmentManager.beginTransaction().apply {
//                frag_search = HPencarian()
//                bundle.putString("SEARCH", etSearch.text.toString())
//                frag_search.arguments = bundle
//                replace(R.id.fragment_search, frag_search)
//                commit()
//
//                Log.w("pencarian", "hutama")
//            }
//        }

//        val bundle: Bundle? = intent.extras
//        val listMasakan = bundle?.getParcelableArrayList<Masakan>("listMasakan")

//        val controlMasakan = ControlMasakan(this)
//        val listMasakan = controlMasakan.search("ay")
//        var list = ""
//        if (listMasakan != null) {
//            for (item in listMasakan) {
//                list += item.getNama() + "\n"
//            }
//        }

//        findViewById<TextView>(R.id.textView2).text = list
    }
}