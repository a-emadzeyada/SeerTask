package com.seer.seertask.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.seer.seertask.model.ResultModel;
import com.seer.seertask.network.ApiServices;
import com.seer.seertask.network.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.seer.seertask.handel.Constant.API_KEY;
import static com.seer.seertask.handel.Constant.BASE_URL;

public class SearchResultViewModel extends ViewModel {
    private final MutableLiveData<ResultModel> resultModel;

    public SearchResultViewModel() {
        resultModel = new MutableLiveData<>();
    }

    public MutableLiveData<ResultModel> getResultModel() {
        return resultModel;
    }

    public void callApiSearch(String query) {
        ApiServices apiServices = RetrofitInstance.getRetroClient(BASE_URL).create(ApiServices.class);
        Call<ResultModel> searchResult = apiServices.getResult(query, API_KEY);
        searchResult.enqueue(new Callback<ResultModel>() {
            @Override
            public void onResponse(Call<ResultModel> call, Response<ResultModel> response) {
                resultModel.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ResultModel> call, Throwable t) {
                resultModel.postValue(null);
            }
        });
    }
}
