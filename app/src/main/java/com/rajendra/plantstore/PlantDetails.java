package com.rajendra.plantstore;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.rajendra.plantstore.utils.adapters.CastAdapter;
import com.rajendra.plantstore.utils.models.Cast;

import java.util.ArrayList;
import java.util.List;


public class PlantDetails extends AppCompatActivity {

     ImageView MovieThumbnailImg, MovieCoverImg;
     TextView tv_title,tv_description;
     FloatingActionButton play_fab;

     RecyclerView RvCast;
     CastAdapter castAdapter;

    ImageView plantImage, backBtn;

    TextView plantName, plantCat, plantSize, plantPrice, plantType, plantPlacement, plantPot, plantLayer, plantHeight, plantDim, plantDesc;

    String name, cat, size, price, type, placement, pot, layer, height, dim, desc, image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_details);
        iniViews();
      //  setupRvCast();

        backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlantDetails.this, MainActivity.class);
                startActivity(intent);
                //finish();
            }
        });

    }


       /* Intent intent = getIntent();

        name = intent.getStringExtra("name");
        cat = intent.getStringExtra("cat");
        size = intent.getStringExtra("size");
        price = intent.getStringExtra("price");
        type = intent.getStringExtra("type");
        placement = intent.getStringExtra("placement");
        pot = intent.getStringExtra("pot");
        layer = intent.getStringExtra("layer");
        height = intent.getStringExtra("height");
        dim = intent.getStringExtra("dim");
        desc = intent.getStringExtra("desc");
        image = intent.getStringExtra("imgurl");

        plantName = findViewById(R.id.plant_name);
        plantCat = findViewById(R.id.plant_category);
        plantSize = findViewById(R.id.plant_size);
        plantPrice = findViewById(R.id.plant_price2);
        plantType = findViewById(R.id.plant_type);
        plantPlacement = findViewById(R.id.plant_placement);
        plantPot = findViewById(R.id.plant_pot);
        plantLayer = findViewById(R.id.plant_layer);
        plantHeight = findViewById(R.id.plant_height);
        plantDim = findViewById(R.id.plant_dim);
        plantDesc = findViewById(R.id.plant_description);
        plantImage = findViewById(R.id.plant_image2);

        plantName.setText(name);
        plantCat.setText(cat);
        plantSize.setText(size);
        plantPrice.setText("₹ "+price);
        plantType.setText(type);
        plantPlacement.setText(placement);
        plantPot.setText(pot);
        plantLayer.setText(layer);
        plantHeight.setText(height);
        plantDim.setText(dim);
        plantDesc.setText(desc);

        Glide.with(this).load(image).into(plantImage);*/

        // its complited now we will ad some transition fo make app very interactive and beautiful.
        void setupRvCast() {
            List<Cast> mData = new ArrayList<>();
            mData.add(new Cast("name", R.drawable.mers2));
            mData.add(new Cast("name", R.drawable.mers3));
            mData.add(new Cast("name", R.drawable.mers4));
            mData.add(new Cast("name", R.drawable.mers5));
            mData.add(new Cast("name", R.drawable.mers6));
            mData.add(new Cast("name", R.drawable.mers7));
            mData.add(new Cast("name", R.drawable.mers8));
            mData.add(new Cast("name", R.drawable.mers8));


            castAdapter = new CastAdapter( this, mData);
            RvCast.setAdapter(castAdapter);
            RvCast.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        }

        void iniViews() {
            RvCast = findViewById(R.id.rv_cast);
            String movieTitle = getIntent().getExtras().getString("title");
            int imageResourceId = getIntent().getExtras().getInt("imgURL");
            int imagecover = getIntent().getExtras().getInt("imgCover");
            plantImage = findViewById(R.id.plant_image);

            Glide.with(this).load(imageResourceId).into(plantImage);
            plantImage.setImageResource(imageResourceId);
           // MovieCoverImg = findViewById(R.id.detail_movie_cover);

            Glide.with(this).load(imagecover).into(plantImage);
            plantName = findViewById(R.id.plant_name);
            plantName.setText(movieTitle);
            // getSupportActionBar().setTitle(movieTitle);
            tv_description = findViewById(R.id.plant_description);
            // setup animation
            plantImage.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale_animation));
            plantName.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale_animation));



        }
    }
