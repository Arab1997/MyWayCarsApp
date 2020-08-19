package com.rajendra.plantstore.utils;



import com.rajendra.plantstore.R;
import com.rajendra.plantstore.utils.models.Movie;

import java.util.ArrayList;
import java.util.List;

public class DataSource {


    public static List<Movie> getPopularCars(){
        List<Movie> lstMovies = new ArrayList<>();
        lstMovies.add(new Movie("Mercedes-Benz SLS AMG", R.drawable.mers3,R.drawable.mers3));
        lstMovies.add(new Movie("Mercedes-Benz CLA-Class",R.drawable.mers4,R.drawable.mers4));
        lstMovies.add(new Movie("Mercedes-Benz GLA-Class",R.drawable.mers5,R.drawable.mers5));
        lstMovies.add(new Movie("Mercedes-Benz SL-Class ",R.drawable.mers6,R.drawable.mers6));
        lstMovies.add(new Movie("Mercedes-Benz AMG GT",R.drawable.merss3332,R.drawable.merss3332));
        lstMovies.add(new Movie("Mercedes-Benz CLA-Class",R.drawable.mers4,R.drawable.mers4));
        lstMovies.add(new Movie("Mercedes-Benz GLA-Class",R.drawable.mers5,R.drawable.mers5));
        lstMovies.add(new Movie("Mercedes-Benz SL-Class ",R.drawable.mers6,R.drawable.mers6));
        return lstMovies;
    }



    public static List<Movie> getWeekCars(){

        List<Movie> lstMovies = new ArrayList<>();
        lstMovies.add(new Movie("Mercedes-Benz SLS AMG", R.drawable.mers3,R.drawable.mers3));
        lstMovies.add(new Movie("Mercedes-Benz CLA-Class",R.drawable.mers4,R.drawable.mers4));
        lstMovies.add(new Movie("Mercedes-Benz GLA-Class",R.drawable.mers5,R.drawable.mers5));
        lstMovies.add(new Movie("Mercedes-Benz SL-Class ",R.drawable.mers6,R.drawable.mers6));
        lstMovies.add(new Movie("Mercedes-Benz AMG GT",R.drawable.merss3332,R.drawable.merss3332));
        lstMovies.add(new Movie("Mercedes-Benz CLA-Class",R.drawable.mers4,R.drawable.mers4));
        lstMovies.add(new Movie("Mercedes-Benz GLA-Class",R.drawable.mers5,R.drawable.mers5));
        lstMovies.add(new Movie("Mercedes-Benz SL-Class ",R.drawable.mers6,R.drawable.mers6));

        return lstMovies;
    }



    public static List<Movie> getCars(){

        List<Movie> lstMovies = new ArrayList<>();
        lstMovies.add(new Movie("Mercedes-Benz SLS AMG", R.drawable.mers3,R.drawable.mers3));
        lstMovies.add(new Movie("Mercedes-Benz CLA-Class",R.drawable.mers4,R.drawable.mers4));
        lstMovies.add(new Movie("Mercedes-Benz GLA-Class",R.drawable.mers5,R.drawable.mers5));
        lstMovies.add(new Movie("Mercedes-Benz SL-Class ",R.drawable.mers6,R.drawable.mers6));
        lstMovies.add(new Movie("Mercedes-Benz AMG GT",R.drawable.merss3332,R.drawable.merss3332));
        lstMovies.add(new Movie("Mercedes-Benz CLA-Class",R.drawable.mers4,R.drawable.mers4));
        lstMovies.add(new Movie("Mercedes-Benz GLA-Class",R.drawable.mers5,R.drawable.mers5));
        lstMovies.add(new Movie("Mercedes-Benz SL-Class ",R.drawable.mers6,R.drawable.mers6));


        return lstMovies;
    }
}
