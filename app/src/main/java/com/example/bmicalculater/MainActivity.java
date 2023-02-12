package com.example.bmicalculater;

import static com.example.bmicalculater.R.id.llMain;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtRes;
        EditText editWeight, editFeet, editInch;
        Button btnCalculate;
        LinearLayout llMain;

        editWeight=findViewById(R.id.edtWt);
        editFeet=findViewById(R.id.edtFt);
        editInch=findViewById(R.id.edtIn);
        btnCalculate=findViewById(R.id.btnCal);
        txtRes=findViewById(R.id.txtResult);
        llMain=findViewById(R.id.llMain);

        EditText finalEditFeet = editFeet;
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wt=Integer.parseInt(editWeight.getText().toString());
                int ft=Integer.parseInt(editFeet.getText().toString());
                int in=Integer.parseInt(editInch.getText().toString());

                int total=ft*12+in;
                double totalCm=total*2.53;
                double totalM=totalCm/100;

                double bmi= wt/(totalM*totalM);

                if(bmi>25){
                    txtRes.setText("You,re Overweight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.overweight));
                }
                else if (bmi<18) {
                    txtRes.setText("You're Underweight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.underweight));
                }else {
                    txtRes.setText("You'r Healthy");
                    llMain.setBackgroundColor(getResources().getColor(R.color.healthy));
                }
            }
        });

    }
}