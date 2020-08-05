package com.telcomsis.navigationexample;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class AppViewModel extends AndroidViewModel {
    private MutableLiveData<ArrayList<String>> notasLiveData = new MutableLiveData<>();
    private ArrayList<String> listaNotas = new ArrayList<>();
    public AppViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<ArrayList<String>> getLiveDataObject(){
        return notasLiveData;
    }

    public void addNote(String valor){
        listaNotas.add(valor);
        notasLiveData.postValue(listaNotas);
    }
}
