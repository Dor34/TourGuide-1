package com.example.android.tourguide;

public class GuideWord {
    //Feature Details to display to list segment
    private String mFeatureData;

    //Location Details to display to list segment
    private String mLocationData;


    //Image Resource ID in case no Image
    private int mImageResourceId=NO_IMAGE_PROVIDED;

    //Constant value that represents no image provided for location
    private static final int NO_IMAGE_PROVIDED=-1;

    /**Create new GuideWord object for list without img
     * @param locationData is the location information for this list segment
     *
     * @param featureData is the feature information for this list segment
     */
    public GuideWord(String featureData, String locationData)
    {mLocationData=locationData;
    mFeatureData=featureData;}

     /**Create new GuideWord object for list if image provided
     * @param locationData is the location information for this list segment
     *
     * @param featureData is the feature information for this list segment
      *
      * @param imageResourceId is the resource ID for construct image
      */
     public GuideWord(String locationData, String featureData, int imageResourceId)
     {mLocationData=locationData;
     mFeatureData=featureData;
     mImageResourceId=imageResourceId;}

     /** Get and Return Location data from GuideWord*/
     public String getLocationData() {return mLocationData;}

     /**Get and Return Feature Data from GuideWord*/
     public String getFeatureData() {return mFeatureData;}

     /**Get and Return Image for GuideWord Image*/
     public int getImageResourceId() {return mImageResourceId;}

     @Override
     public String toString() {
         return "GuideWord{" +
                 ", mLocationData='" + mLocationData + '\'' +
                 ", mFeatureData='" + mFeatureData + '\'' +
                 ", mImageResourceId=" + mImageResourceId +
                 '}';
     }

     /**Returns whether img is avail or not for this GuideWord*/
     public boolean hasImage()
     {return mImageResourceId!=NO_IMAGE_PROVIDED;}



}
