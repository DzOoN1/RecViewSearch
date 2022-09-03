package com.example.app_3;

import android.provider.ContactsContract;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class DataBase {

    private static DataBase instance;
    private DataBase(){
        if(all_books == null){
        all_books = new ArrayList<Books>();
        all_books.add(new Books(1,"Harry Potter","J.K.Rowling",
                "https://static.chilimovie.com/source/p/2018/03/26/711ed35b-4d1e-42e5-b48a-015a12ba319a.jpg",100,"qwerty 1"));
        all_books.add(new Books(2,"Lord of the rings","J.K.Rowling",
                "https://www.limitedruns.com/media/cache/8c/40/8c4049deba364f4f72f521022866f472.jpg",200,"qwerty 2"));
        all_books.add(new Books(3,"Spiderman","J.K.Rowling",
                "https://www.limitedruns.com/media/cache/94/85/94859449d9b3393916e167571930de02.jpg",300,"qwerty 3"));
        all_books.add(new Books(4,"Batman","J.K.Rowling",
                "https://2.bp.blogspot.com/-At489fc84Mg/VfUw6rRp_OI/AAAAAAAAEHc/8VAXyulXX1M/s1600/FILM_01.jpg",400,"qwerty 4"));
        all_books.add(new Books(5,"Captain America","J.K.Rowling",
                "https://picfiles.alphacoders.com/348/348605.jpg",500,"qwerty 5"));
        all_books.add(new Books(6,"Wolverine","J.K.Rowling",
                "https://infoforumworld.files.wordpress.com/2020/04/xbdo8evznutiy0z6sm9fzpnr2p3.jpg?w=683",600,"qwerty 6"));
        all_books.add(new Books(7,"Wolferstein","J.K.Rowling",
                "https://cdn.vox-cdn.com/thumbor/OTFnqtc4rXpiwPY-gjxK8k87Rf8=/0x0:1920x1080/1200x800/filters:focal(749x144:1055x450)/cdn.vox-cdn.com/uploads/chorus_image/image/66995613/harrypotter.0.jpg",700,"qwerty 7"));
        all_books.add(new Books(8,"Hawk Eye","J.K.Rowling",
                "https://image.tmdb.org/t/p/original/iGoXIpQb7Pot00EEdwpwPajheZ5.jpg",800,"qwerty 8"));}

        if(read_books == null){
        read_books = new ArrayList<Books>();}
        if(not_read_books == null){
        not_read_books = new ArrayList<Books>();}



    }
    public static synchronized DataBase getInstance(){
        if(instance != null){
            return instance;
        }
        else {
            instance = new DataBase();
            return instance;
        }
    }

    private static ArrayList<Books> all_books;
    private static ArrayList<Books> read_books;
    private static ArrayList<Books> not_read_books;

    public static ArrayList<Books> getAll_books() {
        return all_books;
    }

    public static ArrayList<Books> getRead_books() {
        return read_books;
    }

    public static ArrayList<Books> getNot_read_books() {
        return not_read_books;
    }

    public static Books getBookById(int id){
        for(Books b:all_books){
            if(b.getId() == id)
            {
                return b;
            }
        }
        return null;
    }
    public boolean ExistInReadBooks(Books book){
        for(Books b:read_books){
            if(b.getId() == book.getId())
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        return false;
    }
    public boolean ExistInNotReadBooks(Books book){
        for(Books b:not_read_books){
            if(b.getId() == book.getId()){
                return true;
            }
            else
            {
                return false;
            }

        }
        return false;
    }
    public boolean AddToReadBooks(Books book){
        return read_books.add(book);
    }
    public boolean AddToNotReadBooks(Books book){
        return not_read_books.add(book);
    }
    public boolean DeleteFromReadBooks(Books book){
        return read_books.remove(book);

    }
    public boolean DeleteFromNotReadBooks(Books book){
        return not_read_books.remove(book);
    }



}
