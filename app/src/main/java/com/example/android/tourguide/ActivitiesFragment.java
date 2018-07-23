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
public class ActivitiesFragment extends Fragment {


    public ActivitiesFragment() {
    // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
     Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.list_blueprint, container, false);

    //Creates GuideWord ArrayList for this fragment
    final ArrayList<GuideWord> location = new ArrayList<GuideWord>();
    location.add(new GuideWord(
        getString(R.string.bananas_location),
        getString(R.string.bananas_feature),R.drawable.bananas));
    location.add(new GuideWord(
        getString(R.string.spin_city_location),
        getString(R.string.spin_city_feature), R.drawable.spin_city));
    location.add(new GuideWord(
        getString(R.string.botan_gardens_location),
        getString(R.string.botan_gardens_feature), R.drawable.botanical_gardens));
    location.add(new GuideWord(
        getString(R.string.gj_motor_speed_location),
        getString(R.string.gj_motor_speed_feature), R.drawable.gj_motor_speedway));
    location.add(new GuideWord(
        getString(R.string.west_co_dragway_location),
        getString(R.string.west_co_dragway_feature), R.drawable.west_co_dragway));
    location.add(new GuideWord(
        getString(R.string.co_nat_monument_location),
        getString(R.string.co_nat_monument_feature), R.drawable.co_nat_monument));
    location.add(new GuideWord(
        getString(R.string.gnd_mesa_nat_forest_location),
        getString(R.string.gnd_mesa_nat_forest_feature), R.drawable.grand_mesa));
    location.add(new GuideWord(
        getString(R.string.island_acres_location),
        getString(R.string.island_acres_feature), R.drawable.island_acres));
    location.add(new GuideWord(
        getString(R.string.highline_state_park_location),
        getString(R.string.highline_state_park_feature), R.drawable.highline_lake));
    location.add(new GuideWord(
        getString(R.string.rafting_tours_location),
        getString(R.string.rafting_tours_feature), R.drawable.rafting));
    location.add(new GuideWord(
        getString(R.string.gj_parks_rec_location),
        getString(R.string.gj_parks_rec_feature), R.drawable.parks_rec));
    location.add(new GuideWord(
        getString(R.string.glacier_location),
        getString(R.string.glacier_feature), R.drawable.glacier));

    // Creates an {@link ArrayAdapter}, whose data source is a list of Strings. The
    // adapter knows how to create layouts for each item in the list, using the
    // layout resource defined in the Android framework.
    // This list construct layout contains a single {@link TextView}, which the adapter will
    // set to display a single word.
    GuideWordAdapter adapter = new GuideWordAdapter(getActivity(),
    location, R.color.category_activities);

    // Finds the {@link ListView} object in the view heirarchy of the {@link Activity}.
    // There is a {@link ListView} with the view id: list_view which is declared in
    // the list_blueprint.xml file
    ListView listView = rootView.findViewById(R.id.list_view);

    // Makes the{@link ListView} use the {@link ArrayAdapter} so the {@link ListView} will display
    // list items for each location in the GuideWord list.
    // This is done by calling the setAdapter method on the {@link ListView} object and pass in
    // 1 argument, which is the {@link ArrayAdapter} with the variable name adapter.
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
