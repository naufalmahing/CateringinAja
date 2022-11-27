
package com.example.sistemlogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class HLogin : AppCompatActivity(), View.OnClickListener {
    private lateinit var UserName : EditText
    private lateinit var PassWord : EditText
    private lateinit var buttonLogin : Button
    private lateinit var statusLogin : TextView
    private val controlUser = ControlUser(this)

    companion object {
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        UserName = findViewById(R.id.username_field)
        PassWord = findViewById(R.id.password_fields)
        buttonLogin = findViewById(R.id.btnLogin)
        statusLogin = findViewById(R.id.result_data)

        buttonLogin.setOnClickListener(this)

        if(savedInstanceState != null) {
            val result = savedInstanceState.getString(STATE_RESULT)
            statusLogin.text = result
        }

        findViewById<TextView>(R.id.textView).setOnClickListener {
            startActivity(Intent(this, HRegister::class.java))
        }

    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putString(STATE_RESULT, statusLogin.text.toString())
    }

    override fun onClick(p0: View?) {
        if(p0?.id == R.id.btnLogin) {
            if(!validasi()) {
                controlUser.login(UserName.text.toString(), PassWord.text.toString())
            }
        }
    }

    fun validasi(): Boolean {
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

        return isEmptyFields
    }
}