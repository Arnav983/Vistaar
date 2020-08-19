package com.example.vistaar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    private EditText email,pass;
    private Button log1;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        firebaseAuth = FirebaseAuth.getInstance();
        email=findViewById(R.id.email2);

        pass=findViewById(R.id.passR);
        log1=findViewById(R.id.login);
        progressDialog = new ProgressDialog(this);
        log1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logins();
            }
        });
    }
    public void Logins(){
        String emailfr = email.getText().toString();
        String passfr = pass.getText().toString();

        if(TextUtils.isEmpty(emailfr)){
            email.setError("Enter our email");
            return;
        }
        else if(TextUtils.isEmpty(passfr)){
            pass.setError("Enter password");
            return;
        }

        progressDialog.setMessage("Please Wait..");
        progressDialog.show();
        progressDialog.setCanceledOnTouchOutside(false);
        firebaseAuth.signInWithEmailAndPassword(emailfr,passfr).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Login.this,"Logged IN",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Login.this,Field_select.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(Login.this,"Sign IN Failed",Toast.LENGTH_LONG).show();
                    progressDialog.dismiss();
                }
            }
        });


    }

}
