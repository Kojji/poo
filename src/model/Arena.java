/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Random;

/**
 *
 * @author Fernando Koji
 */
public class Arena {
    private int height;
    private int width;
    private int length;

    private int[][] arena;

    public Arena(int height, int width, int length) {
        this.height = height;
        this.width = width;
        this.length = length;
    }
    
    /* 
        1 ~ 9 - jogadores _ se dividir por 10 e resp = 0 indica jogador
        10 ~ 19 - arma _ se dividir por 10 e resp = 1 indica arma
        20 ~ 29 - bomba _ se dividir por 10 e resp = 2 indica bomba
        30 ~ 39 - virus _ se dividir por 10 e resp = 3 indica virus
    */

    public boolean initialize() {
        this.arena = new int[this.getWidth()][this.getLength()];
        /* for(int i = 0; i < this.getWidth(); i++) {
            for(int j = 0; j < this.getLength(); j++) {
                this.setArenaIndex(i, j, 1);
            }
        }*/
        return true;
    }
    
    public void setArenaIndex(int width, int length, int value) {
        this.arena[width][length] = value;
    }

    public int getArenaIndex(int width, int length) {
        return this.arena[width][length];
    }

    public void initializeComponentsArena(Robot [] players, Weapon weaponList, Bomb bombList, Virus virusList) {
        int itemDensity = (this.getWidth() * this.getLength())/8; // multiplicar por this.getHeight() se considerar alturas diversas

        Random randomNum = new Random();

        int i = 0;
        do {
            int width = randomNum.nextInt(this.getWidth());
            int length = randomNum.nextInt(this.getLength());

            if(this.getArenaIndex(width, length) == 0) {
                int value = 0;
                if(i < players.length) { // coloca os robos nas primeiras iterações
                    value = i + 1;
                    players[i].setPosition(new Arena(0, width, length));
                } else {
                    int typeOfItem = randomNum.nextInt(3);
                    switch(typeOfItem) {
                        case 0:
                            value = 10 + randomNum.nextInt(weaponList.getWeaponListSize());
                            // coloca arma
                            break;
                        case 1:
                            value = 20 + randomNum.nextInt(bombList.getBombListSize());
                            // coloca bomba
                            break;
                        case 2:
                            value = 30 + randomNum.nextInt(virusList.getVirusListSize());
                            // coloca virus
                            break;
                    }
                }
                this.setArenaIndex(width, length, value);
                i++;
            }
        }while(i < (itemDensity + players.length));

    }

    public int[][] getArena() {
        return this.arena;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int length) {
        this.length = length;
    }
    
    public int[] getArenaSize() {
        int[] arr = {};
        arr[0] = this.getHeight();
        arr[1] = this.getWidth();
        arr[2] = this.getLength();
        return arr;
    }
}
