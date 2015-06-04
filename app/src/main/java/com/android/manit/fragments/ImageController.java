package com.android.manit.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

/**
 * Created by manit on 21/05/15.
 * This class is responsible for the list of images.
 */
public class ImageController extends Fragment implements AdapterView.OnItemClickListener{
    ListView imageList;
    Communicator communicator;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.image_controller, container, false);
        imageList = (ListView) view.findViewById(R.id.imagelistView);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),R.array.images,android.R.layout.simple_list_item_1);
        imageList.setAdapter(adapter);
        imageList.setOnItemClickListener(this);
        return view;
    }

    public void setCommunicator(Communicator communicator) {
        this.communicator = communicator;
    }

    //Call to the respond method to change the image
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        communicator.respond(position);
    }

    //Interface for the main activity to loose coupling between image controller and image viewer class
    public interface Communicator{
        public void respond(int index);
    }
}
