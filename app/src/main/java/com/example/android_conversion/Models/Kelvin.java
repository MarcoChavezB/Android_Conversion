package com.example.android_conversion.Models;

public class Kelvin extends Grado{

    public Kelvin(Double valor){
        this.setValor(valor);
        this.setUnidad("K");
    }
    public Kelvin parce(Celsius c){
        return new Kelvin(c.getValor() + 273.15);
    }

    public Kelvin parce(Farenheit f){
        return new Kelvin((f.getValor() - 32) * 5/9 + 273.15);
    }
}
