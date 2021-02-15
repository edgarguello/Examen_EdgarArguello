package com.roshka.examen0

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = Intent(this,showWeatherActivity::class.java)
        btnAsu.setOnClickListener{
            intent.putExtra("INTENT_NAME","Asuncion")
            startActivity(intent)
        }
        btnCiudadDelEste.setOnClickListener{
            intent.putExtra("INTENT_NAME","Ciudad Del Este")
            startActivity(intent)
        }
        btnEncarnacion.setOnClickListener{
            intent.putExtra("INTENT_NAME","Encarnacion")
            startActivity(intent)
        }
        btnLomaPlata.setOnClickListener{
            intent.putExtra("INTENT_NAME","Loma Plata")
            startActivity(intent)
        }
        btnVillarrica.setOnClickListener{
            intent.putExtra("INTENT_NAME","Villarrica")
            startActivity(intent)
        }
    }
}