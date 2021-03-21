package com.example.unitconventer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView mtextView2;
    private TextView mtextView3;
    private TextView mtextView4;
    private TextView mtextView5;
    private TextView mtextView6;
    private TextView mtextView7;
    private ImageView mImageView1, mImageView2, mImageView3;
    private Spinner mSpinner;
    private EditText mEditText;
    private DecimalFormat df = new DecimalFormat("######0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtextView2 = findViewById(R.id.textView2);
        mtextView3 = findViewById(R.id.textView3);
        mtextView4 = findViewById(R.id.textView4);
        mtextView5 = findViewById(R.id.textView5);
        mtextView6 = findViewById(R.id.textView6);
        mtextView7 = findViewById(R.id.textView7);
        mImageView1 = findViewById(R.id.iv_1);
        mImageView2 = findViewById(R.id.iv_2);
        mImageView3 = findViewById(R.id.iv_3);
        mSpinner = findViewById(R.id.spinner);
        mEditText = findViewById(R.id.editText);

        final String[] mItems = {"Metre", "Celsius", "Kilogram"};
        ArrayAdapter<String> arrAdapter = new ArrayAdapter<String>(MainActivity.this, R.layout.support_simple_spinner_dropdown_item, mItems);
//        arrAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mSpinner.setAdapter(arrAdapter);
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this, "What you chosed is" + mItems[position], Toast.LENGTH_SHORT).show();
                mtextView2.setText("");
                mtextView3.setText("");
                mtextView4.setText("");
                mtextView5.setText("");
                mtextView6.setText("");
                mtextView7.setText("");
                mEditText.setText("");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Button of Metre
        mImageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditText.length() != 0) {
                    if (judge("Metre")) {
                        //Centimetre
                        mtextView2.setText(df.format(Double.parseDouble(mEditText.getText().toString()) * 100));
                        mtextView3.setText("Centimetre");
                        //Foot
                        mtextView4.setText(df.format(Double.parseDouble(mEditText.getText().toString()) * 3.2808399));
                        mtextView5.setText("Foot");
                        //Inch
                        mtextView6.setText(df.format(Double.parseDouble(mEditText.getText().toString()) * 39.3701));
                        mtextView7.setText("Inch");
                    } else
                        Toast.makeText(MainActivity.this, "Please select the correct conversion icon!", Toast.LENGTH_SHORT).show();
                } else Toast.makeText(MainActivity.this, "You need to enter a value!", Toast.LENGTH_SHORT).show();
            }
        });

        //Button of Celsius
        mImageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditText.length() != 0) {
                    if (judge("Celsius")) {
                        //Fahrenheit
                        mtextView2.setText(df.format(Double.parseDouble(mEditText.getText().toString()) * 9 / 5 + 32));
                        mtextView3.setText("Fahrenheit");
                        //Kelvin
                        mtextView4.setText(df.format(Double.parseDouble(mEditText.getText().toString()) + 273.15));
                        mtextView5.setText("Kelvin");
                    } else
                        Toast.makeText(MainActivity.this, "Please select the correct conversion icon!", Toast.LENGTH_SHORT).show();
                } else Toast.makeText(MainActivity.this, "You need to enter a value!", Toast.LENGTH_SHORT).show();
            }
        });

        //Button of Kilograms
        mImageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditText.length() != 0) {
                    if (judge("Kilogram")) {
                        //Gram
                        mtextView2.setText(df.format(Double.parseDouble(mEditText.getText().toString()) * 1000));
                        mtextView3.setText("Gram");
                        //Ounce(Oz)
                        mtextView4.setText(df.format(Double.parseDouble(mEditText.getText().toString()) * 35.2739619));
                        mtextView5.setText("Ounce(Oz)");
                        //Pound(Ib)
                        mtextView6.setText(df.format(Double.parseDouble(mEditText.getText().toString()) * 2.2046226));
                        mtextView7.setText("Pound(Ib)");
                    } else
                        Toast.makeText(MainActivity.this, "Please select the correct conversion icon!", Toast.LENGTH_SHORT).show();
                } else Toast.makeText(MainActivity.this, "You need to enter a value!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public Boolean judge(String converterType) {
        return converterType.equals(mSpinner.getSelectedItem().toString());
    }
}
