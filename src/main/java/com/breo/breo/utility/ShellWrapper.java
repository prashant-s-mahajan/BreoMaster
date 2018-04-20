package com.breo.breo.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class ShellWrapper {
  public static String executeCommand(List<String> command) {
    ProcessBuilder processBuilder = new ProcessBuilder();
    processBuilder.command(command);
    try {
      final Process p = processBuilder.start();
      BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
      return br.lines().collect(Collectors.joining());
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      return null;
    }
  }
}
