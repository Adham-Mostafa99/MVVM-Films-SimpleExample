package com.example.mvvmtraining.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mvvmtraining.R;
import com.example.mvvmtraining.models.FilmsData;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<FilmsData> filmsList = new ArrayList<>();
    Context context;

    public RecyclerAdapter(Context context, List<FilmsData> filmsList) {
        this.context = context;
        this.filmsList = filmsList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.film_item_recycleview, parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder) holder).filmName.setText(filmsList.get(position).getFilmName());

        RequestOptions defaultRequest = new RequestOptions().error(R.drawable.ic_launcher_background);

        Glide
                .with(context)
                .applyDefaultRequestOptions(defaultRequest)
                .load(filmsList.get(position).getFilmUrl())
                .into(((ViewHolder) holder).filmImageView);
    }

    @Override
    public int getItemCount() {
        return filmsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView filmImageView;
        TextView filmName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            filmImageView = itemView.findViewById(R.id.film_image);
            filmName = itemView.findViewById(R.id.film_name);
        }
    }
}
