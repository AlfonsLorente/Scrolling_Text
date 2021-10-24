package com.example.scrolling_text;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private static final String FILENAME = "app/src/main/res/text/article.txt";
    private String mArticleText;
    TextView mArticle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mArticleText = getArticle();
        mArticle = (TextView) findViewById(R.id.article);
        mArticle.setText(mArticleText);

    }

    private String getArticle() {
        String text = "";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILENAME))) {

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                text = text + " " + line;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }
}