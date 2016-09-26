package com.example.india.vaetasapplication;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.ramotion.foldingcell.FoldingCell;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity  {
   Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofit = new Retrofit.Builder().baseUrl("http://news.vaetas.com/")
                                         .addConverterFactory(GsonConverterFactory.create())
                                         .build();
        StoryService storyService = retrofit.create(StoryService.class);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);
        if(fragment == null){
            fragment = MainFragment.newInstance(storyService);
        FragmentTransaction ft =     fm.beginTransaction().add(R.id.fragment_container,fragment);
            ft.commit();

        }

    }



}
