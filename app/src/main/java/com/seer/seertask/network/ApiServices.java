package com.seer.seertask.network;

import com.seer.seertask.model.ResultModel;
import com.seer.seertask.model.TopStories;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiServices {
    @GET("topstories/v2/arts.json")
    Call<TopStories> getTopStories(@Query("api-key") String apiKey);

    @GET("search/v2/articlesearch.json")
    Call<ResultModel> getResult(@Query("q") String query
            , @Query("api-key") String apiKey);
}
