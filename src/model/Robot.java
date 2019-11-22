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
public class Robot {
    private String name;
    private SpecialItems weapon;
    private Arena position;
    private int life;
    private int armor;

    public Robot(SpecialItems weapon, Arena position, int life, String name, int armor) {
        this.name = name;
        this.weapon = weapon;
        this.position = position;
        this.life = life;
        this.armor = armor;
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


    public int increaseLife(int value) {
        this.setLife(this.getLife()+value);
        return this.getLife();
    }
    public int decreaseLife(int value) {
        this.setLife(this.getLife()-value);
        return this.getLife();
    }
    
    
}