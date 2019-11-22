/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.*;

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
        
    }
    
}
