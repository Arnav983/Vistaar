package com.example.vistaar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Field_select extends AppCompatActivity {
    private Button logout,Fbut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_field_select);
        Fbut=findViewById(R.id.Farm);
        Fbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFarm();
            }
        });
        logout=findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(Field_select.this,Login.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public void openFarm(){
        Intent intent = new Intent(this,Farmer1.class);
        startActivity(intent);
    }
}
