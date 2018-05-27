package com.breo.breo.objects;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Data;

// class added to wrap the Frame list. It will be used to apply the @Valid annotation 
// which only works on the Java Bean and not on the pure list.
// https://stackoverflow.com/questions/17207766/spring-mvc-valid-on-list-of-beans-in-rest-service
@Data
public class VideoInput {

  @Valid
  private List<Frame> frameList;
  
  @NotNull
  private String backgroundTrack;
  
  private VideoProperties videoProperties;

}
