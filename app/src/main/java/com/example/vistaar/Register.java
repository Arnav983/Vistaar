package com.example.vistaar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    private EditText emailET,passET,pass1ET;
    private Button Regi;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        firebaseAuth = FirebaseAuth.getInstance();
        emailET=findViewById(R.id.emailR);

        passET=findViewById(R.id.password);
        pass1ET=findViewById(R.id.password2);
        Regi=findViewById(R.id.Regis);
        progressDialog = new ProgressDialog(this);
        Regi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Registers();
            }
        });
    }
    public void Registers(){
        String emailR = emailET.getText().toString();
        String password = passET.getText().toString();
        String password2 = pass1ET.getText().toString();


        if(TextUtils.isEmpty(emailR)){
            emailET.setError("Enter our email");
            return;
        }
        else if(TextUtils.isEmpty(password)){
            passET.setError("Enter password");
            return;
        }
        else if(TextUtils.isEmpty(password2)){
            pass1ET.setError("Enter ur password again");
            return;
        }
        else if(!password.equals(password2)){
            pass1ET.setError("Different Password");
            return;
        }
        else if(!isValidEmail(emailR)){
            emailET.setError("Invalid email");
            return;
        }
        progressDialog.setMessage("Please Wait..");
        progressDialog.show();
        progressDialog.setCanceledOnTouchOutside(false);
        firebaseAuth.createUserWithEmailAndPassword(emailR,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Register.this,"Successfully registered",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Register.this,Field_select.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(Register.this,"Failed",Toast.LENGTH_LONG).show();
                    progressDialog.dismiss();
                }
            }
        });


    }
    private Boolean isValidEmail(CharSequence target){
        return (!TextUtils.isEmpty(target)&& Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }
}
