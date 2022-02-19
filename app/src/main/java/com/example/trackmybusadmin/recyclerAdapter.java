package com.example.trackmybusadmin;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.MyViewHolder> {
    String data1[],data2[],data3[];
    int img[];
    Context context;
    public recyclerAdapter(Context ct, String title[],String description[],String count[], int imageicons[]){
    data1=title;
    data2=description;
    data3=count;
    img=imageicons;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.additembutton,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.text1.setText(data1[position]);
        holder.text2.setText(data2[position]);
        holder.text3.setText(data3[position]);
        holder.img1.setImageResource(img[position]);
        holder.mainlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Intent it = new Intent(, MainActivityBusPart1.class);

            }
        });

    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView text1,text2,text3;
        ImageView img1;
        ConstraintLayout mainlayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text1 = itemView.findViewById(R.id.textViewtitle);
            text2 = itemView.findViewById(R.id.textViewdescription);
            text3 = itemView.findViewById(R.id.textViewCount);
            img1 = itemView.findViewById(R.id.imageView);
            mainlayout = itemView.findViewById(R.id.mainconstrain);
        }
    }
}
