package com.breo.breo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.breo.breo.config.AppConfiguration;
import com.breo.breo.objects.Frame;
import com.breo.breo.objects.Image;
import com.breo.breo.objects.Text;
import com.breo.breo.objects.VideoProperties;
import com.breo.breo.utility.ShellWrapper;

@Service
public class VideoService {

  @Autowired
  private AppConfiguration appConfig;

  public void createVideo(String requestId, List<Frame> frameList, String backgroundTrack) {
    // We are using steam of indices as we need to pass the index to createFrame() function.
    // Index is not available if you use normal foreach loop
    IntStream.range(0, frameList.size()).forEach(
        index -> {
          System.out.println("Index : " + index);
          Frame frame = frameList.get(index);
          Image image = frame.getImage();
          Text text = frame.getText();
          this.createFrame(requestId, text.getText(), frame.getImage().getBackgroundImageUrl(),
              index + 1, image.getBrightness(), text.getBackgroundColor(), text.getFontColor(),
              text.getWidth(), text.getHeight(), text.getPosition());
        });

    this.stichImagesIntoVideo(requestId, backgroundTrack);

  }
  
  public void createVideo(String requestId, List<Frame> frameList, String backgroundTrack, VideoProperties videoProperties) {
	    // We are using steam of indices as we need to pass the index to createFrame() function.
	    // Index is not available if you use normal foreach loop
	    IntStream.range(0, frameList.size()).forEach(
	        index -> {
	          System.out.println("Index : " + index);
	          Frame frame = frameList.get(index);
	          Image image = frame.getImage();
	          Text text = frame.getText();
	          this.createFrame(requestId, text.getText(), frame.getImage().getBackgroundImageUrl(),
	              index + 1, image.getBrightness(), text.getBackgroundColor(), text.getFontColor(),
	              text.getWidth(), text.getHeight(), text.getPosition(), videoProperties.getWidth(), videoProperties.getHeight());
	        });

	    this.stichImagesIntoVideo(requestId, backgroundTrack);

	  }

  private void createFrame(String requestId, String text, String backgroundImageUrl,
      Integer frameId, Integer brightness, String backgroundColor, String fontColor, Integer width,
      Integer height, String position) {
    List<String> command = new ArrayList<String>();
    command.add(appConfig.getFrameScript());
    command.add(requestId);
    command.add(text);
    command.add(backgroundImageUrl);
    command.add(frameId.toString());
    command.add(brightness.toString());
    command.add(backgroundColor);
    command.add(fontColor);
    command.add(width.toString());
    command.add(height.toString());
    command.add(position);
    String result = ShellWrapper.executeCommand(command);
    System.out.println(result);
  }
  
  private void createFrame(String requestId, String text, String backgroundImageUrl,
	      Integer frameId, Integer brightness, String backgroundColor, String fontColor, Integer width,
	      Integer height, String position, int videoWidth, int videoHeight) {
	    List<String> command = new ArrayList<String>();
	    command.add(appConfig.getFrameScript());
	    command.add(requestId);
	    command.add(text);
	    command.add(backgroundImageUrl);
	    command.add(frameId.toString());
	    command.add(brightness.toString());
	    command.add(backgroundColor);
	    command.add(fontColor);
	    command.add(width.toString());
	    command.add(height.toString());
	    command.add(position);
	    command.add(Integer.toString(videoWidth));
	    command.add(Integer.toString(videoHeight));
	    String result = ShellWrapper.executeCommand(command);
	    System.out.println(result);
	  }

  private void stichImagesIntoVideo(String requestId, String backgroundTrack) {
    List<String> command = new ArrayList<String>();
    command.add(appConfig.getMasterVideoScript());
    command.add(requestId);
    command.add(appConfig.getAudioStorage() + backgroundTrack);
    String result = ShellWrapper.executeCommand(command);
    System.out.println(result);
  }
}
