package com.gorman.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double conversionRate = 113.65;
    double convertAmount = 0.00;
    double convertedResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        final EditText amount = (EditText) findViewById(R.id.txtAmount);
        final RadioButton USDtoYEN = (RadioButton) findViewById(R.id.radioUSDtoYEN);
        final RadioButton YENtoUSD = (RadioButton) findViewById(R.id.radioYENtoUSD);
        final TextView result = (TextView) findViewById(R.id.txtResult);
        Button convert = (Button)findViewById(R.id.btnConvert);


        convert.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                convertAmount = Double.parseDouble(amount.getText().toString());
                DecimalFormat hundredth = new DecimalFormat("$###,###.##");
                if (USDtoYEN.isChecked()) {
                    if (convertAmount <= 10000) {
                        convertedResult = convertAmount * conversionRate;
                        result.setText(hundredth.format(convertedResult) + " Yen.");

                    } else {
                        Toast.makeText(MainActivity.this, "Dollars must be less " +
                                "than 10,000", Toast.LENGTH_LONG).show();
                    }
                }
                if (YENtoUSD.isChecked()) {
                    if (convertAmount <= 1136515.00) {
                        convertedResult = convertAmount / conversionRate;
                        result.setText(hundredth.format(convertedResult) + " Dollars.");
                    } else {
                        Toast.makeText(MainActivity.this, "Yen must be less than 1136515.00.", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
