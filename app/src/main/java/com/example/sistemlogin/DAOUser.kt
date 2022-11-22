package com.example.sistemlogin

import com.google.android.gms.tasks.Task
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class DAOUser {
    private var databaseReference: DatabaseReference

    init {
        val db = FirebaseDatabase.getInstance("https://cateringinaja-44586-default-rtdb.asia-southeast1.firebasedatabase.app")
        databaseReference = db.getReference("DaftarUser")
    }

    fun add(user: User): Task<Void> {
        return databaseReference.push().setValue(user)
    }
}