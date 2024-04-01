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

public class GuiaOutback extends AppCompatActivity {
    private Button btnMapaOutback;
    private Button btnSiteOutback;
    private Button btnLigacaoOutback;
    private Button btnVoltarOutback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_guia_outback);

        btnMapaOutback=findViewById(R.id.btnMapaOutback);
        btnSiteOutback=findViewById(R.id.btnSiteOutback);
        btnLigacaoOutback=findViewById(R.id.btnLigarOutback);
        btnVoltarOutback=findViewById(R.id.btnVoltarOutback);

        btnMapaOutback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=Restaurante Outback Iguatemi, Sorocaba");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                startActivity(Intent.createChooser(mapIntent, "Escolha um aplicativo de mapa"));
            }
        });

        btnSiteOutback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.outback.com.br/"));
                startActivity(Intent.createChooser(intent, "Escolha um navegador"));
            }
        });

        btnLigacaoOutback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "551532473497"));
                startActivity(Intent.createChooser(intent, "Escolha um aplicativo de chamada"));
            }
        });

        btnVoltarOutback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GuiaOutback.this, MainActivity.class);
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