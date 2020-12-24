package com.example.mvvmtraining.viewmodels;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.loader.content.AsyncTaskLoader;

import com.example.mvvmtraining.models.FilmsData;
import com.example.mvvmtraining.repositories.FilmsRepository;

import java.util.List;

public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<List<FilmsData>> films;
    private MutableLiveData<Boolean> isAdding;
    private FilmsRepository filmsRepository;
    Context context;


    public LiveData<List<FilmsData>> getFilm() {
        return films;
    }

    public LiveData<Boolean> isAdding() {
        return isAdding;
    }

    public void delay(int mSec, FilmsData film) {

        final Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                List<FilmsData> currentFilm = films.getValue();
                currentFilm.add(film);
                films.postValue(currentFilm);
                isAdding.postValue(true);
            }
        }, mSec);
    }


    public void init(Context context) {
        this.context = context;
        isAdding = new MutableLiveData<>();
        if (films != null)
            return;
        filmsRepository = FilmsRepository.getInstance();
        films = filmsRepository.getFilm();
    }

    public void addNewFilm(FilmsData film) {
        isAdding.postValue(false);
        delay(5000, film);
    }
}
