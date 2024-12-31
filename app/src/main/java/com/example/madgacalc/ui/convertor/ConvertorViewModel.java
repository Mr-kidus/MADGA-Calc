package com.example.madgacalc.ui.convertor;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ConvertorViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ConvertorViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}