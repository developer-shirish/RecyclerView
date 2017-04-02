package com.example.shirish.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by shirish on 23/1/16.
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private ArrayList<Movies> movies;

    public MovieAdapter(ArrayList<Movies> moviesArrayList){
        movies = moviesArrayList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView title, genre, year;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            genre = (TextView) itemView.findViewById(R.id.genre);
            year = (TextView) itemView.findViewById(R.id.year);

        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

            Movies mov = movies.get(position);
            holder.title.setText(mov.getTitle());
            holder.genre.setText(mov.getGenre());
            holder.year.setText(mov.getYear());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }


}
