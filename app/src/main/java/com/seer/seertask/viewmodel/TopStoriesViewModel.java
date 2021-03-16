package com.seer.seertask.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.seer.seertask.model.TopStories;
import com.seer.seertask.network.ApiServices;
import com.seer.seertask.network.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.seer.seertask.handel.Constant.API_KEY;
import static com.seer.seertask.handel.Constant.BASE_URL;

public class TopStoriesViewModel extends ViewModel {

    private MutableLiveData<TopStories> topStorie ;
    public TopStoriesViewModel() {
        topStorie = new MutableLiveData<>();
    }

    public MutableLiveData<TopStories> getTopStories(){
        return topStorie;
    }

    public void callApi (){
        ApiServices apiServices = RetrofitInstance.getRetroClient(BASE_URL).create(ApiServices.class);
        Call<TopStories>topStories = apiServices.getTopStories(API_KEY);
        topStories.enqueue(new Callback<TopStories>() {
            @Override
            public void onResponse(Call<TopStories> call, Response<TopStories> response) {
                topStorie.postValue(response.body());
            }

            @Override
            public void onFailure(Call<TopStories> call, Throwable t) {
                topStorie.postValue(null);
            }
        });
    }
}
