package com.example.a305task51p;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context context;
    private List<newsModel> newsList;

    private ItemClickListener clickListener;

    public interface  ItemClickListener {
        public void onItemClick (newsModel model);
    }

    public MyAdapter(List<newsModel> newsList, ItemClickListener clickListener) {
        this.newsList = newsList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.recycler_view, parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.image1.setImageResource(newsList.get(position).getImage());
        holder.image2.setImageResource(newsList.get(position).getImage());
        holder.image3.setImageResource(newsList.get(position).getImage());
        holder.image4.setImageResource(newsList.get(position).getImage());
        holder.image5.setImageResource(newsList.get(position).getImage());
        holder.image6.setImageResource(newsList.get(position).getImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClick(newsList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView image1, image2,image3,image4,image5,image6;
        View divider;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            image1 = itemView.findViewById(R.id.imageA);
            image2 = itemView.findViewById(R.id.imageB);
            image3 = itemView.findViewById(R.id.imageC);
            image4 = itemView.findViewById(R.id.imageD);
            image5 = itemView.findViewById(R.id.imageE);
            image6 = itemView.findViewById(R.id.imageF);
            divider = itemView.findViewById(R.id.divider);

        }
    }
}

