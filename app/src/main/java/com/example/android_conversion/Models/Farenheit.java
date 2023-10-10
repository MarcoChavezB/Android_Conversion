package com.example.android_conversion.Models;

public class Farenheit extends Grado{
    public Farenheit(Double valor){
        this.setValor(valor);
        this.setUnidad("F");
    }

    public Farenheit parce(Celsius c){
        return new Farenheit((c.getValor() * 9/5) + 32);
    }

    public Farenheit parce(Kelvin k){
        return new Farenheit((k.getValor() - 273.15) * 9/5 + 32);
    }


}
