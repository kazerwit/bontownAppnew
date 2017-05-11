package com.bontown;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;


public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;
    String[] leftColumn, rightColumn;
    View view1;
    ViewHolder viewHolder1;
    TextView textView;


    public Adapter(Context context1, String[] Values1, String[] Values2) {
        leftColumn = Values1;
        rightColumn = Values2;
        context = context1;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textView1, textView2;

        public ViewHolder(View v){

            super(v);

            textView1 = (TextView)v.findViewById(R.id.artist_textview);
            textView2 = (TextView)v.findViewById(R.id.album_textview);
        }
    }


    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View row=inflater.inflate(R.layout.custom_row,parent,false);
        viewHolder1 = new ViewHolder(view1);
        return viewHolder1;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){

        holder.textView1.setText(leftColumn[position]);
        holder.textView2.setText(rightColumn[position]);
    }

    @Override
    public int getItemCount() {
        return leftColumn.length;
    }


}
