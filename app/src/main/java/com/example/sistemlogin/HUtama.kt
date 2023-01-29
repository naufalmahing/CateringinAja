package com.example.sistemlogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.SearchView
import android.widget.Toast

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class HUtama : AppCompatActivity() {

    val controlMitra = ControlMitra(this)
    val daftarMitra = DaftarMitra()
    val controlMasakan = ControlMasakan(this)
    val controlPesanan = ControlPesanan(this)

    private lateinit var rvMitras: RecyclerView
    private var listMitra: ArrayList<Mitra> = arrayListOf()

    val listMitraAdapter = ListMitraAdapter(listMitra)

    fun loadData() {
        daftarMitra.get().addValueEventListener(object: ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                listMitra.clear()
                for (item in dataSnapshot.children) {
                    val mitra = item.getValue(Mitra::class.java)
                    if (mitra != null) {
                        listMitra.add(mitra)
                        Log.w("loadData", mitra.toString())
                    } else {
                        Log.w("loadData", "null")
                    }
                }
                listMitraAdapter.setItems(listMitra)
                listMitraAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w("loadData", "Failed to read value", error.toException())
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page_recycler_view)

//        daftarMitra.showList()

        val searchView = findViewById<SearchView>(R.id.simpleSearchView)

        rvMitras = findViewById(R.id.rv_mitras)
        rvMitras.setHasFixedSize(true)

        findViewById<Button>(R.id.profilButton).setOnClickListener {
            startActivity(Intent(this, HProfil::class.java))
        }

        findViewById<Button>(R.id.pesananButton).setOnClickListener {
            startActivity(Intent(this, HPesanan::class.java))
        }

        findViewById<Button>(R.id.cariButton).setOnClickListener {
            startActivity(Intent(this, HPencarian::class.java))
        }
//        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(p0: String?): Boolean {
//                rvMitras.adapter = null
//                return false
//            }
//
//            override fun onQueryTextChange(p0: String?): Boolean {
////                listMitraAdapter.
//                return true
//            }
//        }
//        )

//        findViewById<Button>(R.id.button).setOnClickListener {
            // input email, nama atribut, value

//            controlMitra.ubahProfil("nopal", "noHP", "087734982389")

//            var res = "masakan\n"
//            for (item in controlMasakan.search(etSearch.text.toString())) {
//                res += item.getNama() + "\n"
//            }
//            findViewById<TextView>(R.id.textView2).text = res

//            controlMasakan.aturMasakan("nanda", "EDIT", "kari", "deskripsi", "coto makassar bang")

//            controlPesanan.tambahPesanan(Masakan("gulai kambing", "daging lembut", 25000, "nopal"), 50, "balikpapan", "mobile bank", "nanda", "nopal")
//        }

//        findViewById<Button>(R.id.button3).setOnClickListener {
//            daftarMitra.showList()
//        }



//        list.addAll(MitrasData.listData)
//        list.addAll(controlMitra.getListMitra())
        showRecyclerList()
        loadData()
    }

    private fun showRecyclerList() {
        rvMitras.layoutManager = LinearLayoutManager(this)
//        val listMitraAdapter = ListMitraAdapter(list)
//        listMitraAdapter.loadData()
        rvMitras.adapter = listMitraAdapter

        listMitraAdapter.setOnItemClickCallback(object : ListMitraAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Mitra) {
                showSelectorMitra(data)
            }
        })
    }

    private fun showSelectorMitra(data: Mitra) {
        Toast.makeText(this, "You choose "+ data.getNama(), Toast.LENGTH_SHORT).show()
        var moveKatering = Intent(this@HUtama, KateringActivity::class.java)

        moveKatering.putExtra(KateringActivity.EXTRA_NAME, data.getNama())
//        moveKatering.putExtra(KateringActivity.EXTRA_PHOTO, data.photo)
        moveKatering.putExtra(KateringActivity.EXTRA_LOKASI, data.getAlamat())
        startActivity(moveKatering)
    }
}