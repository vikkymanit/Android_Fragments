package com.android.manit.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by manit on 21/05/15.
 */
public class ImageViewer extends Fragment{
    ImageView imageView;
    Integer images[] = {R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image5,
                        R.drawable.image6,R.drawable.image7,R.drawable.image8};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.image_viewer,container,false);
        imageView = (ImageView) view.findViewById(R.id.imageView);
        return view;
    }

    public void changeImage(int index) {
        if(imageView != null)
            imageView.setImageResource(images[index]);
    }
}
