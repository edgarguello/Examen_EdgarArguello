package com.roshka.examen0

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_show_weather.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class showWeatherActivity : AppCompatActivity() {
    var ciudad = Ciudad()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_weather)
        callServiceGetUser()//en este apartado se realiza el llamado a la funcion que consume la API
                            //es el apartado que no funciona ya que la API no me esta retornando valores
                            //o no se esta realizando de la manera correcta
        val Bundle = intent.extras
        ciudad.setNombreCiudad(Bundle?.get("INTENT_NAME").toString())
        tvNombreCiudad.text=ciudad.getNombreCiudad()
        tvTemp.text="${ciudad.getTemperatura()}${ciudad.getUnidadChar()}"
        tvTempMax.text="${ciudad.getTempMaxima()}${ciudad.getUnidadChar()}"
        tvTempMin.text="${ciudad.getTempMinima()}${ciudad.getUnidadChar()}"
        tvSensacion.text="${ciudad.getSensacion()}${ciudad.getUnidadChar()}"

        btnCelcius.setOnClickListener{
            actualizarDatos(ciudad,ciudad.getUnidadMedida(),"Celcius")
        }
        btnFarenheit.setOnClickListener{
            actualizarDatos(ciudad,ciudad.getUnidadMedida(),"Farenheit")
        }
        btnKelvin.setOnClickListener{
            actualizarDatos(ciudad,ciudad.getUnidadMedida(),"Kelvin")
        }
        btnVolver.setOnClickListener{onBackPressed()}

    }

    private fun callServiceGetUser() {
        val userService:userService = restEngine.getRestEngine().create(userService::class.java)
        val result: Call<List<UserDataCollectionItem>> = userService.listUsers()
        result.enqueue(object : Callback<List<UserDataCollectionItem>>{
            override fun onFailure(call: Call<List<UserDataCollectionItem>>, t: Throwable) {
                Toast.makeText(this@showWeatherActivity,"Error en la llamada a la API",Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<List<UserDataCollectionItem>>, response: Response<List<UserDataCollectionItem>>) {
                Toast.makeText(this@showWeatherActivity,"OK",Toast.LENGTH_LONG).show()
            }
        })

    }
    private fun actualizarDatos(ciudad:Ciudad,origen:String,destino:String){
        if(origen==destino){
            Toast.makeText(this,"El dato ya está en $origen",Toast.LENGTH_LONG).show()
            return
        }else{
            if(destino=="Celcius"){
                ciudad.setUnidadMedida("Celcius")
                ciudad.setUnidadChar("ºC")
            }else if(destino=="Kelvin"){
                ciudad.setUnidadMedida("Kelvin")
                ciudad.setUnidadChar("K")
            }else{
                ciudad.setUnidadMedida("Farenheit")
                ciudad.setUnidadChar("ºF")
            }
            ciudad.convertirTemperatura(origen,destino)
        }
        tvNombreCiudad.text=ciudad.getNombreCiudad()
        tvTemp.text="${ciudad.getTemperatura()}${ciudad.getUnidadChar()}"
        tvTempMax.text="${ciudad.getTempMaxima()}${ciudad.getUnidadChar()}"
        tvTempMin.text="${ciudad.getTempMinima()}${ciudad.getUnidadChar()}"
        tvSensacion.text="${ciudad.getSensacion()}${ciudad.getUnidadChar()}"
    }
}