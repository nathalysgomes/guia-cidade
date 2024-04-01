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

public class GuiaInazuma extends AppCompatActivity {
    private Button btnMapaInazuma;
    private Button btnSiteInazuma;
    private Button btnLigacaoInazuma;
    private Button btnVoltarInazuma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_guia_inazuma);

        btnMapaInazuma=findViewById(R.id.btnMapaInazuma);
        btnSiteInazuma=findViewById(R.id.btnSiteInazuma);
        btnLigacaoInazuma=findViewById(R.id.btnLigacaoInazuma);
        btnVoltarInazuma=findViewById(R.id.btnVoltarInazuma);

        btnMapaInazuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=Restaurante Inazuma, Sorocaba");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                startActivity(Intent.createChooser(mapIntent, "Escolha um aplicativo de mapa"));
            }
        });

        btnSiteInazuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/inazuma.sorocaba/"));
                startActivity(Intent.createChooser(intent, "Escolha um navegador"));
            }
        });

        btnLigacaoInazuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "551533594693"));
                startActivity(Intent.createChooser(intent, "Escolha um aplicativo de chamada"));
            }
        });

        btnVoltarInazuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GuiaInazuma.this, MainActivity.class);
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