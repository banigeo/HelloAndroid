package com.banigeo.helloandroid.ui.view;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RecyclerViewModel extends androidx.lifecycle.ViewModel {

    private final MutableLiveData<String> mText;

    public RecyclerViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is recycler view fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}