/* Android Praktikum assignment 2.

Reference:
https://developer.android.com/training/basics/fragments/index.html

License:
Copyright 2015 Manit Kumar

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package com.android.manit.fragments;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
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

/*
This function changes the the image using the index of the array of images
*/
    @Override
    public void respond(int index) {
        imageViewer = (ImageViewer) manager.findFragmentById(R.id.imageViewerId);
        //Check for potrait mode. If imageViewer fragment is present the screen is in landscape mode
        if(imageViewer != null && imageViewer.isVisible()){
            imageViewer.changeImage(index);
        }
        else{
            //The screen is in potrait mode, call the potraitactivity class
            Intent intent = new Intent(this, PotraitActivity.class);
            intent.putExtra("index",index);
            startActivity(intent);
        }
    }
}
