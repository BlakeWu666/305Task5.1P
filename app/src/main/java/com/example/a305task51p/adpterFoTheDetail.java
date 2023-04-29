package com.example.a305task51p;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adpterFoTheDetail extends RecyclerView.Adapter<adpterFoTheDetail.viewHolder>{
    private Context context;
    private List<detailModel> detailList;

    public adpterFoTheDetail(Context context, List<detailModel> detailList) {
        this.context = context;
        this.detailList = detailList;
    }

    @NonNull
    @Override
    public adpterFoTheDetail.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.news_layout, parent,false);
        return new adpterFoTheDetail.viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull adpterFoTheDetail.viewHolder holder, int position) {
        holder.news.setText(detailList.get(position).getName());
        holder.description.setText(detailList.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return detailList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        TextView news, description;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            news = itemView.findViewById(R.id.news);
            description = itemView.findViewById(R.id.description);
        }
    }
}
