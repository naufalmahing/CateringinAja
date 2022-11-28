package com.example.sistemlogin

import android.util.Log
import com.google.android.gms.tasks.Task
import com.google.firebase.database.*

class DaftarPesanan {
    private var databaseReference: DatabaseReference
    private val listPesanan = ArrayList<Pesanan>()

    init {
        val db = FirebaseDatabase.getInstance("https://cateringinaja-44586-default-rtdb.asia-southeast1.firebasedatabase.app")
        databaseReference = db.getReference("DaftarPesanan")
        loadData()
    }

    fun addPesanan(pesanan: Pesanan): Task<Void> {
        return databaseReference.child(pesanan.getId()).setValue(pesanan)
    }

    fun setKonfirmasi(idPesanan: String, konfirmasi: Boolean) {
        val hash = HashMap< String, Any>()
        hash.put("konfirmasiMitra", konfirmasi)
        databaseReference.child(idPesanan).updateChildren(hash)
    }

    fun loadData() {
        databaseReference.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                listPesanan.clear()
                for (item in snapshot.children) {
                    val pesanan = item.getValue(Pesanan::class.java)
                    if (pesanan != null) {
                        listPesanan.add(pesanan)
                    } else {
                        Log.w("loadData", "Pesanan null")
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w("loadData", error.toException())
            }
        })
    }

    fun showList() {
        println("start")
        for (item in listPesanan) {
            item.getMasakan()?.let { Log.v("showlist", it.getNama()) }
        }
    }
}