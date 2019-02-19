package com.vitalytyrenko.inbox;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MessageActivity extends AppCompatActivity {

    TextView titleTextView;
    TextView contentTextView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        titleTextView = (TextView) findViewById(R.id.title_text_view2);
        contentTextView = (TextView) findViewById(R.id.content_text_view2);
        imageView = (ImageView) findViewById(R.id.image_view2);

        Intent intent = getIntent();

        titleTextView.setText(intent.getStringExtra(MainActivity.KEY1));
        if (intent.getStringExtra(MainActivity.KEY1) == null
                || intent.getStringExtra(MainActivity.KEY1).isEmpty()) {
            titleTextView.setText(R.string.email_title_placeholder);
        }
        contentTextView.setText(intent.getStringExtra(MainActivity.KEY2));
        if (intent.getStringExtra(MainActivity.KEY3) != null
                && !intent.getStringExtra(MainActivity.KEY3).isEmpty()) {
            Glide
                    .with(getApplicationContext())
                    .load(intent.getStringExtra(MainActivity.KEY3))
                    .into(imageView);
        }

    }

}
