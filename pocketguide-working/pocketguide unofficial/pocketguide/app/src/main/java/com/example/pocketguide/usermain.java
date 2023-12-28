package com.example.pocketguide;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class usermain extends AppCompatActivity {

    private Button scanQRBtn;
    private Button location;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usermain);

        scanQRBtn = findViewById(R.id.scanbtn);
        scanQRBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(usermain.this,QR_scanner.class);
                startActivity(i);
            }
        });

        location = findViewById(R.id.track);
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(usermain.this,getUserLocation.class);
                startActivity(i);
            }
        });
    }
}