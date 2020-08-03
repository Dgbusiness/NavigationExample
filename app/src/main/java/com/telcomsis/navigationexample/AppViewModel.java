package com.telcomsis.navigationexample;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class AppViewModel extends AndroidViewModel {
    public String valorPrueba = "5";
    private MutableLiveData<String> mValor = new MutableLiveData<>();
    public AppViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<String> getLiveDataObject(){
        return mValor;
    }

    public void setValor(String valor){
        mValor.postValue(valor);
    }
}
