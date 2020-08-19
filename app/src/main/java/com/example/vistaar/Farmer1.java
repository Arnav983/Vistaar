package com.example.vistaar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Farmer1 extends AppCompatActivity {
    private Button Fup,Fsea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer1);
        Fup=findViewById(R.id.Farmerupload);
        Fsea=findViewById(R.id.farmersearch);
        Fup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fupp();
            }
        });
        Fsea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fseac();
            }
        });
    }
    public  void  Fupp(){
        Intent intent = new Intent(this,farmer_upload.class);
        startActivity(intent);

    }
    public  void  Fseac(){
        Intent intent = new Intent(this,farmer_search.class);
        startActivity(intent);

    }
}
