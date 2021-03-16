package com.seer.seertask;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.seer.seertask.adapter.SearchResultAdapter;
import com.seer.seertask.adapter.StoriesAdapter;
import com.seer.seertask.model.Doc;
import com.seer.seertask.model.Result;
import com.seer.seertask.model.ResultModel;
import com.seer.seertask.model.TopStories;
import com.seer.seertask.viewmodel.SearchResultViewModel;
import com.seer.seertask.viewmodel.TopStoriesViewModel;

import java.util.List;

import static com.seer.seertask.handel.Constant.hideKeyboard;

public class MainActivity extends AppCompatActivity {

    private List<Result> topStoriesList;
    private List<Doc> searchResultList;
    private StoriesAdapter adapter;
    private SearchResultAdapter resultAdapter;
    private EditText searchBox;
    private TopStoriesViewModel topStoriesViewModel;
    private SearchResultViewModel resultViewModel;
    private RecyclerView searchResult;
    private Button search;
    boolean isClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        RecyclerView rvStories = findViewById(R.id.topStories);
        final TextView noResult = findViewById(R.id.noResult);
        ProgressBar progress = findViewById(R.id.progressBar);
        searchBox = findViewById(R.id.etQuery);
        searchResult = findViewById(R.id.searchResult);
        search = findViewById(R.id.btnSearch);
        search.setOnClickListener(v -> {
            if (searchBox.getText().toString().length()>0) {
                searchResult.setVisibility(View.VISIBLE);
                isClicked = true;
                getSearchResult(searchResult, noResult, progress);
                hideKeyboard(MainActivity.this);
            }
        });
        setTopStories(rvStories, noResult, progress);
    }

    private void getSearchResult(RecyclerView searchResult, TextView noResult, ProgressBar progress) {
        progress.setVisibility(View.VISIBLE);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        searchResult.setLayoutManager(manager);
        resultAdapter = new SearchResultAdapter(this,searchResultList);
        searchResult.setAdapter(resultAdapter);

        resultViewModel = ViewModelProviders.of(this).get(SearchResultViewModel.class);
        resultViewModel.getResultModel().observe(this, resultModel -> {
            if (resultModel!=null){
                progress.setVisibility(View.GONE);
                searchResultList = resultModel.getResponse().docs;
                resultAdapter.setResultList(resultModel.getResponse().docs);
                noResult.setVisibility(View.GONE);
            }else {
                noResult.setVisibility(View.VISIBLE);
            }

        });
        resultViewModel.callApiSearch(searchBox.getText().toString());
    }

    private void setTopStories(RecyclerView rvStories, TextView noResult, ProgressBar progress) {
        progress.setVisibility(View.VISIBLE);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        SnapHelper helperPcourse = new LinearSnapHelper();
        helperPcourse.attachToRecyclerView(rvStories);
        rvStories.setLayoutManager(manager);
        adapter = new StoriesAdapter(this, topStoriesList);
        rvStories.setAdapter(adapter);


        topStoriesViewModel = ViewModelProviders.of(this).get(TopStoriesViewModel.class);
        topStoriesViewModel.getTopStories().observe(this, topStories -> {
            if (topStories != null) {
                progress.setVisibility(View.GONE);
                topStoriesList = topStories.results;
                adapter.setTopStories(topStories.results);
                noResult.setVisibility(View.GONE);
            } else {
                noResult.setVisibility(View.VISIBLE);
            }
        });
        topStoriesViewModel.callApi();
    }

    @Override
    public void onBackPressed() {
        if (isClicked) {
            searchResult.setVisibility(View.GONE);
            searchResult.setAdapter(null);
            isClicked = false;
            return;
        }
        super.onBackPressed();
    }
}