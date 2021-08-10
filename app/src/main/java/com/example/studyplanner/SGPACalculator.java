package com.example.studyplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SGPACalculator extends AppCompatActivity implements View.OnClickListener {

    Button cgpa_calculator;
    EditText ss1, ss2, ss3, ss4, ss5, ss6, ss7, ss8, cs1, cs2, cs3, cs4, cs5, cs6, cs7, cs8;
    TextView cgpa_result;
    String s1s, s2s, s3s, s4s, s5s, s6s, s7s, s8s, s1c, s2c, s3c, s4c, s5c, s6c, s7c, s8c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sgpacalculator);

        ss1 = (EditText) findViewById(R.id.s1s);
        ss2 = (EditText) findViewById(R.id.s2s);
        ss3 = (EditText) findViewById(R.id.s3s);
        ss4 = (EditText) findViewById(R.id.s4s);
        ss5 = (EditText) findViewById(R.id.s5s);
        ss6 = (EditText) findViewById(R.id.s6s);
        ss7 = (EditText) findViewById(R.id.s7s);
        ss8 = (EditText) findViewById(R.id.s8s);

        cs1 = (EditText) findViewById(R.id.s1c);
        cs2 = (EditText) findViewById(R.id.s2c);
        cs3 = (EditText) findViewById(R.id.s3c);
        cs4 = (EditText) findViewById(R.id.s4c);
        cs5 = (EditText) findViewById(R.id.s5c);
        cs6 = (EditText) findViewById(R.id.s6c);
        cs7 = (EditText) findViewById(R.id.s7c);
        cs8 = (EditText) findViewById(R.id.s8c);

        cgpa_calculator = (Button) findViewById(R.id.calcgpa);
        cgpa_calculator.setOnClickListener(this);
        cgpa_calculator.setEnabled(false);

        cgpa_result = (TextView) findViewById(R.id.finalcgpa);

        ss1.addTextChangedListener(Text_Watcher);
        ss2.addTextChangedListener(Text_Watcher);
        ss3.addTextChangedListener(Text_Watcher);
        ss4.addTextChangedListener(Text_Watcher);
        ss5.addTextChangedListener(Text_Watcher);
        ss6.addTextChangedListener(Text_Watcher);
        ss7.addTextChangedListener(Text_Watcher);
        ss8.addTextChangedListener(Text_Watcher);
        cs1.addTextChangedListener(Text_Watcher);
        cs2.addTextChangedListener(Text_Watcher);
        cs3.addTextChangedListener(Text_Watcher);
        cs4.addTextChangedListener(Text_Watcher);
        cs5.addTextChangedListener(Text_Watcher);
        cs6.addTextChangedListener(Text_Watcher);
        cs7.addTextChangedListener(Text_Watcher);
        cs8.addTextChangedListener(Text_Watcher);

        s1s = ss1.getText().toString();
        if(TextUtils.isEmpty(s1s))
        {
            ss1.setError("This field cannot be empty!");
        }
        s2s = ss2.getText().toString();
        if(TextUtils.isEmpty(s2s))
        {
            ss2.setError("This field cannot be empty!");
        }
        s3s = ss3.getText().toString();
        if(TextUtils.isEmpty(s3s))
        {
            ss3.setError("This field cannot be empty!");
        }
        s4s = ss4.getText().toString();
        if(TextUtils.isEmpty(s4s))
        {
            ss4.setError("This field cannot be empty!");
        }
        s5s = ss5.getText().toString();
        if(TextUtils.isEmpty(s5s))
        {
            ss5.setError("This field cannot be empty!");
        }
        s6s = ss6.getText().toString();
        if(TextUtils.isEmpty(s6s))
        {
            ss6.setError("This field cannot be empty!");
        }
        s7s = ss7.getText().toString();
        if(TextUtils.isEmpty(s7s))
        {
            ss7.setError("This field cannot be empty!");
        }
        s8s = ss8.getText().toString();
        if(TextUtils.isEmpty(s8s))
        {
            ss8.setError("This field cannot be empty!");
        }

        s1c = cs1.getText().toString();
        if(TextUtils.isEmpty(s1c))
        {
            cs1.setError("This field cannot be empty!");
        }
        s2c = cs2.getText().toString();
        if(TextUtils.isEmpty(s2c))
        {
            cs2.setError("This field cannot be empty!");
        }
        s3c = cs3.getText().toString();
        if(TextUtils.isEmpty(s3c))
        {
            cs3.setError("This field cannot be empty!");
        }
        s4c = cs4.getText().toString();
        if(TextUtils.isEmpty(s4c))
        {
            cs4.setError("This field cannot be empty!");
        }
        s5c = cs5.getText().toString();
        if(TextUtils.isEmpty(s5c))
        {
            cs5.setError("This field cannot be empty!");
        }
        s6c = cs6.getText().toString();
        if(TextUtils.isEmpty(s6c))
        {
            cs6.setError("This field cannot be empty!");
        }
        s7c = cs7.getText().toString();
        if(TextUtils.isEmpty(s7c))
        {
            cs7.setError("This field cannot be empty!");
        }
        s8c = cs8.getText().toString();
        if(TextUtils.isEmpty(s8c))
        {
             cs8.setError("This field cannot be empty!");
        }
    }

    @Override
    public void onClick(View v) {
        double sem1s, sem2s, sem3s, sem4s, sem5s, sem6s, sem7s, sem8s, sem1c, sem2c, sem3c, sem4c, sem5c, sem6c, sem7c, sem8c;
        double numerator = 0, denominator = 0, final_cgpa = 0;
        String temp;

        sem1s = Double.parseDouble(ss1.getText().toString());
        sem2s = Double.parseDouble(ss2.getText().toString());
        sem3s = Double.parseDouble(ss3.getText().toString());
        sem4s = Double.parseDouble(ss4.getText().toString());
        sem5s = Double.parseDouble(ss5.getText().toString());
        sem6s = Double.parseDouble(ss6.getText().toString());
        sem7s = Double.parseDouble(ss7.getText().toString());
        sem8s = Double.parseDouble(ss8.getText().toString());

        sem1c = Double.parseDouble(cs1.getText().toString());
        sem2c = Double.parseDouble(cs2.getText().toString());
        sem3c = Double.parseDouble(cs3.getText().toString());
        sem4c = Double.parseDouble(cs4.getText().toString());
        sem5c = Double.parseDouble(cs5.getText().toString());
        sem6c = Double.parseDouble(cs6.getText().toString());
        sem7c = Double.parseDouble(cs7.getText().toString());
        sem8c = Double.parseDouble(cs8.getText().toString());

        if (v.equals(cgpa_calculator))
        {
            numerator = (sem1s * sem1c) + (sem2s * sem2c) + (sem3s * sem3c) + (sem4s * sem4c) + (sem5s * sem5c) + (sem6s * sem6c) + (sem7s * sem7c) + (sem8s * sem8c);
            denominator = (sem1c + sem2c + sem3c + sem4c + sem5c + sem6c + sem7c + sem8c);
            final_cgpa = numerator / denominator;
            final_cgpa = (Math.round(final_cgpa * 100.0)) / 100.0;
            temp = "CGPA: " + String.valueOf(final_cgpa) + "";
            cgpa_result.setText(temp);
        }
    }

    private TextWatcher Text_Watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String s1s, s2s, s3s, s4s, s5s, s6s, s7s, s8s, s1c, s2c, s3c, s4c, s5c, s6c, s7c, s8c;

            s1s = ss1.getText().toString().trim();
            s2s = ss2.getText().toString().trim();
            s3s = ss3.getText().toString().trim();
            s4s = ss4.getText().toString().trim();
            s5s = ss5.getText().toString().trim();
            s6s = ss6.getText().toString().trim();
            s7s = ss7.getText().toString().trim();
            s8s = ss8.getText().toString().trim();
            s1c = cs1.getText().toString().trim();
            s2c = cs2.getText().toString().trim();
            s3c = cs3.getText().toString().trim();
            s4c = cs4.getText().toString().trim();
            s5c = cs5.getText().toString().trim();
            s6c = cs6.getText().toString().trim();
            s7c = cs7.getText().toString().trim();
            s8c = cs8.getText().toString().trim();

            cgpa_calculator.setEnabled (!s1s.isEmpty() && !s2s.isEmpty() && !s3s.isEmpty() && !s4s.isEmpty()
                    && !s5s.isEmpty() && !s6s.isEmpty() && !s7s.isEmpty() && !s8s.isEmpty()
                    && !s1c.isEmpty() && !s2c.isEmpty() && !s3c.isEmpty() && !s4c.isEmpty()
                    && !s5c.isEmpty() && !s6c.isEmpty() && !s7c.isEmpty() && !s8c.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}