package com.example.app_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class NotReadActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecViewAdapter adapter = new RecViewAdapter(this,DataBase.getNot_read_books());


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_read);
        recyclerView = (RecyclerView) findViewById(R.id.NR_recyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}