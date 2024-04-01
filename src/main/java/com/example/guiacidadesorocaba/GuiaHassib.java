package com.example.guiacidadesorocaba;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GuiaHassib extends AppCompatActivity {
    private Button btnMapaHassib;
    private Button btnSiteHassib;
    private Button btnLigacaoHassib;
    private Button btnVoltarHassib;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_guia_hassib);
        btnMapaHassib=findViewById(R.id.btnMapaHassib);
        btnSiteHassib=findViewById(R.id.btnSiteHassib);
        btnLigacaoHassib=findViewById(R.id.btnLigarHassib);
        btnVoltarHassib=findViewById(R.id.btnVoltarHassib);

        btnMapaHassib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=Restaurante Kibe do Hassib, Sorocaba");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                startActivity(Intent.createChooser(mapIntent, "Escolha um aplicativo de mapa"));
            }
        });

        btnSiteHassib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://kibedohassib.com.br/"));
                startActivity(Intent.createChooser(intent, "Escolha um navegador"));
            }
        });

        btnLigacaoHassib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "551533218778"));
                startActivity(Intent.createChooser(intent, "Escolha um aplicativo de chamada"));
            }
        });

        btnVoltarHassib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GuiaHassib.this, MainActivity.class);
                startActivity(intent);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}