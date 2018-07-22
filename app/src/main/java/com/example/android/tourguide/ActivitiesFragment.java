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
        "2469 Riverside Parkway  https://www.bananasfunpark.com",
        "Bananas Family Fun Park",R.drawable.bananas));
    location.add(new GuideWord(
        "637 24 1/2 Road  https://spincitygj.com",
        "Spin City Family Fun Center", R.drawable.spin_city));
    location.add(new GuideWord(
        "655 Struthers Avenue  " +
        "https://westerncoloradobotanicalgardens.org",
        "Western Colorado Botanical Gardens", R.drawable.botanical_gardens));
    location.add(new GuideWord(
        "3002 N I70 Frontage Road  https://grandjunctionmotorspeedway.com",
        "GJ Motor Speedway Kart Racing", R.drawable.gj_motor_speedway));
    location.add(new GuideWord(
        "115 32 Road  https://wcrda.com",
        "Western Colorado Dragway", R.drawable.west_co_dragway));
    location.add(new GuideWord(
        "Rimrock Drive  https://www.nps.gov/colm/index.htm",
        "Colorado National Monument", R.drawable.co_nat_monument));
    location.add(new GuideWord(
        "Delta, Garfield, and Mesa Counties  https://www.fs.usda.gov/gmug",
        "Grand Mesa National Forest/Mesa Lakes", R.drawable.grand_mesa));
    location.add(new GuideWord(
        "1055 I-70  http://cpw.state.co.us/placestogo/Parks/jamesmrobbcoloradoriver",
        "Island Acres State Park Camping/RVs/Swimming", R.drawable.island_acres));
    location.add(new GuideWord(
        "1800 11 8/10 Road  " +
        "https://www.colorado.com/state-parks/highline-lake-state-park",
        "Highline Lake State Park Camping/RVs/Boating/Swimming", R.drawable.highline_lake));
    location.add(new GuideWord(
        "https://www.visitgrandjunction.com/guided-rafting-float-tours",
        "River Rafting/Float Tours", R.drawable.rafting));
    location.add(new GuideWord(
        "https://www.gjcity.org/residents/parks-recreation/",
        "Grand Junction Parks and Recreation", R.drawable.parks_rec));
    location.add(new GuideWord(
        "2525 Riverside Parkway  https://www.glaciericearena.net",
        "Glacier Ice Arena", R.drawable.glacier));

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
