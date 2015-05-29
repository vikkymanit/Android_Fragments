package com.android.manit.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by manit on 21/05/15.
 * This class handles the potrait activity
 */
public class PotraitActivity extends Activity {
    private int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.potrait_activity);

        Intent intent = getIntent();
        index = intent.getIntExtra("index", 0);

        ImageViewer imageViewer = (ImageViewer) getFragmentManager().findFragmentById(R.id.imageViewerId);
        if(imageViewer != null)
            imageViewer.changeImage(index);
    }
}
