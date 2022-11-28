package com.example.sistemlogin

import android.util.Log
import com.google.android.gms.tasks.Task
import com.google.firebase.database.*
import kotlin.collections.ArrayList

class DaftarUser {
    private var databaseReference: DatabaseReference
    private val listUser = ArrayList<Masakan>()

    init {
        val db = FirebaseDatabase.getInstance("https://cateringinaja-44586-default-rtdb.asia-southeast1.firebasedatabase.app")
        databaseReference = db.getReference("DaftarMasakan")
        loadData()
    }

    fun addMasakan(masakan: Masakan) : Task<Void> {
        return databaseReference.push().setValue(masakan)
    }

    fun loadData() {
        databaseReference.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                listUser.clear()
                for (item in dataSnapshot.children) {
                    val user = item.getValue(Masakan::class.java)
                    if (user != null) {
                        listUser.add(user)
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
        for (item in listUser) {
            Log.v("showlist", item.getEmail())
        }
    }

}