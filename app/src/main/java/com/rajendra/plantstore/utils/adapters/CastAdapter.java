package com.rajendra.plantstore.utils.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.rajendra.plantstore.R;
import com.rajendra.plantstore.utils.models.Cast;

import java.util.List;

public class CastAdapter extends RecyclerView.Adapter<CastAdapter.CastViewHolder> {

    Context context ;
    List<Cast> mData;
    MovieItemClickListener movieItemClickListener;

    public CastAdapter(Context context, List<Cast> mData) {
        this.context = context;
        this.mData = mData;
      //  movieItemClickListener = listener;
    }


   /* public CastAdapter(MovieDetailActivity movieDetailActivity, List<Cast> mData, Context context) {
        this.context = context;
        this.mData = mData;
    }*/


    @NonNull
    @Override
    public CastViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        View view = LayoutInflater.from(context).inflate(R.layout.item_cast,viewGroup,false);
        return new CastViewHolder(view);


        }

    @Override
    public void onBindViewHolder(@NonNull CastViewHolder castViewHolder, int i) {

        Glide.with(context).load(mData.get(i).getImg_link()).into(castViewHolder.img);



    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class CastViewHolder extends RecyclerView.ViewHolder {



        private ImageView img;


        public CastViewHolder(@NonNull View itemView) {

            super(itemView);
            img = itemView.findViewById(R.id.img_cast);

          /*  itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    movieItemClickListener.onMovieClick(mData.get(getAdapterPosition()),ImgMovie);


                }
            });*/

        }
    }
}
