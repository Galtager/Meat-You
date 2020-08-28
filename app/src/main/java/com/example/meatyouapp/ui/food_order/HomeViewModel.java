package com.example.meatyouapp.ui.food_order;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.meatyouapp.R;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue(String.valueOf((R.string.homeTxt)));
    }

    public LiveData<String> getText() {
        return mText;
    }
}