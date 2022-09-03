package com.example.app_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class ReadBooksActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecViewAdapter adapter = new RecViewAdapter(this,DataBase.getRead_books());


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_books);

        recyclerView = (RecyclerView) findViewById(R.id.RB_recycelerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}