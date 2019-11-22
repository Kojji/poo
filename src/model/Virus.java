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
public class Virus {

    private ArrayList<SpecialItems> virusList;
    
    public Virus() {
        this.virusList = new ArrayList<>();
    }
    
    public ArrayList<SpecialItems> getVirusList() {
        return this.virusList;
    }
    public void virusListPrint() {
        for(int i = 0; i < this.getVirusList().size(); i++) {
            System.out.println(this.virusList.get(i).getItem());
        }
    }

    public void setItemvirusList(SpecialItems item) {
        this.virusList.add(item);
    }

    public boolean readFile() {
        try {
            int lineNum = 1;
            String name = "";
            int dmgCoef = 0;
            int range = 0;
            int duration;
            // Le o arquivo
            FileReader read = new FileReader("src/file/Virus.txt");
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
                            lineNum++;
                            break;
                        case 4:
                            duration = Integer.parseInt(lineRead);
                            lineNum = 1;
                            this.setItemvirusList(new SpecialItems(name, dmgCoef, range, duration));
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
