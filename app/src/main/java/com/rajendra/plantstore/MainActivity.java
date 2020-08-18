package com.rajendra.plantstore;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.rajendra.plantstore.adapter.IndoorPlantsAdapter;
import com.rajendra.plantstore.adapter.PotsAdapter;
import com.rajendra.plantstore.retrofit.ApiInterface;
import com.rajendra.plantstore.utils.DataSource;
import com.rajendra.plantstore.utils.adapters.MovieAdapter;
import com.rajendra.plantstore.utils.adapters.MovieAdapter2;
import com.rajendra.plantstore.utils.adapters.MovieItemClickListener;
import com.rajendra.plantstore.utils.models.Movie;
import com.rajendra.plantstore.utils.models.Slide;

import java.util.List;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements MovieItemClickListener {

    private List<Slide> lstSlides;
    private ViewPager sliderpager;
    //private TabLayout indicator;
    private RecyclerView MoviesRV, moviesRvWeek;

    ApiInterface anInterface;
    private RecyclerView plantRecyclerView, potRecyclerView;
    private IndoorPlantsAdapter indoorPlantsAdapter;
    private PotsAdapter potsAdapter;
    private Movie movieAdapter;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* initViews();
        initSlider();*/

       initWeekCars();
       initWeekCarsTop();
       // initPopularCars();

/*
        anInterface = RetrofitClient.getRetrofitInstance().create(ApiInterface.class);

        Call<List<IndoorPlant>> call = anInterface.getAllPlants();
        call.enqueue(new Callback<List<IndoorPlant>>() {
            @Override
            public void onResponse(Call<List<IndoorPlant>> call, Response<List<IndoorPlant>> response) {

                List<IndoorPlant> s = response.body();
                Log.d("data", s.toString());

                // here you can see we have successfully fetched data from server
                // now we need to set this data to recyclerview adapter.

                getPlants(s.get(0).getRecommended());
                //lets run
                //i think my internet is too slow
                //wait
                getPots(s.get(0).getPots());

                //its done.

            }

            @Override
            public void onFailure(Call<List<IndoorPlant>> call, Throwable t) {

            }
        });*/

    }
 /*   private  void getPlants(List<Recommended> recommendedList){

        plantRecyclerView = findViewById(R.id.plant_recycler);
        indoorPlantsAdapter = new IndoorPlantsAdapter(this, recommendedList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        plantRecyclerView.setLayoutManager(layoutManager);
        plantRecyclerView.setAdapter(indoorPlantsAdapter);
    }

    private  void getPots(List<Pot> potList){

        potRecyclerView = findViewById(R.id.pot_recycler);
        potsAdapter = new PotsAdapter(this, potList);
        //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        gridLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        potRecyclerView.setLayoutManager(gridLayoutManager);
        potRecyclerView.setAdapter(potsAdapter);
    }*/

//--------------------------------------//      //-----------------------------------------//

    private void initPopularCars() {
        plantRecyclerView = findViewById(R.id.plant_recycler);
        MovieAdapter movieAdapter = new MovieAdapter(this, DataSource.getPopularCars(), this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        plantRecyclerView.setLayoutManager(layoutManager);
        plantRecyclerView.setAdapter(movieAdapter);

    }
    private void initWeekCars() {
        potRecyclerView = findViewById(R.id.pot_recycler);
        MovieAdapter2 movieAdapter2 = new MovieAdapter2(this, DataSource.getWeekCars(),  this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        potRecyclerView.setLayoutManager(layoutManager);
        potRecyclerView.setAdapter(movieAdapter2);

    }

    private void initWeekCarsTop() {
        plantRecyclerView = findViewById(R.id.plant_recycler);
        MovieAdapter movieAdapter = new MovieAdapter(this, DataSource.getCars(), this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        plantRecyclerView.setLayoutManager(layoutManager);
        plantRecyclerView.setAdapter(movieAdapter);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onMovieClick(Movie movie, ImageView movieImageView) {
        // here we send movie information to detail activity
        // also we ll create the transition animation between the two activity
        Intent intent = new Intent(this, PlantDetails.class);
        // send movie information to deatilActivity
        intent.putExtra("title", movie.getTitle());
        intent.putExtra("imgURL", movie.getThumbnail());
        intent.putExtra("imgCover", movie.getCoverPhoto());
        // lets crezte the animation
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, movieImageView, "sharedName");
        startActivity(intent, options.toBundle());

    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onListClick(Movie movie, ImageView carImageView) {
        Intent intent = new Intent(this, PlantDetails.class);
        // send movie information to deatilActivity
        intent.putExtra("title", movie.getTitle());
        intent.putExtra("imgURL", movie.getThumbnail());
        intent.putExtra("imgCover", movie.getCoverPhoto());
        // lets create the animation
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, carImageView, "sharedName");
        startActivity(intent, options.toBundle());

    }

    class SliderTimer extends TimerTask {
        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (sliderpager.getCurrentItem() < lstSlides.size() - 1) {
                        sliderpager.setCurrentItem(sliderpager.getCurrentItem() + 1);
                    } else
                        sliderpager.setCurrentItem(0);
                }
            });
        }
    }


   /* public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        mDrawerLayout.closeDrawers();

        if (id == R.id.nav_login) {
            if (mIsLoggedin) {
                logout();
            } else {
                mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.fragment_container, new LoginFragment()).commit();
            }
            }
            }



    Spinner spinner = (Spinner) navigationView.getMenu().findItem(R.id.navigation_drawer_item3).getActionView();
    spinner.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,language));
    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(MainActivity.this,language[position],Toast.LENGTH_SHORT).show();
        }
        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }
    });*/

}

