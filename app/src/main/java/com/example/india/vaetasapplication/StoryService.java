package com.example.india.vaetasapplication;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by india on 8/4/2016.
 */
public interface StoryService {
    @GET("stories")
    Call<Example> fetchStory();

}
