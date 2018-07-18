package com.example.android.tourguide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class DispensariesFragment extends Fragment {


    public DispensariesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_blueprint, container, false);

        //Creates GuideWord ArrayList for this fragment
        final ArrayList<GuideWord> location = new ArrayList<GuideWord>();
        location.add(new GuideWord("Palisade Wineries List","https://visitpalisade.com/wineries-and-spirits/ -Reservations Recommended",R.drawable.wineries));
        location.add(new GuideWord("Randy's Southside Diner", "2430 North Avenue", R.drawable.randys_ssd));
        location.add(new GuideWord("Main Street Cafe", "504 Main Street", R.drawable.main_street_cafe));
        location.add(new GuideWord("Pufferbelly Station Restaurant", "337 South 1st Street", R.drawable.pufferbelly));
        location.add(new GuideWord("626 on Rood Modern Cuisine and Winebar", "2430 North Avenue", R.drawable.six_two_six));
        location.add(new GuideWord("Il Bistro Italiano", "400 Main Street", R.drawable.il_bistro_italiano));
        location.add(new GuideWord("Bin 707 Foodbar", "225 North 5th Street", R.drawable.bin_seven_o_seven));
        location.add(new GuideWord("Ginger Oriental Restaurant", "2381 Patterson Road", R.drawable.ginger));
        location.add(new GuideWord("Rib City Grill", "2830 North Avenue", R.drawable.rib_city));
        location.add(new GuideWord("Junct'n Square Pizza", "119 North 7th Street", R.drawable.junct_n_square));
        location.add(new GuideWord("Food Dudes Delivery Service", "fooddudesdelivery.com/grandjunction", R.drawable.food_dudes));
        location.add(new GuideWord("Grub Gofers Delivery Service", "www.grubgofers.com/", R.drawable.grub_gofers));

        // Creates an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will
        // set to display a single word.
        GuideWordAdapter adapter = new GuideWordAdapter(getActivity(), location, R.color.category_dining);

        // Finds the {@link ListView} object in the view heirarchy of the {@link Activity}.
        // There is be a  {@link ListView} with the view id named list which is declared in
        // the word_list.xml file
        ListView listView = (ListView) rootView.findViewById(R.id.list_view);

        // Makes the{@link ListView} use the {@link ArrayAdapter} so the {@link ListView} will display
        // list items for each word in the word list.
        // This is done by calling the setAdapter method on the {@link ListView} object and pass in 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //Logs word status currently present in index position for this activity
                Log.v("Dispensaries Fragment", "Current location:" + location);
            }

        });
        return rootView;
    }


}
