package com.example.android.miwok;

/**
 * Created by Hisham on 2/9/2018.
 */

public class Word {

    private int defaultTranslation;
    private int miwokTranslation;
    private int audioResourceId;
    private int imageResourceId=NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;


    public Word(int defaultTranslation, int miwokTranslation, int audioResourceId) {
        this.defaultTranslation=defaultTranslation;
        this.miwokTranslation=miwokTranslation;
        this.audioResourceId = audioResourceId;
    }

    public Word(int defaultTranslation, int miwokTranslation, int imageResourceId,int audioResourceId) {
        this.defaultTranslation=defaultTranslation;
        this.miwokTranslation=miwokTranslation;
        this.imageResourceId = imageResourceId;
        this.audioResourceId = audioResourceId;
    }
    public int getDefaultTranslation() {
        return defaultTranslation;
    }
    public int getMiwokTranslation() {
        return miwokTranslation;
    }
    public int getImageResourceId() {
        return imageResourceId;
    }
    public boolean hasImage() {
        return imageResourceId != NO_IMAGE_PROVIDED;
    }
    public int getAudioResourceID() {
        return audioResourceId;
    }
}
