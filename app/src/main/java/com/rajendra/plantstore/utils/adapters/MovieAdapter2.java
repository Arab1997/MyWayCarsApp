package com.rajendra.plantstore.utils.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rajendra.plantstore.R;
import com.rajendra.plantstore.utils.models.Movie;

import java.util.List;

public class MovieAdapter2 extends RecyclerView.Adapter<MovieAdapter2.MyViewHolder> {

   private Context context ;
    private  List<Movie> mData;
    private  CarsItemClickListener carsItemClickListener;


    public MovieAdapter2(Context context, List<Movie> mData, CarsItemClickListener listener) {
        this.context = context;
        this.mData = mData;
        carsItemClickListener = listener;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        View view = LayoutInflater.from(context).inflate(R.layout.item_movie2,viewGroup,false);
        return new MyViewHolder(view);


        }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {


        myViewHolder.TvTitle.setText(mData.get(i).getTitle());
        myViewHolder.ImgMovie.setImageResource(mData.get(i).getThumbnail());


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {


        private TextView TvTitle;
        private ImageView ImgMovie;


        MyViewHolder(@NonNull View itemView) {

            super(itemView);
            TvTitle = itemView.findViewById(R.id.item_movie_title);
            ImgMovie = itemView.findViewById(R.id.item_movie_img);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    carsItemClickListener.onMovieClick(mData.get(getAdapterPosition()),ImgMovie);

                }
            });
        }
    }
}
