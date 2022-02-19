package com.example.trackmybusadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    View view;
    private boolean checktask;
    public TextInputEditText username;
    public TextInputEditText password;
    public String inputedusername;
    public String inputedpassword;
    private FirebaseAuth auth;
    TextView forgotpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        forgotpassword = (TextView) findViewById(R.id.forgotpassword);
       view = findViewById(R.id.loginButton);
       username = findViewById(R.id.inputadminusername);
        password = findViewById(R.id.inputadminpassword);
        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Frgt_Pass.class);
                startActivity(intent);
            }
            });
       auth = FirebaseAuth.getInstance();
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginButton loginbtn = new LoginButton(view);
                inputedusername = username.getText().toString();
                inputedpassword = password.getText().toString();
                if(TextUtils.isEmpty(inputedusername) || (TextUtils.isEmpty(inputedpassword)))
                {
                    Toast.makeText(MainActivity.this, "USERNAME or PASSWORD can't be empty", Toast.LENGTH_SHORT).show();
                }
                else {
                    loginbtn.buttonActivated();
                    singin(inputedusername,inputedpassword);
                    Handler handle = new Handler();
                    handle.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if(checktask==true) {
                                loginbtn.buttonTerminatedsucces();
                                Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                                startActivity(intent);
                                finish();
                            }
                            else {
                                loginbtn.buttonTerminatedfail();
                                handle.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        finish();
                                        overridePendingTransition(0, 0);
                                        startActivity(getIntent());
                                        overridePendingTransition(0, 0);
                                    }
                                },1000);

                            }
                        }
                    }, 2000);
                }
            }
        });
    }
    private void singin(String username, String password){
        //username=inputedusername+"@gmail.com";
        auth.signInWithEmailAndPassword(username,password).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                    checktask=true;
                else
                    checktask=false;
            }
        });
    }
}