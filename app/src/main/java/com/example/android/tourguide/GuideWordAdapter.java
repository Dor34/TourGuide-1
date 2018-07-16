package com.example.android.tourguide;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GuideWordAdapter  extends ArrayAdapter<GuideWord> {

    //Resource ID for BG Color for this list
    private int mColorResourceId;

    public GuideWordAdapter (Activity context, ArrayList<GuideWord> location, int mColorResourceId){

        super(context, 0, location);
        mColorResourceId = colorResourceId;
    }
@NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //check if existing view is in use else inflate view
    View listConstructView=convertView;

    if (listConstructView) == null) {
        listConstructView= LayoutInflater.from(getContext()).inflate(R.layout.list_construct, parent, false);}
        //get guide word at this index position
        GuideWord currentLocation =getItem(position);

        //Locate Feature XML TextView from list_construct via R.id
        TextView FeatureView=(TextView) listConstructView.findViewById(R.id.feature_text_view);
        //Get View from GuideWordAdapter and set view with Feature GuideWord
        FeatureView.setText(currentLocation.getFeatureData());

        // Locate Location XML TextView from list_construct via R.id
        TextView LocationView=(TextView) listConstructView.findViewById(R.id.location_text_view);
        //Get View from GuideWordAdapter and set with Location GuideWord
        LocationView.setText(currentLocation.getLocationData());

        //Locate Image from list_construct via R.drawable ID
        ImageView imageView=(ImageView) listConstructView.findViewById(R.id.construct_image);
        if (currentLocation.hasImage()){
            //Set ImageView with current image
            imageView.setImageResource(currentLocation.getImageResourceId());
            //Make sure View is visible
            imageView.setVisibility(View.VISIBLE);}
            else{
                //Otherwise hide ImageView (set visibility to GONE
                imageView.setVisibility(View.GONE);

                //Set theme color for the List Construct
                View constructText=listConstructView.findViewById(R.id.construct_text);
                //Find color resource id maps to
                int color= ContextCompat.getColor(getContext(),mColorResourceId );
                constructText.setBackgroundColor(color);

                //Return multi-element TextView list layout for display in ListView R.id.location_text_view
                return LocationView;
            }
        }
    }
}
