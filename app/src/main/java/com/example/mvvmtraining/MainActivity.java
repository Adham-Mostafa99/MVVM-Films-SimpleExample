package com.example.mvvmtraining;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.mvvmtraining.adapters.RecyclerAdapter;
import com.example.mvvmtraining.models.FilmsData;
import com.example.mvvmtraining.viewmodels.MainActivityViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView filmsRecycleView;
    private RecyclerAdapter adapter;
    private MainActivityViewModel mainActivityViewModel;
    private FloatingActionButton addFilm;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        filmsRecycleView = findViewById(R.id.films_recycleview);
        addFilm = findViewById(R.id.addFilm_button);
        progressBar = findViewById(R.id.progress_bar_wait);

        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        mainActivityViewModel.init(this);

        mainActivityViewModel.getFilm().observe(this, new Observer<List<FilmsData>>() {
            @Override
            public void onChanged(List<FilmsData> filmsData) {
                adapter.notifyDataSetChanged();
            }
        });


        mainActivityViewModel.isAdding().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean)
                    hideProgressBar();
                else
                    showProgressBar();
            }
        });


        addFilm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivityViewModel.addNewFilm(new FilmsData("newFilmAdd"
                        , "https://i.imgur.com/ZcLLrkY.jpg"));
            }
        });

        initRecycleView();
    }


    public void initRecycleView() {
        adapter = new RecyclerAdapter(this, mainActivityViewModel.getFilm().getValue());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        filmsRecycleView.setLayoutManager(layoutManager);
        filmsRecycleView.setAdapter(adapter);
    }


    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }
}