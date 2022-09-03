package com.example.app_3;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class RecViewAdapter extends RecyclerView.Adapter<RecViewAdapter.ViewHolder> {

    Context mContext;
    ArrayList<Books> books;


    public RecViewAdapter(Context mContext, ArrayList<Books> books){
        this.mContext = mContext;
        this.books = books;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_book_activity,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(mContext).asBitmap().load(books.get(position).getImg_URL()).into(holder.image);
        holder.txtBookName.setText(books.get(position).getBook_Name());
        holder.txtAuthor.setText(books.get(position).getBook_Author());
        holder.txtPages.setText(String.valueOf(books.get(position).getPages()));
        holder.txtDescription.setText(books.get(position).getDescription());
        
        if(books.get(position).isExpanded()){
            holder.expandedLayout.setVisibility(View.VISIBLE);
            holder.down_arrow.setVisibility(View.GONE);
        }
        else{
            holder.expandedLayout.setVisibility(View.GONE);
            holder.down_arrow.setVisibility(View.VISIBLE);
        }
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,BookActivity.class);
                intent.putExtra("ID",books.get(position).getId());
                mContext.startActivity(intent);
            }
        });

        if(books == DataBase.getAll_books())
        {
            holder.trash.setVisibility(View.GONE);
        }

        holder.trash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(books == DataBase.getRead_books()){
                    ArrayList<Books> read = DataBase.getRead_books();
                    for(Books b:read){
                        if(b.getId() == books.get(position).getId()){
                            DataBase.getInstance().DeleteFromReadBooks(books.get(position));
                            notifyDataSetChanged();
                        }
                    }
                }

                if(books == DataBase.getNot_read_books()){
                    ArrayList<Books> read = DataBase.getNot_read_books();
                    for(Books b:read){
                        if(b.getId() == books.get(position).getId()){
                            DataBase.getInstance().DeleteFromNotReadBooks(books.get(position));
                            notifyDataSetChanged();
                        }
                    }
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return books.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        private MaterialCardView parent;
        private ImageView image,down_arrow,up_arrow;
        private TextView txtBookName, txtAuthor, txtPages, txtDescription;
        private ImageView trash;
        RelativeLayout expandedLayout;
        MaterialCardView CV_parent;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            parent = itemView.findViewById(R.id.CV_parent);
            image = itemView.findViewById(R.id.CV_image);
            down_arrow = itemView.findViewById(R.id.CV_down_arrow);
            up_arrow = itemView.findViewById(R.id.CV_up_arrow);
            txtBookName = itemView.findViewById(R.id.CV_txt_BookName);
            txtAuthor = itemView.findViewById(R.id.CV_txt_Author);
            txtPages = itemView.findViewById(R.id.CV_txt_Pages);
            txtDescription = itemView.findViewById(R.id.CV_txt_Description);
            trash = itemView.findViewById(R.id.CV_trash);
            expandedLayout = itemView.findViewById(R.id.expandedLayout);
            CV_parent = itemView.findViewById(R.id.CV_parent);

            down_arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Books book = books.get(getAdapterPosition());
                    if(!book.isExpanded()){
                        book.setExpanded(true);
                        notifyDataSetChanged();
                    }
                    else{
                        book.setExpanded(false);
                        notifyDataSetChanged();
                    }
                }
            });
            up_arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Books book = books.get(getAdapterPosition());
                    if(!book.isExpanded()){
                        book.setExpanded(true);
                        notifyDataSetChanged();
                    }
                    else{
                        book.setExpanded(false);
                        notifyDataSetChanged();
                    }
                }
            });






        }
    }
}
