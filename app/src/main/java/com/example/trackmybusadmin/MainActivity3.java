package com.example.trackmybusadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity3 extends AppCompatActivity {
    CardView cv1;
    CardView cv2;
    CardView cv3;
    CardView cv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
//        cv1 = findViewById(R.id.cardView1);
//        cv2 = findViewById(R.id.cardView2);
//        cv3 = findViewById(R.id.cardView3);
//        cv4 = findViewById(R.id.cardView4);
     /* cv1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent addbus = new Intent(MainActivity3.this, MainActivityBusPart1.class);
              startActivity(addbus);
          }
      });
      cv2.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent addstudent = new Intent(MainActivity3.this,MainActivity3BusPart2.class);
              startActivity(addstudent);
          }
      });
      cv3.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Toast.makeText(MainActivity3.this, "Will Be Available Soon", Toast.LENGTH_SHORT).show();
          }
      });
      cv4.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Toast.makeText(MainActivity3.this, "Will Be Available Soon", Toast.LENGTH_SHORT).show();
          }
      });*/
        BottomNavigationView btmNav;
      btmNav = findViewById(R.id.btmnav);
      btmNav.setOnNavigationItemSelectedListener((navListner));
      getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new FirstFragment()).commit();
        btmNav.getMenu().findItem(R.id.navhome).setChecked(true);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListner = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()){
                case R.id.navhome:
                    selectedFragment = new FirstFragment();
                    break;
                case R.id.navadmin:
                    selectedFragment = new SecondFragment();
                    break;
//                case R.id.navmap:
//                    selectedFragment = new ThirdFragment();
//                    break;
                case R.id.navinstruction:
                    selectedFragment = new ForthFragment();
                    break;
//                case R.id.navinfo:
//                    selectedFragment = new FifthFragment();
//                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
            return true;
        }
    };
}