package com.example.calculatorapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.calculatorapp.R;
import com.example.calculatorapp.databinding.ActivityMainBinding;
import com.example.calculatorapp.pojo.NumberModel;

public class MainActivity extends AppCompatActivity implements NumView{

    //1--> MVC
//    Button plusBtn;
//    TextView plusTxT;
    DataBase dataBase =new DataBase();
    NumberModel numberModel;

    //2--> MVP
//    Button divBtn;
//    TextView divTxT;
    NumPresenter presenter;

    //3--> MVVM
    NumViewModel numViewModel;
    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        //3--> MVVM
        //Binding class
//        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        //1--> MVC
//        plusBtn = findViewById(R.id.plus_button);
//        plusTxT = findViewById(R.id.plus_result_textView);
//        plusBtn.setOnClickListener(this);

        binding.plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPlusResult();
            }
        });

        //2--> MVP
//        divBtn = findViewById(R.id.div_button);
//        divTxT = findViewById(R.id.div_result_textView);
//        divBtn.setOnClickListener(this);
        presenter = new NumPresenter(this);

        binding.divButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.passResultToInterface();
            }
        });

        //3--> MVVM
        numViewModel = ViewModelProviders.of(this).get(NumViewModel.class);
        binding.setNumViewMod(numViewModel);
        binding.setLifecycleOwner(this);

    }

    //1--> MVC mehod
    private void getPlusResult() {
        int results;
        numberModel = dataBase.getNumbers();
        results = numberModel.getFirstNum() + numberModel.getSecondNum();
        binding.plusResultTextView.setText(String.valueOf(results));
    }

//    @Override
//    public void onClick(View v) {
//        if (v.getId() == binding.plusButton){
//            getPlusResult();
//        }
//        if (v.getId() == R.id.div_button){
//            presenter.passResultToInterface();
//        }
//    }

    //2--> MVP Interface that recieve result as parameter in his method and implement it to show in text view
    @Override
    public void onGetDivRes(int res) {
        binding.divResultTextView.setText(String.valueOf(res));
    }
}