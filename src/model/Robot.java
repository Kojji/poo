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
public class Robot {
    private String name;
    private SpecialItems weapon;
    private Arena position = new Arena(0,0,0);
    private int life;
    private int armor;
    private int speed;

    public Robot(String name, SpecialItems weapon, int life, int armor, int speed) {
        this.name = name;
        this.weapon = weapon;
        this.life = life;
        this.armor = armor;
        this.speed = speed;
    }

	public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }

    public SpecialItems getWeapon() { return this.weapon; }
    public void setWeapon(SpecialItems weapon) { this.weapon = weapon; }

    public Arena getPosition() { return this.position; }
    public void setPosition(Arena position) { this.position = position; }

    public int getLife() { return this.life; }
    public void setLife(int life) { this.life = life; }

    public int getArmor() { return this.armor; }
    public void setArmor(int armor) { this.armor = armor; }

    public int getSpeed() { return this.speed; }
    public void setSpeed(int speed) { this.speed = speed; }

    public String getRobot() {
        return "nome: " + this.getName() + " - arma: " + this.weapon.getname() + " - vida: " + this.getLife() + " - Armadura: " + this.getArmor() + " - Velocidade: " + this.getSpeed();
    }


    public int increaseLife(int value) {
        this.setLife(this.getLife()+value);
        return this.getLife();
    }
    public int decreaseLife(int value) {
        this.setLife(this.getLife()-value);
        return this.getLife();
    }

    /*
        gera um valor aleatório, como se fosse um dado a partir das dimenções do tabuleiro e da velocidade do robo 
     */
    public int movementCalc(int arenaWidth, int arenaHeight) {
        Random randomNum = new Random();
        int maxMov = getSpeed()*arenaHeight*arenaWidth/1000;
        return 1 + randomNum.nextInt(maxMov);
    }
    
    
}
