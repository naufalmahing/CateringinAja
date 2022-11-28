package com.example.sistemlogin

import android.os.Bundle
import android.os.PersistableBundle
import android.service.controls.Control
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class HPencarian: Fragment() {

//    private lateinit var controlMasakan: ControlMasakan

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.w("pencarian", "hpencarian")

        val displayView = inflater.inflate(R.layout.frag_search, container, false)

        val args = this.arguments

//        controlMasakan = ControlMasakan(displayView.context)

        val res = args?.getString("SEARCH")

//        if (res != null) {
//            Log.v("pencarian", res)
//
//            val listMasakan = controlMasakan.search("ay")
//
//            var list = ""
//            if (listMasakan != null) {
//                for (item in listMasakan) {
//                    list += item.getNama() + "\n"
//                }
//            }
//
//            displayView.findViewById<TextView>(R.id.textView).text = list
//        }
        return displayView
    }
}