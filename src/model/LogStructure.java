/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class LogStructure {
  private int player;
  private int[] positionInitial = new int[2];
  private int[] positionFinal = new int[2];
  private int dmgReceived;
  private int atackTartget;
  private int atackDmg;
  
  public LogStructure(int player, int[] positionInitial, int[] positionFinal, int dmgReceived, int atackTartget, int atackDmg) {
    this.player = player;
    this.positionInitial = positionInitial;
    this.positionFinal = positionFinal;
    this.dmgReceived = dmgReceived;
    this.atackTartget = atackTartget;
    this.atackDmg = atackDmg;
  }

  public int getPlayer() { return this.player; }
  public int[] getPositionInitial() { return this.positionInitial; }
  public int[] getPositionFinal() { return this.positionFinal; }
  public int getdmgReceived() { return this.dmgReceived; }
  public int getAtackTartget() { return this.atackTartget; }
  public int getAtackDmg() { return this.atackDmg; }
  
  public void printLine() {
    System.out.println("Jogador: " + getPlayer() + " - Posição inicial: (" + getPositionInitial()[0] + "," + getPositionInitial()[1] + ") - Posição final: (" + getPositionFinal()[0] + ","
                       + getPositionFinal()[1] +") - Dano Recebido: " + getdmgReceived() + " - Alvo do ataque: " + getAtackTartget() + " - Dano do Ataque: " + getAtackDmg());
  }
}