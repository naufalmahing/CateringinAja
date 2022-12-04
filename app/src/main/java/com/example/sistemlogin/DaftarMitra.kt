package com.example.sistemlogin

import android.util.Log
import com.google.firebase.database.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class DaftarMitra {
    private var databaseReference: DatabaseReference
    private val listMitra = ArrayList<Mitra>()

    init {
        val db = FirebaseDatabase.getInstance("https://cateringinaja-44586-default-rtdb.asia-southeast1.firebasedatabase.app")
        databaseReference = db.getReference("DaftarUser")
        loadData()
    }

    fun setProfil(email: String, atribut: String, value: String) {
        val hash = HashMap<String, Any>()
        hash.put(atribut, value)
        databaseReference.child(email).updateChildren(hash)
        showList()
    }

    fun loadData() {
        databaseReference.addValueEventListener(object: ValueEventListener {
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
            }
            override fun onCancelled(error: DatabaseError) {
                Log.w("validasi", "Failed to read value", error.toException())
            }
        })
    }

    fun showList() {
        for (item in listMitra) {
            Log.v("showlist", item.getEmail())
        }
    }
}