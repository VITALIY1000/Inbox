package com.vitalytyrenko.inbox;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SendActivity extends AppCompatActivity {

    EditText editText1;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editText1 = (EditText) findViewById(R.id.send_title_text);
        editText2 = (EditText) findViewById(R.id.send_content_text);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = editText1.getText().toString();
                String content = editText2.getText().toString();
                MainActivity.addMessage(new EmailItem(title, content, "1s", ""));

                editText1.setText("");
                editText2.setText("");

                Toast toast = Toast.makeText(getApplicationContext(),
                        R.string.sending_toast, Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

}
