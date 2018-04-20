package com.breo.breo.objects;

import org.hibernate.validator.constraints.Range;

public class Image {

  private String backgroundImageUrl;
  
 @Range(min=-100, max=100)
  private Integer brightness;

  public String getBackgroundImageUrl() {
    return backgroundImageUrl;
  }

  public void setBackgroundImageUrl(String url) {
    this.backgroundImageUrl = url;
  }

  public Integer getBrightness() {
    return brightness;
  }

  public void setBrightness(Integer brightness) {
    this.brightness = brightness;
  }
}