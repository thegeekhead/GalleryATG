package com.example.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    GalleriesAdapter imagesAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_home,container,false);
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        GalleryViewModel galleryViewModel = new GalleryViewModel();

        galleryViewModel.getPost().observe(getActivity(), new Observer<Gallery>() {

            @Override
            public void onChanged(Gallery gallery) {
                imagesAdapter = new GalleriesAdapter(getContext(), gallery);
                recyclerView.setAdapter(imagesAdapter);
            }
        });
        return view;
    }

}