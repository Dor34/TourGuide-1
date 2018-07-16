package com.example.android.tourguide;

import android.support.v4.view.ViewPager;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Set activity content to use activity_main.xml layout file
        setContentView(R.layout.activity_main);

        //Find ViewPager that allows user to swipe between Fragments
        ViewPager viewPager = (ViewPager)findViewById(R.id.viewpager_display);

        //Create an adapter that knows which fragment should be displayed
        FragRokrAdapter adapter = new FragRokrAdapter(this, getSupportFragmentManager());

        //Set (attach) adapter onto the ViewPager
        viewPager.setAdapter(adapter);

        //Find tab layout that shows the tabs
        TabLayout tabLayout = (TabLayout)findViewById(R.id.tab_slider);

        //Connect tab layout to ViewPager. This will:
        // 1. Update the tab layout that shows the tabs
        // 2. Update ViewPager when a tab is selected
        // 3. Set Tab Layout tab names with ViewPager's adapter's titles
        // by calling onPageTitle()
        tabLayout.setupWithViewPager(viewPager);
    }
}

