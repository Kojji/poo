/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

public class Logging {
  private ArrayList<LogStructure> logs;

  public Logging() {
    this.logs = new ArrayList<LogStructure>();
  }

  public void addLine(LogStructure line) {
    logs.add(line);
  }

  public void printLog() {
    for(int i = 0; i < logs.size(); i ++) {
      logs.get(i).printLine();
    }
  }
}