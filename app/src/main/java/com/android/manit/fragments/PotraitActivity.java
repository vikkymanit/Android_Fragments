package com.android.manit.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by manit on 21/05/15.
 */
public class PotraitActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.potrait_activity);

        Intent intent = getIntent();
        int index = intent.getIntExtra("index", 0);

        ImageViewer imageViewer = (ImageViewer) getFragmentManager().findFragmentById(R.id.imageViewerId);
        if(imageViewer != null)
            imageViewer.changeImage(index);
    }
}
