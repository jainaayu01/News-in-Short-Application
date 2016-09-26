package com.example.india.vaetasapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by india on 8/3/2016.
 */
public class MainFragment extends Fragment{
   private  RecyclerView newsRecyclerView;
    private static StoryService storyservice;
    public  static int  mNumberOfNews;
    public static  Response<Example> mResponse;
    public  static List<Story> Story1 = new ArrayList<Story>();
    public static MainFragment newInstance(StoryService storyService) {
        storyservice = storyService;
        Bundle args = new Bundle();
        
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_main,container,false);
        newsRecyclerView = (RecyclerView) view.findViewById(R.id.news_recycler_view);

        Call<Example> call = storyservice.fetchStory();
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                mResponse = response;
                mNumberOfNews =mResponse.body().getData().size();
                Story1 = mResponse.body().getData();
                for(int i =0; i< mNumberOfNews;i++){
                    System.out.println(Story1.get(i).getArticleLink());
                }
                newsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                newsRecyclerView.setAdapter(new NewsRecyclerAdapter(storyservice,getActivity()));


            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.d("NewsFetcher","unable to fetch news"+t);
            }
        });
       // newsRecyclerView.setAdapter(new NewsRecyclerAdapter(storyservice,getActivity()));
        return view;
    }
}
