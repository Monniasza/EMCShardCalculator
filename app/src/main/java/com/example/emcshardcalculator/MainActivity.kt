package com.example.emcshardcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var number = findViewById<EditText>(R.id.emc)
        var splinters = findViewById<TextView>(R.id.splinter)
        var shards = findViewById<TextView>(R.id.shard)
        var xtals = findViewById<TextView>(R.id.xtal)
        var denses = findViewById<TextView>(R.id.dense)
        var superd = findViewById<TextView>(R.id.superDense)

        number.addTextChangedListener {
            var text = number.text.toString()
            var value = 0L
            try{
                value = text.toLong()
            }catch(e: Exception){}

            splinters.text = (value and 63L).toString()
            shards.text = ((value.shr(6)) and 63L).toString()
            xtals.text = ((value.shr(12)) and 63L).toString()
            denses.text = ((value.shr(18)) and 63L).toString()
            superd.text = ((value.shr(24))).toString()
        }
    }
}