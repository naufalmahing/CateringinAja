package com.example.sistemlogin

import android.util.Log
import com.google.android.gms.tasks.Task
import com.google.firebase.database.*
import kotlin.collections.ArrayList

class DaftarUser {
    private var databaseReference: DatabaseReference
    private val listUser = ArrayList<User>()

    init {
        val db = FirebaseDatabase.getInstance("https://cateringinaja-44586-default-rtdb.asia-southeast1.firebasedatabase.app")
        databaseReference = db.getReference("DaftarUser")
    }

    fun addUser(user: User) : Task<Void> {
        return databaseReference.push().setValue(user)
    }

    fun validasi(username: String): Boolean {
        var res = false
        for (item in listUser) {
            if (item.getUsername() == username) {
                res = true
            }
        }
        return res
    }

    fun loadData() {
        databaseReference.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (item in dataSnapshot.children) {
                    val user = item.getValue(User::class.java)
                    if (user != null) {
                        listUser.add(user)
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
        println("start")
        for (item in listUser) {
            println(item.getEmail())
        }
    }

}