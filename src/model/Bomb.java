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
public class Bomb {
    private ArrayList<SpecialItems> bombList;
    
    public Bomb() {
        this.bombList = new ArrayList<>();
    }

    public ArrayList<SpecialItems> getBombList() {
        return this.bombList;
    }
    public int getBombListSize() {
        return this.bombList.size();
    }
    public void bombListPrint() {
        for(int i = 0; i < this.getBombList().size(); i++) {
            System.out.println((i+20) + " - " + this.bombList.get(i).getItem());
        }
    }

    public void setItembombList(SpecialItems item) {
        this.bombList.add(item);
    }

    public boolean readFile() {
        try {
            int lineNum = 1;
            String name = "";
            int damgCoef = 0;
            int range;
            int duration = -1;
            // Le o arquivo
            FileReader read = new FileReader("src/file/Bomba.txt");
            try (BufferedReader reader = new BufferedReader(read)) {
                String lineRead;
                while( (lineRead = reader.readLine()) != null ){
                    switch(lineNum) {
                        case 1:
                            name = lineRead;
                            lineNum++;
                            break;
                        case 2:
                            damgCoef = Integer.parseInt(lineRead);
                            lineNum++;
                            break;
                        case 3:
                            range = Integer.parseInt(lineRead);
                            lineNum = 1;
                            this.setItembombList(new SpecialItems(name, damgCoef, range, duration));
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
