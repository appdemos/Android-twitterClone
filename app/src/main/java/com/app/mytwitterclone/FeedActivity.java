package com.app.mytwitterclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FeedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        ListView listView = findViewById(R.id.feedListView);
        List<Map<String,String>> tweetData = new ArrayList<>();

        ParseQuery<ParseObject> query =


        for (String tweet:
             ) {

        }

        ParseUser.getCurrentUser().getList("isFollowing");

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, tweetData, android.R.layout.simple_list_item_2, new String[]{"content", "username"}, new int[]{android.R.id.text1,android.R.id.text2});



    }
}
