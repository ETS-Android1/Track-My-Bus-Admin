package com.example.trackmybusadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.service.autofill.OnClickAction;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivityBusPart1 extends AppCompatActivity {
    TextInputEditText textfield1;
    TextInputEditText textfield2;
    TextInputEditText textfield3;
    TextInputEditText textfield4;
    TextInputEditText textfield5;
    TextInputEditText textfield6;
    TextInputEditText textfield7;
    TextInputEditText textfield8;
    TextInputEditText textfield9;
//    TextInputEditText textfield10;
//    TextInputEditText textfield11;
    Button clearbtn;
    Button submitbtn;
   FirebaseAuth auth;
   String userId;
   long lat = (long) 30.769758;
   long lon =(long) 76.5755533;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bus_part1);
        auth = FirebaseAuth.getInstance();
        textfield1 = findViewById(R.id.textInput1);
        textfield2 = findViewById(R.id.textInput2);
        textfield3 = findViewById(R.id.textInput3);
        textfield4 = findViewById(R.id.textInput4);
        textfield5 = findViewById(R.id.textInput5);
        textfield6 = findViewById(R.id.textInput6);
        textfield7 = findViewById(R.id.textInput7);
        textfield8 = findViewById(R.id.textInput8);
        textfield9 = findViewById(R.id.textInput9);
//        textfield10 = findViewById(R.id.textInput10);
//        textfield11 = findViewById(R.id.textInput11);
        clearbtn = findViewById(R.id.clear);
        clearbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textfield1.setText("");
                textfield2.setText("");
                textfield3.setText("");
                textfield4.setText("");
                textfield5.setText("");
                textfield6.setText("");
                textfield7.setText("");
                textfield8.setText("");
                textfield9.setText("");
//                textfield10.setText("");
//                textfield11.setText("");
            }
        });
        submitbtn = findViewById(R.id.submit);
        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tf1 = textfield1.getText().toString().trim();
                String tf2 = textfield2.getText().toString().trim();
                String tf3 = textfield3.getText().toString().trim();
                String tf4 = textfield4.getText().toString().trim();
                String tf5 = textfield5.getText().toString().trim();
                String tf6 = textfield6.getText().toString().trim();
                String tf7 = textfield7.getText().toString().trim();
                String tf8 = textfield8.getText().toString().trim();
                String tf9 = textfield9.getText().toString().trim();
//                String tf10 = textfield10.getText().toString();
//                String tf11 = textfield11.getText().toString();
                if (TextUtils.isEmpty(tf1) && TextUtils.isEmpty(tf2) && TextUtils.isEmpty(tf3)
                        && TextUtils.isEmpty(tf4) && TextUtils.isEmpty(tf5) && TextUtils.isEmpty(tf6) &&
                        TextUtils.isEmpty(tf7) && TextUtils.isEmpty(tf8) && TextUtils.isEmpty(tf9)) {
                    Toast.makeText(MainActivityBusPart1.this, "Enter All Details Correctly", Toast.LENGTH_SHORT).show();
                } else {
                    signup(tf1, tf2);

                }

            }
        });
    }

    public void signup(String username, String password) {
      //  username = username + "bus@gmail.com";
        auth.createUserWithEmailAndPassword(username, password).addOnCompleteListener(MainActivityBusPart1.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    pickData();
                } else {
                    Toast.makeText(MainActivityBusPart1.this, "Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void pickData() {
        userId = auth.getCurrentUser().getUid();
        String tf1 = textfield1.getText().toString().trim();
        Long tf2 = Long.parseLong(textfield2.getText().toString().trim());
        Long tf3 = Long.parseLong(textfield3.getText().toString().trim());
        Long tf4 = Long.parseLong(textfield4.getText().toString().trim());
        String tf5 = textfield5.getText().toString().trim();
        Long tf6 = Long.parseLong(textfield6.getText().toString().trim());
        String tf7 = textfield7.getText().toString().trim();
        Long tf8 = Long.parseLong(textfield8.getText().toString().trim());
        Long tf9 = Long.parseLong(textfield9.getText().toString().trim());
//        String tf10 = textfield10.getText().toString();
//        String tf11 = textfield11.getText().toString();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference documentReference = db.collection("Bus_Database").document(userId);
        Map<String, Object> bus_db = new HashMap<>();
        bus_db.put("Email_Id", tf1);
        bus_db.put("Contact_Number", tf2);
        bus_db.put("Bus_Number", tf3);
        bus_db.put("Route_Number", tf4);
        bus_db.put("Bus_City", tf5);
        bus_db.put("Bus_Capacity", tf6);
        bus_db.put("Drivers_Name", tf7);
        bus_db.put("Age", tf8);
        bus_db.put("Address", tf9);
        bus_db.put("Latitude",lat);
       bus_db.put("Longitude",lon);
        documentReference.set(bus_db).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(MainActivityBusPart1.this, "Data Submitted Successfully", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivityBusPart1.this, "Some Error Occurred...", Toast.LENGTH_SHORT).show();
            }
        });
       /* db.collection("Bus_Database").add(bus_db).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });*/
    }

}


//        documentReference.set(bus_db).addOnSuccessListener(new OnSuccessListener<Void>() {
//@Override
//public void onSuccess(Void unused) {
//        Toast.makeText(MainActivityBusPart1.this, "Data Submitted Successfully", Toast.LENGTH_SHORT).show();
//        }
//        }).addOnFailureListener(new OnFailureListener() {
//@Override
//public void onFailure(@NonNull Exception e) {
//        Toast.makeText(MainActivityBusPart1.this, "Some Error Occurred...", Toast.LENGTH_SHORT).show();
//        }
//        });
//       /* db.collection("Bus_Database").add(bus_db).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//            @Override
//            public void onSuccess(DocumentReference documentReference) {
//
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//
//            }
//        });*/
