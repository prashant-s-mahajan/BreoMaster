package com.breo.breo.objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Text {
  
  @NotNull
  private String text;
  
  @NotNull
  private String backgroundColor;
  
  @NotNull
  private String fontColor;
  
  @NotNull
  private Integer width;
  
  @NotNull
  private Integer height;
  
  @NotNull
  @Pattern(regexp="^(south|north|center|east|west)$",message="The text position specified is invalid")
  private String position;
  
  public String getText() {
    return text;
  }
  public void setText(String text) {
    this.text = text;
  }
  public String getBackgroundColor() {
    return backgroundColor;
  }
  public void setBackgroundColor(String backgroundColor) {
    this.backgroundColor = backgroundColor;
  }
  public String getFontColor() {
    return fontColor;
  }
  public void setFontColor(String fontColor) {
    this.fontColor = fontColor;
  }
  public Integer getWidth() {
    return width;
  }
  public void setWidth(Integer width) {
    this.width = width;
  }
  public Integer getHeight() {
    return height;
  }
  public void setHeight(Integer height) {
    this.height = height;
  }
  public String getPosition() {
    return position;
  }
  public void setPosition(String position) {
    this.position = position;
  }
}
