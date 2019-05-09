package com.example.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class WordsfillActivity extends AppCompatActivity {

    Story story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wordsfill);
        Intent intent = getIntent();
        story = (Story) intent.getSerializableExtra("story");
        updateLayout();

    }

    public void fillWord(View view) {
        EditText et = findViewById(R.id.editText);
        String Text = et.getText().toString();
        story.fillInPlaceholder(Text);
        et.setText("");
        updateLayout();
        if (story.isFilledIn()) {
            Intent intentInput = new Intent(WordsfillActivity.this, EndActivity.class);
            intentInput.putExtra("story", story);
            startActivity(intentInput);
            finish();
        }

    }

    public void updateLayout() {
        int count = story.getPlaceholderRemainingCount();
        TextView tv2 = findViewById(R.id.textView2);
        tv2.setText("words remaining: " + count);

        String fill = story.getNextPlaceholder();
        TextView tv3 = findViewById(R.id.textView3);
        tv3.setText("word to be filled in next: " + fill);

    }
}
