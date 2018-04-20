package com.breo.breo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.breo.breo.objects.AudioCategory;
import com.breo.breo.service.AudioLibraryService;

@RestController
@EnableAutoConfiguration
public class AudioLibraryController {
  
  @Autowired
  private AudioLibraryService audioLibraryService; 
  
  @RequestMapping(value = "/v1/audios", method = RequestMethod.GET)
  public List<AudioCategory> getAudioLibrary(){
    return audioLibraryService.getAudioLibrary();
  }
  
}
