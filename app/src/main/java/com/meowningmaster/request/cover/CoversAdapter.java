package com.meowningmaster.request.cover;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.meowningmaster.request.Listeners;
import com.meowningmaster.request.R;

public class CoversAdapter extends RecyclerView.Adapter<CoversAdapter.ViewHolder>{
    private Covers covers;
    private Listeners.ItemClickListener itemClickListener;

    public CoversAdapter(Covers covers, Listeners.ItemClickListener itemClickListener) {
        this.covers = covers;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cover, viewGroup, false);
        return new CoversAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Cover cover = covers.get(i);

        viewHolder.image.setImageBitmap(cover.getImage().asBitmap());
        viewHolder.title.setText(cover.getTitle());
    }

    @Override
    public int getItemCount() {
        return covers.count();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView image;
        TextView title;
        CardView card;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.item_cover__image);
            title = itemView.findViewById(R.id.item_cover__title);
            card = itemView.findViewById(R.id.item_cover__card);

            card.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v, getAdapterPosition());
        }
    }
}
