package com.example.mvvmtraining.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvmtraining.models.FilmsData;

import java.util.ArrayList;
import java.util.List;

public class FilmsRepository {

    private ArrayList<FilmsData> films = new ArrayList<>();
    public static FilmsRepository instance;

    public static FilmsRepository getInstance() {
        if (instance == null)
            instance = new FilmsRepository();
        return instance;
    }

    public MutableLiveData<List<FilmsData>> getFilm() {
        setFilms();
        MutableLiveData<List<FilmsData>> data = new MutableLiveData<>();
        data.setValue(films);
        return data;
    }

    public void setFilms() {
        films.add(new FilmsData("Attack on titan", "https://i0.wp.com/omnitos.com/wp-content/uploads/2020/12/Attack-on-titan-season-4-episode-3.png"));
        films.add(new FilmsData("Attack on titan", "https://i0.wp.com/omnitos.com/wp-content/uploads/2020/12/Attack-on-titan-season-4-episode-3.png"));
        films.add(new FilmsData("Attack on titan", "https://i0.wp.com/omnitos.com/wp-content/uploads/2020/12/Attack-on-titan-season-4-episode-3.png"));
        films.add(new FilmsData("Attack on titan", "https://i0.wp.com/omnitos.com/wp-content/uploads/2020/12/Attack-on-titan-season-4-episode-3.png"));
        films.add(new FilmsData("Attack on titan", "https://i0.wp.com/omnitos.com/wp-content/uploads/2020/12/Attack-on-titan-season-4-episode-3.png"));
        films.add(new FilmsData("Attack on titan", "https://i0.wp.com/omnitos.com/wp-content/uploads/2020/12/Attack-on-titan-season-4-episode-3.png"));

    }
}
