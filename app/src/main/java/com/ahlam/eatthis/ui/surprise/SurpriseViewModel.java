package com.ahlam.eatthis.ui.surprise;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ahlam.eatthis.api.TheMealDbApi;
import com.ahlam.eatthis.api.TheMealDbApiInterface;

public class SurpriseViewModel extends ViewModel {


    public SurpriseViewModel() {
        loadRandMeals();
    }

    private void loadRandMeals() {
        TheMealDbApiInterface api = TheMealDbApi.buildInstance();

    }

}