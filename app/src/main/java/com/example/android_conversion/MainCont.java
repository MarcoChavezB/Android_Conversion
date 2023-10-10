package com.example.android_conversion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.android_conversion.Models.Celsius;
import com.example.android_conversion.Models.Farenheit;
import com.example.android_conversion.Models.Kelvin;


public class MainCont extends AppCompatActivity {

    TextView Outputcelsius, farenheit, kelvin, modCelsius, modFarenheit, modKelvin;
    EditText inputTemperature;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_cont);

        Outputcelsius = findViewById(R.id.celsius);
        farenheit = findViewById(R.id.farenheit);
        kelvin = findViewById(R.id.kelvin);
        spinner = findViewById(R.id.spinner);
        inputTemperature = findViewById(R.id.inputTemperature);
        modCelsius = findViewById(R.id.modCelsius);
        modFarenheit = findViewById(R.id.modFarenheit);
        modKelvin = findViewById(R.id.modKelvin);


        String[] opciones = {"Celsius", "Farenheit", "Kelvin"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Outputcelsius.setText("");
                farenheit.setText("");
                kelvin.setText("");
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        inputTemperature.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Double valor = Double.parseDouble(inputTemperature.getText().toString());
                convertirValor(valor);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }


    private void convertirValor(Double valor){
        String opcion = spinner.getSelectedItem().toString();
        switch (opcion){
            case "Celsius":
                Celsius celsius = new Celsius(valor);
                Double r1 = celsius.parce(new Farenheit(valor)).getValor();
                farenheit.setText(r1.toString());

                Celsius celsius1 = new Celsius(valor);
                Double r2 = celsius1.parce(new Kelvin(valor)).getValor();
                kelvin.setText(r2.toString());

                Outputcelsius.setText(valor.toString());

                break;
            case "Farenheit":
                Farenheit farenheit1 = new Farenheit(valor);
                Double r3 = farenheit1.parce(new Celsius(valor)).getValor();
                Outputcelsius.setText(r3.toString());

                Farenheit farenheit2 = new Farenheit(valor);
                Double r4 = farenheit2.parce(new Kelvin(valor)).getValor();
                kelvin.setText(r4.toString());

                farenheit.setText(valor.toString());

                break;
            case "Kelvin":
                Kelvin kelvin1 = new Kelvin(valor);
                Double r5 = kelvin1.parce(new Celsius(valor)).getValor();

                Outputcelsius.setText(r5.toString());


                Kelvin kelvin2 = new Kelvin(valor);
                Double r6 = kelvin2.parce(new Farenheit(valor)).getValor();

                farenheit.setText(r6.toString());

                kelvin.setText(valor.toString());

                break;
        }
    }
}