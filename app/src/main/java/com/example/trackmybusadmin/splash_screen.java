package com.example.trackmybusadmin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class splash_screen extends AppCompatActivity {
//TextView txwel;
TextView txtmb;
Animation anim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FIRST_APPLICATION_WINDOW);
        setContentView(R.layout.activity_splash_screen);

//txwel = findViewById(R.id.textViewwel);
txtmb = findViewById(R.id.textViewtmb);
new Handler().postDelayed(new Runnable() {
    @Override
    public void run() {
        Intent loginscrn = new Intent(splash_screen.this,MainActivity.class);
        startActivity(loginscrn);
        finish();
    }
} ,3000);
Animation myanim = AnimationUtils.loadAnimation(splash_screen.this,R.anim.animsplsh);
//txtmb.startAnimation(myanim);
//txwel.startAnimation(myanim);
    }
}