/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Fernando Koji
 */
public class Weapon {
    private ArrayList<SpecialItems> weaponList;
    
    public Weapon() {
        this.weaponList = new ArrayList<>();
    }
    
    public ArrayList<SpecialItems> getWeaponList() {
        return this.weaponList;
    }

    public int getWeaponListSize() {
        return this.weaponList.size();
    }

    public SpecialItems findWeapon(String name) {
        for(int i = 0; i < this.getWeaponList().size(); i++) {
            if(name.equals(this.weaponList.get(i).getname())) {
                return this.weaponList.get(i);
            }
        }
        return null;
    }

    public int findWeaponIndex(String name) {
        for(int i = 0; i < this.getWeaponList().size(); i++) {
            if(name.equals(this.weaponList.get(i).getname())) {
                return i;
            }
        }
        return -1;
    }

    public void weaponListPrint() {
        for(int i = 0; i < this.getWeaponList().size(); i++) {
            System.out.println((i+10) + " - " + this.weaponList.get(i).getItem());
        }
    }

    public void setItemweaponList(SpecialItems item) {
        this.weaponList.add(item);
    }

    public boolean readFile() {
        try {
            int lineNum = 1;
            String name = "";
            int dmgCoef = 0;
            int range = 0;
            int duration = -1;
            // Le o arquivo
            FileReader read = new FileReader("src/file/Armas.txt");
            try (BufferedReader reader = new BufferedReader(read)) {
                String lineRead;
                while( (lineRead = reader.readLine()) != null ){
                    switch(lineNum) {
                        case 1:
                            name = lineRead;
                            lineNum++;
                            break;
                        case 2:
                            dmgCoef = Integer.parseInt(lineRead);
                            lineNum++;
                            break;
                        case 3:
                            range = Integer.parseInt(lineRead);
                            lineNum = 1;
                            this.setItemweaponList(new SpecialItems(name, dmgCoef, range, duration));
                            break;
                    }
                }
            }
            // Imprime confirmacao
            return true;
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
