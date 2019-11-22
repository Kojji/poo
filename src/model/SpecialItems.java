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
public class SpecialItems {

    private String name;
    private int dmgCoef;
    private int range;
    private int duration;

    public SpecialItems(String name, int dmgCoef, int range, int duration) {
        this.name = name;
        this.dmgCoef = dmgCoef;
        this.range = range;
        this.duration = duration;
    }
    public String getname() {
        return this.name;
    }
    public boolean setDuration() {
        this.duration = this.duration--;
        if(this.duration > 0) {
            return true;
        }
        return false;
    }
    public int getDuration() {
        return this.duration;
    }
    public int getdmgCoef() {
        return this.dmgCoef;
    }
    public int getRange() {
        return this.range;
    }
    public String getItem() {
        return "nome: " + this.name + " - Dano: " + this.dmgCoef + " - Distancia: " + this.range + " - Duração: " + this.duration;
    }

}
