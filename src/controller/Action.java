/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Scanner;

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
  private Robot [] players;

  public Action() {

  }

  public Weapon getWeaponList() { return this.weaponList; }
  public Bomb getBombList() { return this.bombList; }
  public Virus getVirusList() { return this.virusList; }
  public RobotTypes getRobotList() { return this.robotList; }
  public Arena getSessionArena() { return this.sessionArena; }
  public Robot [] getPlayers() { return this.players; }
  public void setPlayers(Robot [] players) { this.players = players; }
  
  public void runGame() {
    fileReading();
    Scanner userInputs = new Scanner(System.in);
    System.out.printf("\nIndique a quantidade de jogadores para a partida: ");
    int numPlayers = userInputs.nextInt();
    int [] playersRobotIndex = new int [numPlayers];
    getRobotList().RobotListPrint();
    for(int i = 0; i < numPlayers; i++) {
      System.out.printf("\nEntre com o indice do robo para o jogador " + (i+1) + ": ");
      playersRobotIndex[i] = (userInputs.nextInt()-1);
    }
    userInputs.close();
    
    createRobots(playersRobotIndex);
    
    this.sessionArena = new Arena(2,10,10);
    this.sessionArena.initialize();
    this.sessionArena.initializeComponentsArena(players, this.weaponList, this.bombList, this.virusList);
    
    // turnos(numPlayers)
    printSessionArena();
    //while para controlar o jogo
      
      //ação mover
        //mover de 1 em 1 até objetivo
      //ação atacar
      //print arena
      //troca turno
    
    /* java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            Board board = new Board();
            board.setVisible(true);
        }
    }); */
  }

  public void fileReading() {
    if(!getWeaponList().readFile()) { System.out.println("arquivo Armas.txt não foi lido corretamente"); }
    if(!getBombList().readFile()) { System.out.println("arquivo Bomba.txt não foi lido corretamente"); }
    if(!getVirusList().readFile()) { System.out.println("arquivo Virus.txt não foi lido corretamente"); }
    if(!getRobotList().readFile()) { System.out.println("arquivo Robots.txt não foi lido corretamente"); }
    /* 
    System.out.println("\nArmas\n====================");
    this.weaponList.weaponListPrint();
    System.out.println("\nBombas\n====================");
    this.bombList.bombListPrint();
    System.out.println("\nVirus\n====================");
    this.virusList.virusListPrint();
    System.out.println("\nRobots\n====================");
    this.robotList.RobotListPrint(); */
  }

  public void createRobots(int [] arrayTypes) {
    Robot [] arrayPlayers = new Robot[arrayTypes.length];
    for( int element = 0; element < arrayTypes.length; element++) {
      arrayPlayers[element] = getRobotList().findRobot(arrayTypes[element]);
      System.out.printf(arrayPlayers[element].getName() + " - criado\n");
    }
    setPlayers(arrayPlayers);
  }

  public void printSessionArena() {
    for (int x = 0; x < this.getSessionArena().getLength(); x++) {
      System.out.printf("|");
      for (int y = 0; y < this.getSessionArena().getWidth(); y++) {
          System.out.printf(" %2d",this.getSessionArena().getArenaIndex(x, y));
      } 
      System.out.println(" |");
    }
  }
}