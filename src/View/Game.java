/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.*;

/**
 *
 * @author fernando
 */
public class Game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Arma arma = new Arma();
        arma.leArquivo();
        Bomba bomba = new Bomba();
        bomba.leArquivo();
        Virus virus = new Virus();
        virus.leArquivo();
        System.out.println("\nArmas\n====================");
        arma.imprimeListaArmas();
        System.out.println("\nBombas\n====================");
        bomba.imprimeListaBombas();
        System.out.println("\nVirus\n====================");
        virus.imprimeListaVirus();
        
    }
    
}
