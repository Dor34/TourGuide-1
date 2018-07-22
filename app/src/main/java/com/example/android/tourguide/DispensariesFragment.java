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
        location.add(new GuideWord(
            "https://www.tumbleweed420.com",
            "Tumbleweed Dispensary -De Beque\nMon-Sun 9a-10p" +
                    "\n2185 45 1/2 Road, De Beque CO 81630",R.drawable.tumbleweed_debeque));
        location.add(new GuideWord(
            "https://www.tumbleweed420.com/location/parachute",
            "Tumbleweed -Parachute \nMon-Sun 9a-9p (Drive Thru Th-Sun 3p-11p)" +
                    "\n150 S Columbine Court, Parachute CO 81635", R.drawable.tumbleweed_drive_thru));
        location.add(new GuideWord(
            "https://kgcolorado.com",
            "Kush Gardens \nMon-Sat 9a-8p Sun 9a-7p" +
                    "\n4550 US 6, De Beque CO 81630", R.drawable.kush_gardens));
        location.add(new GuideWord(
            "https://coloweedery.com",
            "Colorado Weedery \nMon-Sun 9a-8p" +
                    "\n125 Peach Street Unit C, Palisade CO 81526", R.drawable.colorado_weedery));
        location.add(new GuideWord(
            "https://thegreenjoint.com/locations/parachute",
            "The Green Joint \nMon-Sun 9a-9p" +
                    "\n315 E 1st Street, Parachute CO 81635", R.drawable.the_green_joint));
        location.add(new GuideWord(
            "https://www.elkmountaintradingpost.co/",
            "Elk Mountain Trading Post \nMon-Sun 9a-10p" +
                    "\n170 E 3rd Street, De Beque CO 81630", R.drawable.elk_mountain_trading_post));
        location.add(new GuideWord(
            "https://budsltd.com",
            "Buds Premium Cannabis -De Beque \nMon-Sun 9a-10p" +
                    "\n2034 I-70 Frontage Road, De Beque CO 81630", R.drawable.buds_ltd));
        location.add(new GuideWord(
            "https://budsltd.com",
            "Buds Ltd Premium Cannabis -Parachute \nMon-Wed 9a-10p Thu-Sun 9a-11p" +
                    "\n104 Cardinal Way, Parachute CO 81635", R.drawable.buds_ltd));
        location.add(new GuideWord(
            "https://www.facebook.com/Tokin-Tipi-177160262842490/",
            "The Tokin Tipi \nMon-Sun 9a-8p" +
                    "\n393 E 2nd Street, Parachute CO 81635", R.drawable.tokin_tipi));

        // Creates an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will
        // set to display a single word.
        GuideWordAdapter adapter = new GuideWordAdapter(getActivity(), location, R.color.category_dispensaries);

        // Finds the {@link ListView} object in the view heirarchy of the {@link Activity}.
        // There is be a  {@link ListView} with the view id named list which is declared in
        // the word_list.xml file
        ListView listView = rootView.findViewById(R.id.list_view);

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
