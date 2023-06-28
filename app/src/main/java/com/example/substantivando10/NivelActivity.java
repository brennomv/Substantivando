package com.example.substantivando10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NivelActivity extends AppCompatActivity {

    Button btnProximoNivel01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel);

        btnProximoNivel01 = (Button) findViewById(R.id.btnProximoNivel01);

        btnProximoNivel01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NivelActivity.this, ActivityExplica01.class);
                startActivity(intent);
            }
        });
    }
}