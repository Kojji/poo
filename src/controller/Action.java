/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.security.KeyException;
import java.util.Arrays;
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
      playersRobotIndex[i] = (userInputs.nextInt()-1); // exception por teclar não int
    }
    System.out.println(Arrays.toString(playersRobotIndex));
    createRobots(playersRobotIndex);
    
    this.sessionArena = new Arena(2,10,10);
    this.sessionArena.initialize();
    this.sessionArena.initializeComponentsArena(players, this.weaponList, this.bombList, this.virusList);
    
    int turno = 1;
    boolean stopCondition = false;
    while(true) { // execução do jogo

      System.out.println("\nTurno Jogador " + turno);
      printSessionArena();
      if(players[turno - 1].getVirusDuration() > 0) {
        players[turno - 1].virusDmgApply();
        if(players[turno - 1].getLife() <= 0) {
          // jogador morreu
        }
      }

      int maxMov = players[turno-1].movementCalc(sessionArena.getWidth(), sessionArena.getLength());
      int userMov = 0;
      int counterExceedMovs = 0;
      try {
        while(true) { 
          System.out.printf("\nJogador %d - indique quantas casas deseja andar (até %d): ", turno, maxMov);
          userMov = userInputs.nextInt(); //InputMismatchException
          if(userMov > maxMov) { 
            if(counterExceedMovs >= 3) {
              throw new KeyException("3 tentativas");
              //throw excession, da dano ao jogador e encerra sua vez
            }
            System.out.printf("\nO valor precisa ser menor ou igual a %d", maxMov);
            System.out.printf("\nSe um valor válido não for inserido em %d tentativas, dano será aplicado a seu robô!", 3 - counterExceedMovs);
            counterExceedMovs++;
          }
          else { break; }
        }
      } catch(KeyException e) {
        //implica dano e encerra turno
        e.printStackTrace();
      }


      counterExceedMovs = 0;
      int directionInInt = 0;
      userInputs.nextLine(); // consome \n do nextInt() utilizado anteriormente
      try{
        while(true) {
          System.out.printf("\nJogador %d - Direção do movimento de %d casas(C - cima, B - baixo, E - esquerda, D - Direita): ", turno, maxMov);
          String direction = userInputs.nextLine();
          if(direction.equals("C") || direction.equals("B") || direction.equals("E") || direction.equals("D")) {
            if(direction.equals("C")) {
              directionInInt = 0;
            } else if(direction.equals("B")) {
              directionInInt = 1;
            } else if(direction.equals("E")) {
              directionInInt = 2;
            } else if(direction.equals("D")){
              directionInInt = 3;
            }
            break;
          } else {
            if(counterExceedMovs >= 3) {
              throw new KeyException("3 tentativas");
              //throw excession, da dano ao jogador e encerra sua vez
            }
            System.out.printf("\nDireção informada não é valida");
            System.out.printf("\nSe um valor válido não for inserido em %d tentativas, dano será aplicado a seu robô!", 3 - counterExceedMovs);
            counterExceedMovs++;
          }
        }
      } catch(KeyException e) {
        //implica dano e encerra turno
        e.printStackTrace();
      }
      
      for(int steps = 0; steps < userMov; steps++) {
        int movementX = 0;
        int movementY = 0;
        int beforeX = players[turno-1].getPosition().getWidth();
        int beforeY = players[turno-1].getPosition().getLength();

        switch(directionInInt) {
          case 0:
            movementY = players[turno-1].getPosition().getLength();
            movementX = players[turno-1].getPosition().getWidth() - 1;
            break;
          case 1:
            movementY = players[turno-1].getPosition().getLength();
            movementX = players[turno-1].getPosition().getWidth() + 1;
            break;
          case 2:
            movementY = players[turno-1].getPosition().getLength() - 1;
            movementX = players[turno-1].getPosition().getWidth();
            break;
          case 3:
            movementY = players[turno-1].getPosition().getLength() + 1;
            movementX = players[turno-1].getPosition().getWidth();
            break;
        }

        // fazer a verificação se jogador vai pra fora da area
        
        if(sessionArena.getArenaIndex(movementX, movementY) != 0) {
          if(sessionArena.getArenaIndex(movementX, movementY)/10 == 0) {
            int oponent = sessionArena.getArenaIndex(movementX, movementY);
            int [] newPositionOpenent = players[oponent - 1].moveOnEncounter(sessionArena);
            players[oponent - 1].setPosition(new Arena(0, newPositionOpenent[0], newPositionOpenent[1]));
            sessionArena.setArenaIndex(newPositionOpenent[0], newPositionOpenent[1], oponent);
            System.out.println("Jogador "+ turno + " passou por cima do jogador " + oponent + ".");
            System.out.println("Jogador " + oponent + "foi movido para outras coordenadas.");
            
          } else if(sessionArena.getArenaIndex(movementX, movementY)/10 == 1) {
            SpecialItems weapon = getWeaponList().getWeaponList().get(sessionArena.getArenaIndex(movementX, movementY)%10);
            System.out.println("Jogador " + turno + " encontrou a arma: " + weapon.getname() + " com dano - " + weapon.getdmgCoef() + " e alcance - " + weapon.getRange());
            
            boolean stopInputCond = true;
            while(stopInputCond) {
              System.out.println("deseja trocar pela arma atual? (" + players[turno - 1].getWeapon().getname() + ")? (S/N)");
              String gunSwap = userInputs.nextLine();
              if(gunSwap.equals("S")) {
                players[turno - 1].setWpOnHold(getWeaponList().findWeaponIndex(players[turno - 1].getWeapon().getname()));
                players[turno - 1].setWeapon(weapon);
                stopInputCond = false;
              } else if(gunSwap.equals("N")) {
                players[turno - 1].setWpOnHold(sessionArena.getArenaIndex(movementX, movementY)%10);
                stopInputCond = false;
              }
            }
          } else if(sessionArena.getArenaIndex(movementX, movementY)/10 == 2) {
            SpecialItems bomb = getBombList().getBombList().get(sessionArena.getArenaIndex(movementX, movementY)%10);
            System.out.println("Bomba Estourada!! " + bomb.getdmgCoef() + " de dano ao Jogador " + turno);
            int result = players[turno-1].decreaseLife(bomb.getdmgCoef());
            //if vida <= 0 stop condition = true e continue numPlayer -1 se = 1 jogador restante ganhou
            System.out.println("Vida Restante: " + result);
          } else {
            SpecialItems virus = getVirusList().getVirusList().get(sessionArena.getArenaIndex(movementX, movementY)%10);
            players[turno - 1].setVirusDmg(virus.getdmgCoef());
            players[turno - 1].setVirusDuration(virus.getDuration());
            System.out.println("Virus Contraido!! Por " + virus.getDuration() + " turnos, " + virus.getdmgCoef() + " de dano será aplicado!");
          }
        }

        players[turno-1].setPosition(new Arena(0,movementX,movementY));
        sessionArena.setArenaIndex(movementX, movementY, turno);
        if(players[turno - 1].getWpOnHold() != -1 && players[turno - 1].getDropWp()) {
          sessionArena.setArenaIndex(beforeX, beforeY, 10 + players[turno - 1].getWpOnHold());
          players[turno - 1].setDropWp(false);
          players[turno - 1].setWpOnHold(-1);

        } else if(players[turno - 1].getWpOnHold() != -1 && !players[turno - 1].getDropWp()){
          sessionArena.setArenaIndex(beforeX, beforeY, 0);
          players[turno - 1].setDropWp(true);
        } else {
          sessionArena.setArenaIndex(beforeX, beforeY, 0);
        }
        //printSessionArena();
        //compara posição em que vai mover de 1 a 1
        // se achar algo onde ira mover
          //aplica dano se houver
          //pergunta para trocar arma se quiser
          //mover outro robo que esteja na posição
      }
        


      //ação atacar
      //print catalogo de objetos na arena
      //print arena
      
      //troca turno
      if(players[turno - 1].getLife() <= 0) {
        stopCondition = true; // retirar esta stopCOndition posteriormente
      }
      if(turno == numPlayers) {
        turno = 1;
      } else {
        turno++;
      }
      
      if(stopCondition) { break; }
    }
    userInputs.close();
    
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
  }

  public void createRobots(int [] arrayTypes) {
    Robot [] arrayPlayers = new Robot[arrayTypes.length];
    for( int element = 0; element < arrayTypes.length; element++) {
      Robot found = getRobotList().findRobot(arrayTypes[element]);
      arrayPlayers[element] = new Robot(found.getName(), found.getWeapon(), found.getLife(), found.getArmor(), found.getSpeed());
      System.out.printf(arrayPlayers[element].getName() + " - criado\n");
    }
    setPlayers(arrayPlayers);
  }

  public void printSessionArena() {
    for (int x = 0; x < getSessionArena().getLength(); x++) {
      System.out.printf("|");
      for (int y = 0; y < getSessionArena().getWidth(); y++) {
          System.out.printf(" %2d",getSessionArena().getArenaIndex(x, y));
      } 
      System.out.println(" |");
    }
  }
}