package com.example.android_conversion;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CountDownTimer timeout;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.cont2);


        timeout = new CountDownTimer(5000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                textView.setText(String.valueOf(millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(MainActivity.this, MainCont.class);
                startActivity(intent);
            }
        };

        startTimeout();

    }

    public void startTimeout() {
        timeout.start();
    }

    public void cancelTimeout() {
        timeout.cancel();
    }
}
