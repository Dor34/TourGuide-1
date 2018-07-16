package com.example.android.tourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * {@link FragRokrAdapter} is a {@link FragmentPagerAdapter} that can provide the layout for
 * each list item based on a data source which is a list of {@link GuideWord} objects
 */
public class FragRokrAdapter extends FragmentPagerAdapter {
    /** Context of the app */
    private Context mContext;

    /**
     * Create a new {@link FragRokrAdapter} object
     *
     * @param context is the context of the app
     * @param fm is the FragmentManager that will keep each fragment's state in the adapter
     *           across swipes.
     */
    public FragRokrAdapter(Context context, FragmentManager fm){
        super(fm);
        mContext=context;
    }

    /**
     * Return {@link Fragment} that should be displayed for the given page number
     */
    @Override
    public Fragment getItem(int position){
        if (position == 0) {
            return new DiningFragment();
        }else if (position == 1) {
            return new ActivitiesFragment();
        }else if (position == 2) {
            return new DispensariesFragment();
        }else{
            return new InformationFragment();
        }
    }

    //Get total number of pages (fragments)
    @Override
    public int getCount(){
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position==0) {
            return mContext.getString(R.string.category_dining);
        }else if (position==1) {
            return mContext.getString(R.string.category_activities);
        }else if (position==2) {
            return mContext.getString(R.string.category_dispensaries);
        }else {
            return mContext.getString(R.string.category_information);
        }
    }
}
