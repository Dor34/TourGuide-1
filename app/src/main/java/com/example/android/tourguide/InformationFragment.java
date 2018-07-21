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
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class InformationFragment extends Fragment {

    public InformationFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_blueprint, container, false);

        //Creates GuideWord ArrayList for this fragment
        final ArrayList<GuideWord> location = new ArrayList<GuideWord>();
        location.add(new GuideWord(
                "https://coloweedery.com/learn/",
                "Responsible Consumption of Cannabis:\nIMPORTANT guidelines regarding " +
                        "responsible and legally compliant\ncannabis possession and consumption as" +
                        " a guest in our state\nCourtesy of Colorado Weedery"));
        location.add(new GuideWord(
                "https://www.tumbleweed420.com/location/parachute",
                "10 things Colorado Tourists need to know" +
                        "\n about Dispensary Etiquette"));
        location.add(new GuideWord(
                "https://www.outtherecolorado.com/gallery/17-things-know-visiting-colorado/",
                "17 things you need to know before visiting Colorado"));
        location.add(new GuideWord(
                "https://countryjam.com",
                "Country Jam Information"));
        location.add(new GuideWord(
                "https://www.western-co.com/rock-jam-colorado/",
                "Rock Jam"));
        location.add(new GuideWord(
                "https://www.visitgrandjunction.com/events/festivals-fairs",
                "Grand Junction Events and Festival Information"));
        location.add(new GuideWord(
                "https://www.visitgrandjunction.com/hiking-trails",
                "Grand Junction Hiking Trails"));
        location.add(new GuideWord(
                "https://mix1043fm.com/free-camping-grand-junction/",
                "Free Camping In Grand Junction" +
                        "(Please refer to 17 Things You Need To Know.. list item above"));
        location.add(new GuideWord(
                "https://cpw.state.co.us",
                "Colorado Parks & Wildlife\nHunting & Fishing Licenses & Information"));

        // Creates an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will
        // set to display a single word.
        GuideWordAdapter adapter = new GuideWordAdapter(getActivity(), location, R.color.category_information);

        // Finds the {@link ListView} object in the view heirarchy of the {@link Activity}.
        // There is be a  {@link ListView} with the view id named list which is declared in
        // the word_list.xml file
        ListView listView = (ListView) rootView.findViewById(R.id.list_view);

        // Makes the{@link ListView} use the {@link ArrayAdapter} so the {@link ListView} will display
        // list items for each word in the word list.
        // This is done by calling the setAdapter method on the {@link ListView} object and pass in 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
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
