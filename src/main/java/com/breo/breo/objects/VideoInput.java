package com.breo.breo.objects;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

// class added to wrap the Frame list. It will be used to apply the @Valid annotation 
// which only works on the Java Bean and not on the pure list.
// https://stackoverflow.com/questions/17207766/spring-mvc-valid-on-list-of-beans-in-rest-service
public class VideoInput {

  @Valid
  private List<Frame> frameList;
  
  @NotNull
  private String backgroundTrack;

  public List<Frame> getFrameList() {
    return frameList;
  }

  public void setFrameList(List<Frame> frameList) {
    this.frameList = frameList;
  }

  public String getBackgroundTrack() {
    return backgroundTrack;
  }

  public void setBackgroundTrack(String backgroundTrack) {
    this.backgroundTrack = backgroundTrack;
  }
}
