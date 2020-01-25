package com.example.android1hometask5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<ViewHolder> {

    ArrayList <String> list;
    public MainAdapter(){
        list = new ArrayList<>();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_holder, parent,false);

      return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setText(list.get(position));
    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addText(String text){
        list.add(text);
        notifyDataSetChanged();
    }


}
