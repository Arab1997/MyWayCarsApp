package com.rajendra.plantstore;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class BaseActivity extends AppCompatActivity {
    public void handleColor(int color,int darkcolor){
        //changing toolbar color
        if(getSupportActionBar()!=null){
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(color));
        }

        //if bigger than Api 21 change status bar color
        if(isLolipop()){
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(darkcolor);
        }
    }

    public boolean isLolipop(){
        return  Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
    }

}
