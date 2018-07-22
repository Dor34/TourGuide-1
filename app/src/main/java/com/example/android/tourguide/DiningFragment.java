package com.example.android.tourguide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiningFragment extends Fragment {

    public DiningFragment() {
    // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
     Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.list_blueprint, container, false);

    //Creates GuideWord ArrayList for this fragment
    final ArrayList<GuideWord> location = new ArrayList<GuideWord>();
    location.add(new GuideWord(
        "https://visitpalisade.com/wineries-and-spirits/",
        "Palisade Wineries -Reservations Recommended",R.drawable.wineries));
    location.add(new GuideWord(
        "https://www.randyssouthsidediner.com",
        "Randy's Southside Diner\n2430 North Avenue", R.drawable.randys_ssd));
    location.add(new GuideWord(
        "https://www.mainstreetcafegj.com",
        "Main Street Cafe\n504 Main Street", R.drawable.main_street_cafe));
    location.add(new GuideWord(
        "https://www.facebook.com/Pufferbelly-Restaurant-638880192855626/",
        "Pufferbelly Station Restaurant\n337 South 1st Street", R.drawable.pufferbelly));
    location.add(new GuideWord(
        "https://www.626onrood.com",
        "626 on Rood Modern Cuisine and Winebar\n2430 North Avenue", R.drawable.six_two_six));
    location.add(new GuideWord(
        "https://ilbistroitaliano.com",
        "Il Bistro Italiano\n400 Main Street", R.drawable.il_bistro_italiano));
    location.add(new GuideWord(
        "https://www.bin707.com",
        "Bin 707 Foodbar\n225 North 5th Street", R.drawable.bin_seven_o_seven));
    location.add(new GuideWord(
        "https://gingeroriental.com",
        "Ginger Oriental Restaurant\n2381 Patterson Road", R.drawable.ginger));
    location.add(new GuideWord(
        "https://ribcity.com/rib-city-menu-colorado-grand-junction-fruita-rifle-montrose/",
        "Rib City Grill\n2830 North Avenue", R.drawable.rib_city));
    location.add(new GuideWord(
        "https://www.jctsquare.com",
        "Junct'n Square Pizza\n119 North 7th Street", R.drawable.junct_n_square));
    location.add(new GuideWord(
        "https://fooddudesdelivery.com/grandjunction",
        "Food Dudes Delivery Service", R.drawable.food_dudes));
    location.add(new GuideWord(
        "https://www.grubgofers.com/",
        "Grub Gofers Delivery Service", R.drawable.grub_gofers));

    // Creates an {@link ArrayAdapter}, whose data source is a list of Strings. The
    // adapter knows how to create layouts for each item in the list, using the
    // layout resource defined in the Android framework.
    // This list_construct layout contains a single {@link TextView}, which the adapter will
    // set to display a single word.
    GuideWordAdapter adapter = new GuideWordAdapter(getActivity(),
    location, R.color.category_dining);

    // Finds the {@link ListView} object in the view heirarchy of the {@link Activity}.
    // There is a {@link ListView} with the view id named list_view which is declared in
    // the list_blueprint.xml file
    ListView listView = rootView.findViewById(R.id.list_view);

    // Makes the{@link ListView} use the {@link ArrayAdapter} so the {@link ListView} will display
    // list items for each location in the GuideWord list.
    // This is done by calling the setAdapter method on the {@link ListView} object and
    // pass in 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
    listView.setAdapter(adapter);

    //Sets OnItemClickListener on list_view to monitor item selection
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

    //Gets item selected index position
    GuideWord guideword = location.get(position);

    //Shows location status currently present in selected index position for this activity via Toast message
    Toast.makeText(getContext(),"List Item Selected:"+ guideword , Toast.LENGTH_LONG).show();
        }
    });

    return rootView;
    }

}
