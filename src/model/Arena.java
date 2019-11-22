/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
    
    public boolean initialize() {
        this.arena = new int[this.getWidth()][this.getLength()];
        for(int i = 0; i < this.getWidth(); i++) {
            for(int j = 0; j < this.getLength(); j++) {
                this.setArenaIndex(i, j, 1);
            }
        }
        return true;
    }

    public void setArenaIndex(int width, int length, int value) {
        this.arena[width][length] = value;
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
}
