package com.example.trackmybusadmin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity2 extends AppCompatActivity {
    String title[],description[],count[];
    int imageicons[] = {R.drawable.bus,R.drawable.student,R.drawable.bus,R.drawable.student};
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        title = getResources().getStringArray(R.array.Title);
        description = getResources().getStringArray(R.array.Description);
        count = getResources().getStringArray(R.array.Count);
        recyclerView = findViewById(R.id.recycleview);

        recyclerAdapter ra = new recyclerAdapter(this, title, description,count,imageicons);
        recyclerView.setAdapter(ra);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
}