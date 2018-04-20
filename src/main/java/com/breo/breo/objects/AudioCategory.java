package com.breo.breo.objects;

import java.util.ArrayList;
import java.util.List;

public class AudioCategory {
  
  private String category;
  private List<String> tracks;
  
  public String getCategory() {
    return category;
  }
  public void setCategory(String category) {
    this.category = category;
  }
  public List<String> getTracks() {
    return tracks;
  }
  public void setTracks(List<String> tracks) {
    this.tracks = tracks;
  } 
}
