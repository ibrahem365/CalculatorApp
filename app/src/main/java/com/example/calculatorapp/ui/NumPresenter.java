package com.example.calculatorapp.ui;

import android.widget.TextView;

import com.example.calculatorapp.pojo.NumberModel;

public class NumPresenter {

    private DataBase dataBase = new DataBase();
    private NumberModel numberModel;


    NumView numView;

    public NumPresenter(NumView numView) {
        this.numView = numView;
    }

    private int getDivResult() {
        int results;
        numberModel = dataBase.getNumbers();
        results = numberModel.getFirstNum() / numberModel.getSecondNum();
        return results;
    }

    public void passResultToInterface(){
        numView.onGetDivRes(getDivResult());
    }

}
