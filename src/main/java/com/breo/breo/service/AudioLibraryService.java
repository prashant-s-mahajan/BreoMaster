package com.breo.breo.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.breo.breo.config.AppConfiguration;
import com.breo.breo.objects.AudioCategory;

@Service
public class AudioLibraryService {

  @Autowired
  private AppConfiguration appConfig;

  public List<AudioCategory> getAudioLibrary() {

    List<AudioCategory> audioCategories = new ArrayList<AudioCategory>();

    List<String> audioCategoriesNameList = getAudioCategories();
    audioCategoriesNameList.stream().forEach(
        category -> {
          AudioCategory audioCategory = new AudioCategory();
          audioCategory.setCategory(category);
          List<String> tracks;
          try {
            tracks =
                Files.walk(Paths.get(appConfig.getAudioStorage() + category))
                    .filter(Files::isRegularFile).map(Path::getFileName).map(Path::toString)
                    .collect(Collectors.toList());
            audioCategory.setTracks(tracks);
            audioCategories.add(audioCategory);
          } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return;
          }
        });
    return audioCategories;
  }

  private List<String> getAudioCategories() {
    try {
      List<String> audioCategories =
          Files.walk(Paths.get(appConfig.getAudioStorage())).filter(Files::isDirectory)
              .map(Path::getFileName).map(Path::toString).collect(Collectors.toList());
      //pathList.stream().forEach(System.out::println);
      return audioCategories;
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      return null;
    }
  }

}
