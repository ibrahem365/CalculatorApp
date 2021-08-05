package com.example.calculatorapp.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.calculatorapp.pojo.NumberModel;

public class NumViewModel extends ViewModel {

    private DataBase dataBase = new DataBase();
    private NumberModel numberModel;

    public MutableLiveData<String> multResult = new MutableLiveData<>();

    public void getMultiResult(){
        int result;
        numberModel = dataBase.getNumbers();
        result = numberModel.getFirstNum() * numberModel.getSecondNum();
        multResult.setValue(String.valueOf(result));
    }



}
