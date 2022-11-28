package com.example.sistemlogin

import android.util.Log
import com.bumptech.glide.disklrucache.DiskLruCache
import com.google.android.gms.tasks.Task
import com.google.firebase.database.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class DaftarMasakan {
    private var databaseReference: DatabaseReference
    private val listMasakan = ArrayList<Masakan>()

    init {
        val db = FirebaseDatabase.getInstance("https://cateringinaja-44586-default-rtdb.asia-southeast1.firebasedatabase.app")
        databaseReference = db.getReference("DaftarMasakan")
        loadData()
    }

    fun read(keyword: String): ArrayList<Masakan> {
        val res = ArrayList<Masakan>()
        Log.v("read", "start")
        for (item in listMasakan) {
            if (item.getNama().contains(keyword.trim(), ignoreCase = true)) {
                res.add(item)
            }
        }
        return res
    }

    fun update(email: String, aksi: String, idMasakan: String, atribut: String, value: String, masakan: Masakan? = null) {
        if (aksi == "TAMBAH") {
            if (masakan != null)
                databaseReference.push().setValue(masakan)
        }

        if (aksi == "HAPUS") {
            databaseReference.child(idMasakan).removeValue()
        }

        if (aksi == "EDIT") {
            val hash = HashMap<String, Any>()
            if (atribut == "harga")
                hash.put(atribut, value.toInt())
            else
                hash.put(atribut, value)
            databaseReference.child(idMasakan).updateChildren(hash)
        }
        showList()
    }

    fun getListMasakan() = listMasakan

    fun loadData() {
        databaseReference.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                listMasakan.clear()
                for (item in dataSnapshot.children) {
                    val user = item.getValue(Masakan::class.java)
                    if (user != null) {
                        listMasakan.add(user)
                        Log.w("loadData", user.toString())
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
        for (item in listMasakan) {
            Log.v("showlist", item.getEmail())
        }
    }
}