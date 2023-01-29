package com.example.sistemlogin

import android.util.Log
import com.google.firebase.database.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class DaftarMitra {
    private var databaseReference: DatabaseReference
    private val listMitra = ArrayList<Mitra>()
    val db = FirebaseDatabase.getInstance("https://cateringinaja-44586-default-rtdb.asia-southeast1.firebasedatabase.app")

    init {
        databaseReference = db.getReference("DaftarMitra")
        loadData()
    }

    fun getKey(email: String): String {
        var key = ""
        db.getReference("DaftarUser").orderByChild("email").equalTo(email).addListenerForSingleValueEvent(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (item in snapshot.children) {
                    key = item.key.toString()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
        return key
    }

    fun setProfil(email: String, atribut: String, value: String) {
        val hash = HashMap<String, Any>()
        hash.put(atribut, value)

        databaseReference.child(email).updateChildren(hash)
//        db.getReference("DaftarUser").child(email).updateChildren(hash)
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
                Log.w("loadData", "Failed to read value", error.toException())
            }
        })
    }

    fun showList() {
        for (item in listMitra) {
            Log.v("showlist", item.getEmail())
        }
    }

    fun getListMitra() = listMitra

    fun get(): Query = databaseReference.orderByKey()
}