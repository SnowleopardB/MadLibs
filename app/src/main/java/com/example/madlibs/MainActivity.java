package com.example.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.io.InputStream;


public class MainActivity extends AppCompatActivity {

    InputStream storyID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start = findViewById(R.id.Startbutton);
        start.setOnClickListener(new ButtonOnClickListener());
    }


    @Override
    protected void onResume() {
        super.onResume();

        RadioGroup rg = findViewById(R.id.radiogroup);
        rg.clearCheck();
    }

    public void checkClicked(View view) {
        RadioButton radio = (RadioButton) view;
        String checkStr = radio.getText().toString();
        storyID = getResources().openRawResource(R.raw.madlib0_simple);

        if (checkStr.equals("Simple")){
            storyID = getResources().openRawResource(R.raw.madlib0_simple);
        }
        else if (checkStr.equals("Tarzan")){
            storyID = getResources().openRawResource(R.raw.madlib1_tarzan);
        }
        else if (checkStr.equals("University")){
            storyID = getResources().openRawResource(R.raw.madlib2_university);
        }
        else if (checkStr.equals("Clothes")){
            storyID = getResources().openRawResource(R.raw.madlib3_clothes);
        }
        else if (checkStr.equals("Dance")){
            storyID = getResources().openRawResource(R.raw.madlib4_dance);
        }
    }

    public class ButtonOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Story story = new Story(storyID);
            Intent intentInput = new Intent(MainActivity.this, WordsfillActivity.class);
            intentInput.putExtra("story", story);
            startActivity(intentInput);
        }
    }
}

