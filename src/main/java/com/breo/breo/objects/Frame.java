package com.breo.breo.objects;

import javax.validation.Valid;

public class Frame {

  @Valid
  private Text text;
  
  @Valid
  private Image image;

  public Image getImage() {
    return image;
  }
  
  public void setImage(Image image) {
    this.image = image;
  }
  public Text getText() {
    return text;
  }
  public void setText(Text text) {
    this.text = text;
  }
}
