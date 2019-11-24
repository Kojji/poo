/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.*;

/**
 *
 * @author Fernando Koji
 */
public class Action {

  private Weapon weaponList = new Weapon();
  private Bomb bombList = new Bomb();
  private Virus virusList = new Virus();
  private RobotTypes robotList = new RobotTypes();
  private Arena sessionArena;

  public Action() {

  }


  public void runGame() {
    this.weaponList.readFile();
    this.bombList.readFile();
    this.virusList.readFile();
    
    this.robotList.readFile();
    
    System.out.println("\nArmas\n====================");
    this.weaponList.weaponListPrint();
    System.out.println("\nBombas\n====================");
    this.bombList.bombListPrint();
    System.out.println("\nVirus\n====================");
    this.virusList.virusListPrint();
    System.out.println("\nRobots\n====================");
    this.robotList.RobotListPrint();
    
    this.sessionArena = new Arena(2,10,10);
    this.sessionArena.initialize();
    Robot R1 = this.robotList.findRobot(2);
    System.out.println(R1.getName() + " - criado");
    Robot R2 = this.robotList.findRobot(0);
    System.out.println(R2.getName() + " - criado");
    Robot [] players = {R1,R2};
    this.sessionArena.initializeComponentsArena(players, this.weaponList, this.bombList, this.virusList);
    // criar uma função para gerar coordenada inicial randomica
    
    
    for (int x = 0; x < this.sessionArena.getLength(); x++) {
        System.out.printf("|");
        for (int y = 0; y < this.sessionArena.getWidth(); y++) {
            System.out.printf(" %2d",this.sessionArena.getArenaIndex(x, y));
        } 
        System.out.println(" |");
    }
    //while para controlar o jogo
    
    /* java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            Board board = new Board();
            board.setVisible(true);
        }
    }); */
  }

  public void fileReading() {

  }
}