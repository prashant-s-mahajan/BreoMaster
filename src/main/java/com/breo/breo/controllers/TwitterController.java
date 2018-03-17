package com.breo.breo.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.breo.breo.utility.ShellCommand;

@RestController
@EnableAutoConfiguration
public class TwitterController {
  
  @Autowired
  private ShellCommand shellCommand;
  
  @RequestMapping("/")
  String home() {
    return "Hello World!";
  }

  @RequestMapping(value = "/getvideo", method = RequestMethod.POST,
      produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
  public FileSystemResource getVideo(@RequestParam("requestId") String requestId,
      @RequestParam("name") String name, @RequestParam("twitter_handle") String twitterHandle,
      @RequestParam("bio") String bio, @RequestParam("location") String location,
      @RequestParam("website") String website, @RequestParam("date_joined") String dateJoined,
      @RequestParam("tweet_count") String tweetCount, @RequestParam("following") String following,
      @RequestParam("followers") String followers, @RequestParam("likes") String likes,
      @RequestParam("profile_picture_url") String profilePictureURL,
      @RequestParam("background_picture_url") String backgroundPictureURL,
      @RequestParam("tweets_content") String tweetsContent,
      @RequestParam("background_track") String backgroundTrack, HttpServletResponse response) {

    shellCommand.createProfile(requestId, profilePictureURL, name, twitterHandle, bio, location,
        website, dateJoined, tweetCount, following, followers, likes, tweetsContent,
        backgroundPictureURL, backgroundTrack);

    shellCommand.createTweetImages(requestId, tweetsContent, backgroundPictureURL);

    shellCommand.createVideo(requestId, backgroundTrack);
    shellCommand.clean(requestId);

    /*
     * return "Hello\n" + requestId + "\n" + name + "\n" + twitterHandle + "\n" + bio + "\n" +
     * location + "\n" + website + "\n" + dateJoined + "\n" + tweetCount + "\n" + following + "\n" +
     * followers + "\n" + likes + "\n" + profilePictureURL + "\n" + backgroundPictureURL + "\n" +
     * tweetsContent;
     */
    response.setHeader("Content-Disposition", "attachment; filename=myfile.mov");
    return new FileSystemResource(requestId + "/final.mov");
  }
}
