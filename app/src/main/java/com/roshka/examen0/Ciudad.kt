package com.roshka.examen0

class Ciudad {
    private var nombreCiudad :String=""
    private var temperatura:Double = 25.0
    private var tempMinima: Double=25.0
    private var tempMaxima :Double=25.0
    private var sensacionTerm :Double =25.0
    private var unidadMedida:String="Celcius"
    private var unidadChar : String ="ºC"

    //funciones Get
    fun getNombreCiudad(): String{
        return this.nombreCiudad
    }
    fun getTemperatura(): Double{
        return this.temperatura
    }

    fun getTempMinima(): Double{
        return this.tempMinima
    }
    fun getTempMaxima(): Double{
        return this.tempMaxima
    }
    fun getSensacion(): Double{
        return this.sensacionTerm
    }
    fun getUnidadMedida(): String{
        return this.unidadMedida
    }
    fun getUnidadChar(): String{
        return this.unidadChar
    }

    //funciones set
    fun setNombreCiudad(nombreCiudad:String){
        this.nombreCiudad=nombreCiudad
    }
    fun setTemperatura(temperatura:Double){
        this.temperatura=temperatura
    }
    fun setTempMaxima(tempMaxima:Double){
        this.tempMaxima=tempMaxima
    }
    fun setTempMinima(tempMinima:Double){
        this.tempMinima=tempMinima
    }
    fun setSensacion(sensacionTerm:Double){
        this.sensacionTerm=sensacionTerm
    }
    fun setUnidadMedida(unidadMedida:String){
        this.unidadMedida=unidadMedida
    }
    fun setUnidadChar(unidadChar:String){
        this.unidadChar=unidadChar
    }

    //metodos complementarios
    fun convertirTemperatura(origen:String,destino:String){
        if(origen!="Celcius") pasarCelcius(origen)
        if(destino=="Kelvin"){
            temperatura+=273.15
            tempMinima+=273.15
            tempMaxima+=273.15
            sensacionTerm+=273.15
        }else if(destino=="Farenheit"){
            temperatura=((temperatura*9)/5)+32
            tempMinima=((tempMinima*9)/5)+32
            tempMaxima=((tempMaxima*9)/5)+32
            sensacionTerm=((sensacionTerm*9)/5)+32
        }
    }
    fun pasarCelcius(origen:String){
        if(origen=="Kelvin"){
            temperatura-=273.15
            tempMinima-=273.15
            tempMaxima-=273.15
            sensacionTerm-=273.15
        }else{
            temperatura=((temperatura-32)*5)/9
            tempMinima=((tempMinima-32)*5)/9
            tempMaxima=((tempMaxima-32)*5)/9
            sensacionTerm=((sensacionTerm-32)*5)/9
        }
    }

}