package com.example.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class EndActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        Intent intent = getIntent();
        Story story = (Story) intent.getSerializableExtra("story");
        TextView finalStory = findViewById(R.id.textView5);
        finalStory.setText(story.toString());

    }

    public void backToStart(View view) {
//        Intent intentInput = new Intent(EndActivity.this, MainActivity.class);
//        startActivity(intentInput);
        finish();
    }
}
