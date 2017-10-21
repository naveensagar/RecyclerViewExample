package com.example.test.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by Naveen on 21/10/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    List<Word> data= Collections.emptyList();
    private int mColor;

    public RecyclerViewAdapter(Context context, List<Word> data, int color) {
        inflater = LayoutInflater.from(context);
        this.data = data;
        mColor = color;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Word currentWord = data.get(position);

        holder.linearLayout.setBackgroundResource(mColor);
        holder.defaultTextView.setText(currentWord.getDefaultTranslation());
        holder.miwokTextview.setText(currentWord.getMiwokTranslation());
        holder.imageView.setImageResource(currentWord.getImageResourceId());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        LinearLayout linearLayout;
        //TextView in the list_item.xml layout with the ID miwok_text_view.
        TextView miwokTextview;

        //TextView in the list_item.xml layout with the ID default_text_view.
        TextView defaultTextView;

        //ImageView in the list_item.xml layout with the ID image
        ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);

            miwokTextview = (TextView) itemView.findViewById(R.id.miwok_text_view);
            defaultTextView = (TextView) itemView.findViewById(R.id.default_text_view);
            imageView = (ImageView) itemView.findViewById(R.id.image);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.text_container);
        }
    }
}
