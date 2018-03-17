package com.breo.breo.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.breo.breo.config.AppConfiguration;

@Component
@ComponentScan("com.breo.breo.config")
public class ShellCommand {

  @Autowired
  AppConfiguration appConfig;

  public void createProfile(String requestId, String profilePictureURL, String name,
      String twitterHandle, String bio, String location, String website, String dateJoined,
      String tweetCount, String following, String followers, String likes, String tweetsContent,
      String backgroundPictureURL, String backgroundTrack) {
    ProcessBuilder processBuilder =
        new ProcessBuilder(appConfig.getProfileScript(), requestId, profilePictureURL, name,
            twitterHandle, bio, location, website, dateJoined, tweetCount, following, followers,
            likes, tweetsContent, backgroundPictureURL, backgroundTrack);
    try {
      final Process p = processBuilder.start();
      BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
      String line;
      while ((line = br.readLine()) != null) {
        System.out.println(line);
      }

    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void createTweetImages(String requestId, String tweetsContent, String backgroundPictureURL) {
    String[] tweets = tweetsContent.split("####");
    Integer count = 0;
    for (String tweet : tweets) {
      count++;
      System.out.println("\nTweet" + tweet);
      ProcessBuilder processBuilder =
          new ProcessBuilder(appConfig.getTweetsScript(), requestId, tweet, backgroundPictureURL,
              count.toString());
      try {
        final Process p = processBuilder.start();
        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while ((line = br.readLine()) != null) {
          System.out.println(line);
        }
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }

  public void createVideo(String requestId, String backgroundTrack) {
    backgroundTrack = appConfig.getAudioStorage() + backgroundTrack;
    ProcessBuilder processBuilder =
        new ProcessBuilder(appConfig.getVideoScript(), requestId, backgroundTrack);
    try {
      final Process p = processBuilder.start();
      BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
      String line;
      while ((line = br.readLine()) != null) {
        System.out.println(line);
      }
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void clean(String requestId) {
    ProcessBuilder processBuilder =
        new ProcessBuilder("target/script-resources/clean_up.sh", requestId);
    try {
      final Process p = processBuilder.start();
      BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
      String line;
      while ((line = br.readLine()) != null) {
        System.out.println(line);
      }
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
