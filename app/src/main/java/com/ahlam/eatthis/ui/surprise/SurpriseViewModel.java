package com.ahlam.eatthis.ui.surprise;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SurpriseViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public SurpriseViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}