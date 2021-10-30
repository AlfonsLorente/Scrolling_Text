package com.example.scrolling_text;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    //private static final String FILENAME = "app/src/main/res/raw/article.txt";
    //private StringBuffer mArticleText;
    //TextView mArticle;
    private static final String KEY_INDEX = "index";
    private LinearLayout linearLayout;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt(KEY_INDEX, 0);
        }
        linearLayout = (LinearLayout)findViewById(R.id.linearLayoutTextView);
        //mArticleText = getArticle();

        if(counter > 0) {
            createTextView();
        }
        //mArticle = (TextView) findViewById(R.id.article);
        //mArticle.setMovementMethod(new ScrollingMovementMethod());
        //mArticle.setText(mArticleText);


    }

    private void createTextView() {
        Intent intent = getIntent();
        String message = intent.getStringExtra(CommentaryInput.EXTRA_MESSAGE);
        TextView textView = new TextView(this);
        textView.setText("Commentary: " + "\n" + message + "\n");
        linearLayout.addView(textView);

    }


    public void writeCommentary(View view) {
        counter++;
        Intent intent = new Intent(this, CommentaryInput.class);
        startActivity(intent);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(KEY_INDEX, counter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Pene", "Me mueroooo");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Pene", "Me pausooo");
    }

/*
    private StringBuffer getArticle() {
        StringBuffer stringBuffer = new StringBuffer();
        InputStream inputStream = this.getResources().openRawResource(R.raw.article);

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {

            String data;

            while ((data = bufferedReader.readLine()) != null) {
                stringBuffer.append(data + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuffer;

    }
    */

}