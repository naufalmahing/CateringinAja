
package com.example.sistemlogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var UserName : EditText
    private lateinit var PassWord : EditText
    private lateinit var buttonLogin : Button
    private lateinit var statusLogin : TextView
    private lateinit var daoUser: DAOUser

    companion object {
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        UserName = findViewById(R.id.username_field)
        PassWord = findViewById(R.id.password_fields)
        buttonLogin = findViewById(R.id.btnLogin)
        statusLogin = findViewById(R.id.result_data)

        buttonLogin.setOnClickListener(this)

        val daoUser = DAOUser()

        if(savedInstanceState != null) {
            val result = savedInstanceState.getString(STATE_RESULT)
            statusLogin.text = result
        }
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putString(STATE_RESULT, statusLogin.text.toString())
    }

    override fun onClick(p0: View?) {
        if(p0?.id == R.id.btnLogin) {
            val userName = UserName.text.toString().trim()
            val passWord = PassWord.text.toString().trim()

            var isEmptyFields = false

            if(userName.isEmpty()) {
                isEmptyFields = true
                UserName.error = "Fields ini tidak boleh kosong"
            }

            if(passWord.isEmpty()) {
                isEmptyFields = true
                PassWord.error = "Fields ini tidak boleh kosong"
            }

            if(!isEmptyFields) {
                statusLogin.text = "Success"
            }

            val user = User(UserName.text.toString(), PassWord.text.toString())
            daoUser.add(user).addOnSuccessListener{
                Toast.makeText(this, "Berhasil tambah user", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(this, it.message.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }
}