package com.example.gallery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.net.URL;
import java.util.List;


public class GalleriesAdapter extends RecyclerView.Adapter<GalleriesAdapter.GalleryViewHolder> {

    Context mCtx;
    Gallery gallery;

    public GalleriesAdapter(Context mCtx, Gallery gallery) {
        this.mCtx = mCtx;
        this.gallery = gallery;
    }

    @NonNull
    @Override
    public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_layout, parent, false);
        return new GalleryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewHolder holder, int position) {
        //Gallery gallery = (Gallery) galleryList.get(position);

        Glide.with(mCtx)
                .load(gallery.getPhotos().getPhoto().get(position).getUrlS())
                .into(holder.imageView);


        holder.textView.setText(gallery.getPhotos().getPhoto().get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return gallery.getPhotos().getPhoto().size();
    }

    public class GalleryViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public GalleryViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }
    }

}
