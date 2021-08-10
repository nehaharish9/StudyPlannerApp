package com.example.studyplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button studytimer, planner, cgpacalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studytimer = (Button)findViewById(R.id.plr);
        studytimer.setOnClickListener(this);

        cgpacalculator = (Button)findViewById(R.id.cgpa);
        cgpacalculator.setOnClickListener(this);

        planner = (Button)findViewById(R.id.todolist);
        planner.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v.equals(studytimer))
        {
            Intent myIntent = new Intent(MainActivity.this, Syllabus.class);
            startActivity(myIntent);
        }

        if(v.equals(cgpacalculator))
        {
            Intent myIntent = new Intent(MainActivity.this, SGPACalculator.class);
            startActivity(myIntent);
        }

        if(v.equals(planner))
        {
            Intent myIntent = new Intent(MainActivity.this, todolist.class);
            startActivity(myIntent);
        }

    }
}
