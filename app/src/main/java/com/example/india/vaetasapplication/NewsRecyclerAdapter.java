package com.example.india.vaetasapplication;

import android.content.Context;
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
 * Created by india on 8/4/2016.
 */
//butterknife  dependencyInjection
public class NewsRecyclerAdapter extends RecyclerView.Adapter<NewsViewHolder>   {
    /*private int mNumberOfNews;
    private  Response<Example> mResponse;
    private Context mContext;
    private List<Story> Story1 = new ArrayList<>();*/
    private Context mContext;
    public NewsRecyclerAdapter(StoryService storyService, Context context){
           mContext = context;
       /* Call<Example> call = storyService.fetchStory();
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
               mResponse = response;
               mNumberOfNews =mResponse.body().getData().size();
                Story1 = mResponse.body().getData();
                for(int i =0; i< mNumberOfNews;i++){
                    System.out.println(Story1.get(i).getArticleLink());
                }



            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.d("NewsFetcher","unable to fetch news"+t);
            }
        });*/
    }
    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
       View view = inflater.inflate(R.layout.recycler_view_news_view,null);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
            Story story =MainFragment.Story1.get(position);
        holder.bindStory(story,mContext);
    }

    @Override
    public int getItemCount() {
        return MainFragment.mNumberOfNews;
    }

    //@Override

}
