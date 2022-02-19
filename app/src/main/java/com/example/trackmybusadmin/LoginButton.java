package com.example.trackmybusadmin;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginButton {


    private CardView cardView;
    private ConstraintLayout layout;
    private TextView textView;
    private ProgressBar progressBar;


    LoginButton( View view){
        cardView = view.findViewById(R.id.logincard);
        layout = view.findViewById(R.id.loginconstraint);
        textView = view.findViewById(R.id.logintext);
        progressBar = view.findViewById(R.id.loginprogressBar);


    }

    void buttonActivated(){
        progressBar.setVisibility(View.VISIBLE);
        textView.setText("LOADING...");
    }

    void buttonTerminatedsucces(){
        layout.setBackgroundColor(cardView.getResources().getColor(R.color.greenforsuccess));
        progressBar.setVisibility(View.GONE);
        textView.setText("SUCCESS");
    }
    void buttonTerminatedfail(){
        layout.setBackgroundColor(cardView.getResources().getColor(R.color.redforfail));
        progressBar.setVisibility(View.GONE);
        textView.setText("FAILED");
    }
}








