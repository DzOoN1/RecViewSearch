package com.example.app_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.*;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {

    ImageView image;
    Button btnAddToReadBooks, btnAddToNotReadBooks;
    TextView txt_BookName, txt_Author, txt_Pages, txt_Description;
    boolean exist_in_readbooks = false, exist_in_notreadbooks = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        image = (ImageView) findViewById(R.id.BA_imageView);
        btnAddToReadBooks = (Button) findViewById(R.id.btn_AddToReadBooks);
        btnAddToNotReadBooks = (Button) findViewById(R.id.btn_AddToNotReadBooks);
        txt_BookName = (TextView) findViewById(R.id.txt_BookName);
        txt_Author = (TextView) findViewById(R.id.txt_Author);
        txt_Pages = (TextView) findViewById(R.id.txt_Pages);
        txt_Description = (TextView) findViewById(R.id.txt_Description);

        if(exist_in_readbooks){
            btnAddToReadBooks.setEnabled(false);
        }
        if(exist_in_notreadbooks){
            btnAddToNotReadBooks.setEnabled(false);
        }



        Intent intent = getIntent();
        if(intent != null){
        int id = intent.getIntExtra("ID",-1);
        if(id != -1){
           if( DataBase.getBookById(id) != null)
            {
                Books currentBook = DataBase.getBookById(id);
                Glide.with(this).asBitmap().load(currentBook.getImg_URL()).into(image);
                txt_BookName.setText(currentBook.getBook_Name());
                txt_Author.setText(currentBook.getBook_Author());
                txt_Pages.setText(String.valueOf(currentBook.getPages()));
                txt_Description.setText(currentBook.getDescription());
               // checkButton1(currentBook);
               // checkButton2(currentBook);
                ArrayList<Books> read = DataBase.getRead_books();
                ArrayList<Books> not_read = DataBase.getNot_read_books();

                for(Books b:read){
                    if(b.getId() == currentBook.getId())
                    {
                        btnAddToReadBooks.setEnabled(false);
                    }
                }
                for(Books b:not_read){
                    if(b.getId() == currentBook.getId())
                    {
                        btnAddToNotReadBooks.setEnabled(false);
                    }
                }
                btnAddToReadBooks.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        DataBase.getInstance().AddToReadBooks(currentBook);
                     //   btnAddToReadBooks.setEnabled(false);
                        btnAddToReadBooks.setEnabled(false);
                        //exist_in_readbooks = true;
                    }
                });
                btnAddToNotReadBooks.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        DataBase.getInstance().AddToNotReadBooks(currentBook);
                     //   btnAddToNotReadBooks.setEnabled(false);
                        btnAddToNotReadBooks.setEnabled(false);
                      //  exist_in_notreadbooks = true;
                    }
                });












            }

        }
    }}

    private void checkButton2(Books book) {
        if(DataBase.getInstance().ExistInReadBooks(book)){
           btnAddToNotReadBooks.setEnabled(false);
        }
    }

    private void checkButton1(Books book) {
        if(DataBase.getInstance().ExistInNotReadBooks(book)){
            btnAddToReadBooks.setEnabled(false);
        }

    }
}