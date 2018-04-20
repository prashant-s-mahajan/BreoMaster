package com.breo.breo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.breo.breo.objects.VideoInput;
import com.breo.breo.service.VideoService;

@RestController
@EnableAutoConfiguration
public class VideoServiceController {

  @Autowired
  private VideoService videoService;

  @RequestMapping(value = "/v1/video/create", method = RequestMethod.POST)
  public VideoInput createVideo(@RequestParam("requestId") String requestId,
      @RequestBody @Valid VideoInput videoInput) {
    videoService.createVideo(requestId, videoInput.getFrameList(), videoInput.getBackgroundTrack());
    System.out.println(videoInput.getFrameList().size());
    return videoInput;
  }
}
