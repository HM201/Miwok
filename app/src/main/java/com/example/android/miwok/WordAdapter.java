package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Hisham on 2/9/2018.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private int categoryColor;
//    private MediaPlayer audio;
    public WordAdapter(Activity context, ArrayList<Word> words, int categoryColor){
        //call the parent constructor with "0" value because we are trying to overload the TextView into multiple views
        super(context,0,words);
        this.categoryColor = categoryColor;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //check if existing view is being reused, otherwise inflate it
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        //get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        //get the LinearLayout for the listItem with the ID linearLayout
        LinearLayout linearLayout = (LinearLayout) listItemView.findViewById(R.id.linearLayout);
        //Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), categoryColor);
        //set the linear layout color to the given color
        linearLayout.setBackgroundColor(color);
//
//        audio = MediaPlayer.create(getContext(),currentWord.getAudioResourceID());
//        linearLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                audio.start();
//            }
//        });




        // Find the defaultTextView in the list_view.xml layout with the ID default_text_view
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        //set the text in the default text view
        defaultTextView.setText(currentWord.getDefaultTranslation());


        // Find the miwokTextView in the list_view.xml layout with the ID miwok_text_view
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        //set the text in the miwok text view
        miwokTextView.setText(currentWord.getMiwokTranslation());

        //check if imageExists
        if(currentWord.hasImage()) {
            //find the ImageView in the list_view.xml file with the ID image
            ImageView image = (ImageView) listItemView.findViewById(R.id.image);
            //set the image src to the new image source ID in the currentWord
            image.setImageResource(currentWord.getImageResourceId());
        }
        else {
            //if image does not exist then..

            //find the ImageView in the list_view.xml file with the ID image
            ImageView image = (ImageView) listItemView.findViewById(R.id.image);
            //Hide the image view
            image.setVisibility(View.GONE);
        }
        return listItemView;
    }

}
