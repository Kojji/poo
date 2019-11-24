/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Fernando Koji
 */
public class RobotTypes {
  private ArrayList<Robot> robotList;
    
    public RobotTypes() {
        this.robotList = new ArrayList<>();
    }
    
    public Robot findRobot(int index) {
      return this.robotList.get(index);
    }

    public ArrayList<Robot> getRobotList() {
        return this.robotList;
    }
    public void RobotListPrint() {
        for(int i = 0; i < this.getRobotList().size(); i++) {
            System.out.println("indice: " + (i + 1) + " - " + this.robotList.get(i).getRobot());
        }
    }

    public void setItemRobotList(Robot item) {
        this.robotList.add(item);
    }

    public boolean readFile() {
        try {
            int lineNum = 1;
            String name = "";
            String weapon = "";
            int life = 0;
            int armor = 0;
            int speed;
            // Le o arquivo
            FileReader read = new FileReader("src/file/Robots.txt");
            try (BufferedReader reader = new BufferedReader(read)) {
                String lineRead;
                while( (lineRead = reader.readLine()) != null ){
                    switch(lineNum) {
                        case 1:
                            name = lineRead;
                            lineNum++;
                            break;
                        case 2:
                            weapon = lineRead;
                            lineNum++;
                            break;
                        case 3:
                            life = Integer.parseInt(lineRead);
                            lineNum++;
                            break;
                        case 4:
                            armor = Integer.parseInt(lineRead);
                            lineNum++;
                            break;
                        case 5:
                            speed = Integer.parseInt(lineRead);
                            lineNum = 1;

                            Weapon arma = new Weapon();
                            arma.readFile();
                            this.setItemRobotList(new Robot(name, arma.findWeapon(weapon), life, armor, speed));
                            break;
                    }
                }
            }
            // Imprime confirmacao
            return true;
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}