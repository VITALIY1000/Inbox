package com.vitalytyrenko.inbox;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements EmailAdapter.EmailItemClicked {

    public static final String KEY1 = "TITLE_TEXT";
    public static final String KEY2 = "CONTENT_TEXT";
    public static final String KEY3 = "IMAGE_URL";
    public static List<EmailItem> list = generateEmailList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SendActivity.class);
                startActivity(intent);
            }
        });

        RecyclerView emailRecycler = findViewById(R.id.email_recycler_view);
        emailRecycler.setLayoutManager(new LinearLayoutManager(this));
        EmailAdapter emailAdapter = new EmailAdapter(list, this);
        emailRecycler.setAdapter(emailAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        RecyclerView emailRecycler = findViewById(R.id.email_recycler_view);
        emailRecycler.setLayoutManager(new LinearLayoutManager(this));
        EmailAdapter emailAdapter = new EmailAdapter(list, this);
        emailRecycler.setAdapter(emailAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void itemClickedCallback(int itemPosition) {
        Intent intent = new Intent(MainActivity.this, MessageActivity.class);
        intent.putExtra(KEY1, list.get(itemPosition).getTitle());
        intent.putExtra(KEY2, list.get(itemPosition).getContent());
        intent.putExtra(KEY3, list.get(itemPosition).getImageURL());
        startActivity(intent);
    }

    private static List<EmailItem> generateEmailList() {
        List<EmailItem> list = new ArrayList<>();
        list.add(new EmailItem("Alex Buranov", "consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoqu", "15s", "https://bipbap.ru/wp-content/uploads/2017/07/5-1.jpg"));
        list.add(new EmailItem("Mike Street", "etuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis", "20m", "https://bipbap.ru/wp-content/uploads/2017/07/24328.jpg"));
        list.add(new EmailItem("Lucas 9-9",  "ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis", "55m", "https://bipbap.ru/wp-content/uploads/2017/07/38055168.jpg"));
        list.add(new EmailItem("Amazon Rose", "Thanks for accepting my connection, it’s great to have someone with similar interests in my network!", "1h", "https://bipbap.ru/wp-content/uploads/2017/07/image_411005152042031573416.jpg"));
        list.add(new EmailItem("Kazi Ahmed", "Lorem impus... WHAT???!!!", "4h", ""));
        list.add(new EmailItem("New letter",  "Thanks for accepting my connection, it’s great to have someone with similar interests in my network!", "2d", ""));
        list.add(new EmailItem(null,  "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, ", "2d", ""));
        list.add(new EmailItem("Pushpendra Yad",  "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, ", "2d", ""));

        list.add(new EmailItem("Alex Buranov",  "consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoqu", "3d", "https://bipbap.ru/wp-content/uploads/2017/07/5-1.jpg"));
        list.add(new EmailItem("Mike Street",  "etuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis", "3d", "https://bipbap.ru/wp-content/uploads/2017/07/24328.jpg"));
        list.add(new EmailItem("Lucas 9-9",  "ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis", "3d", "https://bipbap.ru/wp-content/uploads/2017/07/38055168.jpg"));
        list.add(new EmailItem("Amazon Rose",  "Thanks for accepting my connection, it’s great to have someone with similar interests in my network!", "3d", "https://bipbap.ru/wp-content/uploads/2017/07/image_411005152042031573416.jpg"));
        list.add(new EmailItem("Kazi Ahmed",  "Lorem impus... WHAT???!!!", "3d", ""));
        list.add(new EmailItem("New letter",  "Thanks for accepting my connection, it’s great to have someone with similar interests in my network!", "3d", ""));
        list.add(new EmailItem(null,  "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, ", "3d", ""));
        list.add(new EmailItem("Pushpendra Yad",  "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, ", "4d", ""));
        return list;
    }

    public static void addMessage(EmailItem el) {
        list.add(el);
    }
}
