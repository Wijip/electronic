package com.example.electronic;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class elecViewHolder extends RecyclerView.ViewHolder {
    public ImageView Gambar;
    public TextView Nama;
    public TextView Harga;
    public CardView card;

    public elecViewHolder(View inflate) {
        super(itemView);
        Nama = itemView.findViewById(R.id.nama);
        Harga = itemView.findViewById(R.id.harga);
        Gambar = itemView.findViewById(R.id.gambar);

        card = itemView.findViewById(R.id.cardelectronic);

    }
}
