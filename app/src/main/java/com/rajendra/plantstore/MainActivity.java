package com.rajendra.plantstore;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;
import com.rajendra.plantstore.retrofit.ApiInterface;
import com.rajendra.plantstore.utils.ChildModel;
import com.rajendra.plantstore.utils.Common;
import com.rajendra.plantstore.utils.DataSource;
import com.rajendra.plantstore.utils.HeaderModel;
import com.rajendra.plantstore.utils.NavigationListView;
import com.rajendra.plantstore.utils.adapters.CarsItemClickListener;
import com.rajendra.plantstore.utils.adapters.MovieAdapter;
import com.rajendra.plantstore.utils.adapters.MovieAdapter2;
import com.rajendra.plantstore.utils.adapters.MovieAdapter3;
import com.rajendra.plantstore.utils.adapters.MovieItemClickListener;
import com.rajendra.plantstore.utils.models.Movie;
import com.rajendra.plantstore.utils.models.Slide;

import java.util.List;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements MovieItemClickListener, NavigationView.OnNavigationItemSelectedListener, CarsItemClickListener {

    private List<Slide> lstSlides;
    private ViewPager sliderpager;
    //private TabLayout indicator;
    private RecyclerView MoviesRV, moviesRvWeek;


    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;
    private NavigationListView listView;
    private Context context;

    ApiInterface anInterface;
    private RecyclerView plantRecyclerView, potRecyclerView, forYouRecyclerView;

    public MainActivity() {
    }

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_main);
        initWeekCars();
        initWeekCarsTop();
        initPopularCars();
        findViewById();
        menu();
    }

    private void findViewById() {

        context = MainActivity.this;
        listView = findViewById(R.id.expandable_navigation);

        drawer = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this, drawer, R.string.drawer_open, R.string.drawer_close);
        toggle.setDrawerIndicatorEnabled(true);
        drawer.setDrawerListener(toggle);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    private void menu() {

        listView.init(this)
                .addHeaderModel(new HeaderModel("Домой"))
                // .addHeaderModel(new HeaderModel("Шоурум", R.drawable.ic_cardbackgroud, true, true, false, Color.WHITE))
                .addHeaderModel(new HeaderModel("Шоурум"))
                .addHeaderModel(
                        new HeaderModel("Tип кузова", -1, true)
                                .addChildModel(new ChildModel("Седан"))
                                .addChildModel(new ChildModel("Хэтчбек"))
                                .addChildModel(new ChildModel("Минивен"))
                                .addChildModel(new ChildModel("Внедорожник"))
                                .addChildModel(new ChildModel("Купе"))
                                .addChildModel(new ChildModel("Кабриолет"))
                                .addChildModel(new ChildModel("Пикап"))
                                .addChildModel(new ChildModel("Универсал"))
                                .addChildModel(new ChildModel("Тарга"))
                                .addChildModel(new ChildModel("Лимузин"))
                )
                .addHeaderModel(new HeaderModel("Наши марки"))
                .addHeaderModel(new HeaderModel("Список желаний"))
                .addHeaderModel(new HeaderModel("Уведомления"))
                .addHeaderModel(new HeaderModel("Настройки"))
                .build()
                .addOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
                    @Override
                    public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                        listView.setSelected(groupPosition);

                        //drawer.closeDrawer(GravityCompat.START);
                        if (id == 0) {
                            //Home Menu
                            Common.showToast(context, "Домой");

                            drawer.closeDrawer(GravityCompat.START);
                        } else if (id == 1) {
                            //Cart Menu
                            Common.showToast(context, "Шоурум");
                            drawer.closeDrawer(GravityCompat.START);
                        } /*else if (id == 2) {
                            //Categories Menu
                            Common.showToast(context, "Categories  Select");
                        }*/ else if (id == 3) {
                            //Orders Menu
                            Common.showToast(context, "Заказы");
                            drawer.closeDrawer(GravityCompat.START);
                        } else if (id == 4) {
                            //Wishlist Menu
                            Common.showToast(context, "Список желаний");
                            drawer.closeDrawer(GravityCompat.START);
                        } else if (id == 5) {
                            //Notifications Menu
                            Common.showToast(context, "Уведомления");
                            drawer.closeDrawer(GravityCompat.START);
                        } else if (id == 6) {
                            //Notifications Menu
                            Common.showToast(context, "Настройки");
                            drawer.closeDrawer(GravityCompat.START);
                        }
                        return false;
                    }
                })
                .addOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                    @Override
                    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                        listView.setSelected(groupPosition, childPosition);
                        if (id == 0) {
                            Common.showToast(context, "Man's Fashion");
                        } else if (id == 1) {
                            Common.showToast(context, "Woman's Fashion");
                        } else if (id == 2) {
                            Common.showToast(context, "Babies and Family");
                        } else if (id == 3) {
                            Common.showToast(context, "Health");
                        }

                        drawer.closeDrawer(GravityCompat.START);
                        return false;
                    }
                });
        //listView.expandGroup(2);
    }


//--------------------------------------//      //-----------------------------------------//


    private void initWeekCarsTop() {
        plantRecyclerView = findViewById(R.id.plant_recycler);
        MovieAdapter movieAdapter = new MovieAdapter(this, DataSource.getCars(), this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        plantRecyclerView.setLayoutManager(layoutManager);
        plantRecyclerView.setAdapter(movieAdapter);
    }

    private void initWeekCars() {
        potRecyclerView = findViewById(R.id.pot_recycler);
        MovieAdapter2 movieAdapter2 = new MovieAdapter2(this, DataSource.getWeekCars(), this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        potRecyclerView.setLayoutManager(layoutManager);
        potRecyclerView.setAdapter(movieAdapter2);

    }

    private void initPopularCars() {
        forYouRecyclerView = findViewById(R.id.for_you_recycler);
        MovieAdapter3 movieAdapter3 = new MovieAdapter3(this, DataSource.getPopularCars(), this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        forYouRecyclerView.setLayoutManager(layoutManager);
        forYouRecyclerView.setAdapter(movieAdapter3);

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


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

     /*   int id = item.getItemId();
        if (id == R.id.cart)
            //noinspection SimplifiableIfStatement
            if (id == R.id.action_search) {
                return true;
            }

        return super.onOptionsItemSelected(item);
    }

*/

        switch (id) {
            case R.id.action_settings:
                Intent intent = new Intent(this, PlantDetails.class);
                startActivity(intent);

                break;

            case R.id.action_search:
                Intent menu = new Intent(this, MainActivity.class);
                startActivity(menu);

                break;
        }

        //return super.onOptionsItemSelected(item);

        return toggle != null && toggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

       /* if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }*/

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


   /* @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return toggle != null && toggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }*/

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if (toggle != null)
            toggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (toggle != null)
            toggle.onConfigurationChanged(newConfig);
    }



   /* @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
// Sync the toggle state after onRestoreInstanceState has occurred.
        mActionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mActionBarDrawerToggle.onConfigurationChanged(newConfig);
    }*/
}

