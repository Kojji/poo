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
        System.out.println("\nArmas\n====================");
        arma.weaponListPrint();
        System.out.println("\nBombas\n====================");
        bomba.bombListPrint();
        System.out.println("\nVirus\n====================");
        virus.virusListPrint();
        
        Arena tabuleiro = new Arena(2,10,10);
        Arena initialPosition = tabuleiro; // criar uma função para gerar coordenada inicial randomica
        tabuleiro.initialize();
        Robot R1 = new Robot(arma.getWeaponList().get(0), initialPosition, 300, "Robo Teste 1",300);
        System.out.println(R1.getName() + " - criado");
        Robot R2 = new Robot(arma.getWeaponList().get(0), initialPosition, 300, "Robo Teste 2",300);
        System.out.println(R2.getName() + " - criado");
  
        System.out.println(Arrays.deepToString(tabuleiro.getArena()));
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Board board = new Board();
                board.setVisible(true);
            }
        });
    }
    
}
