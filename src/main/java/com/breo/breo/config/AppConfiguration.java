package com.breo.breo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
 
@Configuration("config")
@ConfigurationProperties("app") 
public class AppConfiguration {
  
  private String profileScript;
  private String tweetsScript;
  private String videoScript;
  private String audioStorage;
  private String cleanUpScript;
  
  public AppConfiguration(){
    System.out.println("In the App configuration");
  }
  
  public String getProfileScript() {
    return profileScript;
  }

  public void setProfileScript(String profileScript) {
    this.profileScript = profileScript;
  }

  public String getTweetsScript() {
    return tweetsScript;
  }

  public void setTweetsScript(String tweetsScript) {
    this.tweetsScript = tweetsScript;
  }

  public String getVideoScript() {
    return videoScript;
  }

  public void setVideoScript(String videoScript) {
    this.videoScript = videoScript;
  }

  public String getAudioStorage() {
    return audioStorage;
  }

  public void setAudioStorage(String audioStorage) {
    this.audioStorage = audioStorage;
  }

  public String getCleanUpScript() {
    return cleanUpScript;
  }

  public void setCleanUpScript(String cleanUpScript) {
    this.cleanUpScript = cleanUpScript;
  }
}
