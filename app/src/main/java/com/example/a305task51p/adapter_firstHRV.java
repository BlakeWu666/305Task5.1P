package com.example.a305task51p;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapter_firstHRV extends  RecyclerView.Adapter<adapter_firstHRV.adapterViewHolder> {

    Context context;
    ArrayList<newsModel> newsArrayList;

    //We use an itemOnclickListener to accomplish the event handling that is onClick
    ItemClickListener itemClickListener;
    public adapter_firstHRV(Context context, ArrayList<newsModel> newsArrayList, ItemClickListener itemClickListener) {

        // we need to set the context, which means where we gonna use the adapter
        this.context = context;

        // we create a simple arrayList instance to fill in the recyclerView with the list
        this.newsArrayList = newsArrayList;

        // we have our itemClickListener as well
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public adapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Fill in a single recyclerView model for each holder
        View v = LayoutInflater.from(context).inflate(R.layout.recycler_view,parent,false);

        return new adapterViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull adapterViewHolder holder, @SuppressLint("RecyclerView") int position) {

        //Create a new arrayList for the recycler view
        newsModel news = newsArrayList.get(position);

        //we set the text and images for the holder in the recyclerView
        holder.textView.setText(news.news);
        holder.imageView.setImageResource(news.image);

        //set the itemOnClickListener, if someone click an item, firstly we get the position that is the index of the item
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClick(newsArrayList.get(position));
            }
        });
    }

    // we create a simple interface to re-use the itemOnClickListener
    public interface  ItemClickListener{
        public void onItemClick(newsModel newsModel);
    }

    @Override
    public int getItemCount() {
        return newsArrayList.size();
    }

    public static class adapterViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;

        public adapterViewHolder(@NonNull View itemView) {
            super(itemView);

            //We have our old friends, references to control the single model of a holder
            imageView = itemView.findViewById(R.id.item_image);
            textView = itemView.findViewById(R.id.item_news);
        }
    }
}
