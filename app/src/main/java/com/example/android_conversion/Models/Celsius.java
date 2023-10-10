package com.example.android_conversion.Models;

public class Celsius extends Grado{
    public Celsius(Double valor){
        this.setValor(valor);
        this.setUnidad("C");
    }

    public Celsius parce(Farenheit f){
        return new Celsius((f.getValor() - 32) * 5/9);
    }

    public Celsius parce(Kelvin k){
        return new Celsius(k.getValor() - 273.15);
    }

}
