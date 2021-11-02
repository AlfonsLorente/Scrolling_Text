package com.example.scrolling_text;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ComentaryInput extends AppCompatActivity {
    private Button mSendButton;
    public static final String EXTRA_MESSAGE = "com.example.scrolling_text.MESSAGE";
    private static String mMessage;
    private TextView mCommentaryText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comentary_input);
        mCommentaryText = (TextView) findViewById(R.id.CommentaryText);
        mSendButton = (Button) findViewById(R.id.sendButton);
        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //EditText CommentaryText = (EditText) findViewById(R.id.CommentaryText);
                //mMessage = CommentaryText.getText().toString();
                Intent intent = new Intent(ComentaryInput.this, MainActivity.class);
                mMessage = mCommentaryText.getText().toString();
                intent.putExtra(EXTRA_MESSAGE, mMessage);

                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }

        });

    }

    public static String getMessage(){
        return mMessage;
    }


}