package com.example.trackmybusadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class MainActivity3BusPart2 extends AppCompatActivity {
    Button clearbtns;
    Button submitbtns;
    TextInputEditText textfield1;
    TextInputEditText textfield2;
    TextInputEditText textfield3;
    TextInputEditText textfield4;
    TextInputEditText textfield5;
    TextInputEditText textfield6;
    TextInputEditText textfield7;
//    TextInputEditText textfield8;
//    TextInputEditText textfield9;
//    TextInputEditText textfield10;
    TextInputEditText textfield11;
    TextInputEditText textfield12;
    boolean check;
    FirebaseAuth auth;
    String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity3_bus_part2);
        auth = FirebaseAuth.getInstance();

        textfield1 = findViewById(R.id.textInput1s);
        textfield2 = findViewById(R.id.textInput2s);
        textfield3 = findViewById(R.id.textInput3s);
        textfield4 = findViewById(R.id.textInput4s);
        textfield5 = findViewById(R.id.textInput5s);
        textfield6 = findViewById(R.id.textInput6s);
        textfield7 = findViewById(R.id.textInput7s);
//        textfield8 = findViewById(R.id.textInput8s);
//        textfield9 = findViewById(R.id.textInput9s);
//        textfield10 = findViewById(R.id.textInput10s);
        textfield11 = findViewById(R.id.textInput11s);
        textfield12 = findViewById(R.id.textInput12s);
        clearbtns = findViewById(R.id.clears);
        submitbtns = findViewById(R.id.submits);
        clearbtns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textfield1.setText("");
                textfield2.setText("");
                textfield3.setText("");
                textfield4.setText("");
                textfield5.setText("");
                textfield6.setText("");
                textfield7.setText("");
//                textfield8.setText("");
//                textfield9.setText("");
//                textfield10.setText("");
                textfield11.setText("");
                textfield12.setText("");

            }
        });
        submitbtns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tf1 = textfield1.getText().toString().trim();
                String tf2 = textfield2.getText().toString().trim();
                String tf3 = textfield3.getText().toString().trim();
                String tf4 = textfield4.getText().toString().trim();
                String tf5 = textfield5.getText().toString().trim();
                String tf6 = textfield6.getText().toString().trim();
                String tf7 = textfield7.getText().toString().trim();
//                String tf8 = textfield8.getText().toString();
//                String tf9 = textfield9.getText().toString();
//                String tf10 = textfield10.getText().toString();
                String tf11 = textfield11.getText().toString().trim();
                String tf12 = textfield12.getText().toString().trim();
                if (TextUtils.isEmpty(tf1) && TextUtils.isEmpty(tf2) && TextUtils.isEmpty(tf3)
                        && TextUtils.isEmpty(tf4) && TextUtils.isEmpty(tf5) && TextUtils.isEmpty(tf6) &&
                        TextUtils.isEmpty(tf7)  && TextUtils.isEmpty(tf11) && TextUtils.isEmpty(tf12)) {
                    Toast.makeText(MainActivity3BusPart2.this, "Enter All Details Correctly", Toast.LENGTH_SHORT).show();
                } else {
                    signup(tf1, tf2);
                }
            }
        });

    }

    private void signup(String username, String password) {
//        username = username + "st@gmail.com";
        auth.createUserWithEmailAndPassword(username, password).addOnCompleteListener(MainActivity3BusPart2.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    pickData();
                } else {
                    Toast.makeText(MainActivity3BusPart2.this, "Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void pickData() {
        userId = auth.getCurrentUser().getUid();
        String tf1 = textfield1.getText().toString().trim();
        Long tf2 = Long.parseLong(textfield2.getText().toString().trim());
        String tf3 = textfield3.getText().toString().trim();
        String tf4 = textfield4.getText().toString().trim();
        String tf5 = textfield5.getText().toString().trim();
        String tf6 = textfield6.getText().toString().trim();
        String tf7 = textfield7.getText().toString().trim();
//        String tf8 = textfield8.getText().toString();
//        String tf9 = textfield9.getText().toString();
//        String tf10 = textfield10.getText().toString();
        String tf11 = textfield11.getText().toString().trim();
        Long tf12 = Long.parseLong(textfield12.getText().toString().trim());
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference documentReference = db.collection("Student_Database").document(userId);
        Map<String, Object> student_db = new HashMap<>();
        student_db.put("Email_id", tf1);
//        student_db.put("Password", tf2);
        student_db.put("Name", tf3);
        student_db.put("Uid", tf4);
        student_db.put("Course", tf5);
        student_db.put("Branch", tf6);
        student_db.put("Semester", tf7);
      student_db.put("Contact_Number", tf2);
//        student_db.put("Email_Id", tf9);
//        student_db.put("Date_Of_Birth", tf10);
        student_db.put("Address", tf11);
        student_db.put("Route_Number", tf12);
        documentReference.set(student_db).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(MainActivity3BusPart2.this, "Data Submitted Successfully..", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity3BusPart2.this, "Some Error Occurred...", Toast.LENGTH_SHORT).show();
            }
        });
       /* db.collection("Student_D").add(student_db).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(MainActivity3BusPart2.this, "Data Submitted Successfully..", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity3BusPart2.this, "Some Error Occurred...", Toast.LENGTH_SHORT).show();
            }
        });*/
    }
}