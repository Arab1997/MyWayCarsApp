package com.rajendra.plantstore.utils.adapters;

import android.widget.ImageView;

import com.rajendra.plantstore.utils.models.Movie;

public interface CarsItemClickListener {

    void onMovieClick(Movie movie, ImageView movieImageView); // we will need the imageview to make the shared animation between the two activity
}
