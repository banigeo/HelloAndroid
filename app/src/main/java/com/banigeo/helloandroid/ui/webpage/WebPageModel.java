package com.banigeo.helloandroid.ui.webpage;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class WebPageModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public WebPageModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Browser App");
    }

    public LiveData<String> getText() {
        return mText;
    }
}