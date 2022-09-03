package com.example.app_3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.SearchView;

import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;
import java.util.Locale;

public class AllBooksActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecViewAdapter adapter;
    MaterialToolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);
        recyclerView = (RecyclerView) findViewById(R.id.ab_recyclerView);
        toolbar = (MaterialToolbar) findViewById(R.id.AB_toolbar);
        setSupportActionBar(toolbar);
        adapter = new RecViewAdapter(AllBooksActivity.this,DataBase.getAll_books());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        MenuItem menuItem = menu.findItem(R.id.toolbar_search);
        android.widget.SearchView searchView = (android.widget.SearchView) menuItem.getActionView();
        searchView.setQueryHint("Type here to search....");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter = new RecViewAdapter(AllBooksActivity.this,filter(s));
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(AllBooksActivity.this));
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    private  ArrayList<Books>  filter(String text) {

        ArrayList<Books> filteredlist = new ArrayList<Books>();


        for(Books b:DataBase.getAll_books()) {
            if (b.getBook_Name().toLowerCase().contains(text.toLowerCase())) {
                filteredlist.add(b);
            }

        }
        if(filteredlist == null) {
            return DataBase.getAll_books();
        }
        return filteredlist;
        }



}