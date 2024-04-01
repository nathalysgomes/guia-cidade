package com.example.guiacidadesorocaba;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button btnSaibaMaisInazuma;
    private Button btnSaibaMaisOutback;
    private Button btnSaibaMaisKibeHassib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnSaibaMaisInazuma=findViewById(R.id.btnSaibaMaisInazuma);
        btnSaibaMaisOutback=findViewById(R.id.btnSaibaMaisOutback);
        btnSaibaMaisKibeHassib=findViewById(R.id.btnKibeHassib);

        btnSaibaMaisInazuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GuiaInazuma.class);
                startActivity(intent);
            }
        });

        btnSaibaMaisOutback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GuiaOutback.class);
                startActivity(intent);
            }
        });

        btnSaibaMaisKibeHassib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GuiaHassib.class);
                startActivity(intent);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.txtGuiaCidade), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}