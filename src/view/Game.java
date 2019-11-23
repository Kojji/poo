/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.*;
import java.util.Arrays;

/**
 *
 * @author fernando
 */
public class Game {

    /**
     * @param args the command line arguments
     */

    
    public static void main(String[] args) {
        Weapon arma = new Weapon();
        arma.readFile();
        Bomb bomba = new Bomb();
        bomba.readFile();
        Virus virus = new Virus();
        virus.readFile();
        RobotTypes robotList = new RobotTypes();
        robotList.readFile();
        
        System.out.println("\nArmas\n====================");
        arma.weaponListPrint();
        System.out.println("\nBombas\n====================");
        bomba.bombListPrint();
        System.out.println("\nVirus\n====================");
        virus.virusListPrint();
        System.out.println("\nRobots\n====================");
        robotList.RobotListPrint();
        
        Arena tabuleiro = new Arena(2,10,10);
        tabuleiro.initialize();
        Robot R1 = robotList.findRobot(2);
        System.out.println(R1.getName() + " - criado");
        Robot R2 = robotList.findRobot(0);
        System.out.println(R2.getName() + " - criado");
        Robot [] players = {R1,R2};
        tabuleiro.initializeComponentsArena(players, arma, bomba, virus);
        // criar uma função para gerar coordenada inicial randomica
  
        
        
        for (int x = 0; x < tabuleiro.getLength(); x++) {
            System.out.printf("|");
            for (int y = 0; y < tabuleiro.getWidth(); y++) {
                System.out.printf(" %2d",tabuleiro.getArenaIndex(x, y));
            } 
            System.out.println(" |");
        }
        
        /* java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Board board = new Board();
                board.setVisible(true);
            }
        }); */
    }
    
}
