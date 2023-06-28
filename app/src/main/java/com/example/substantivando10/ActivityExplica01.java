package com.example.substantivando10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityExplica01 extends AppCompatActivity {

    Button btnProximoExplica01;
    TextView txtViewExplica01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explica01);txtViewExplica01 = (TextView) findViewById(R.id.txtViewExplica01);

        btnProximoExplica01 = (Button) findViewById(R.id.btnProximoExplica01);

        btnProximoExplica01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityExplica01.this, DashboardActivity.class);
                startActivity(intent);
            }
        });
    }
}