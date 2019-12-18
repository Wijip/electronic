package com.example.electronic;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DoesAdapter extends RecyclerView.Adapter<DoesAdapter.MyViewHolder> {
    Context context;
    ArrayList<ToDo> toDo;

    public DoesAdapter(Context c, ArrayList<ToDo> p)
    {
        context = c;
        toDo = p;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_menu,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return toDo.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView titledoes,descdoes,datedoes,keydoes;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            titledoes = itemView.findViewById(R.id.titledoes);
            descdoes = itemView.findViewById(R.id.descdoes);
            datedoes = itemView.findViewById(R.id.datedoes);
        }
    }
}
