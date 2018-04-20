package com.breo.breo.objects;

import java.util.ArrayList;

public class AudioLibrary {
  
  private ArrayList<AudioCategory> audioCategoryList;

  public ArrayList<AudioCategory> getAudioCategoryList() {
    return audioCategoryList;
  }

  public void setAudioCategoryList(ArrayList<AudioCategory> audioCategoryList) {
    this.audioCategoryList = audioCategoryList;
  }
}
