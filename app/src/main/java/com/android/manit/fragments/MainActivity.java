package com.android.manit.fragments;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity implements ImageController.Communicator{

    ImageController imageController;
    ImageViewer imageViewer;
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getFragmentManager();
        imageViewer = (ImageViewer) manager.findFragmentById(R.id.imageViewerId);
        imageController = (ImageController) manager.findFragmentById(R.id.imageControllerId);
        imageController.setCommunicator(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public void respond(int index) {
        imageViewer = (ImageViewer) manager.findFragmentById(R.id.imageViewerId);
        //Check for potrait mode. If imageViewer fragment is not present the screen is in potrait mode
        if(imageViewer != null && imageViewer.isVisible()){
            imageViewer.changeImage(index);
        }
        else{
            Intent intent = new Intent(this, PotraitActivity.class);
            intent.putExtra("index",index);
            startActivity(intent);
        }
    }
}
