/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Fernando Koji
 */
public class Arma {
    private ArrayList<SpecialItems> listaArmas;
    
    public Arma() {
        this.listaArmas = new ArrayList<>();
    }
    
    public ArrayList<SpecialItems> getListaArmas() {
        return this.listaArmas;
    }
    public void imprimeListaArmas() {
        for(int i = 0; i < this.getListaArmas().size(); i++) {
            System.out.println(this.listaArmas.get(i).getItem());
        }
    }

    public void setItemlistaArmas(SpecialItems item) {
        this.listaArmas.add(item);
    }

    public boolean leArquivo() {
        try {
            int numLinha = 1;
            String nome = "";
            int coefDano = 0;
            int range = 0;
            int duration = -1;
            // Le o arquivo
            FileReader ler = new FileReader("src/File/Armas.txt");
            try (BufferedReader reader = new BufferedReader(ler)) {
                String linha;
                while( (linha = reader.readLine()) != null ){
                    switch(numLinha) {
                        case 1:
                            nome = linha;
                            numLinha++;
                            break;
                        case 2:
                            coefDano = Integer.parseInt(linha);
                            numLinha++;
                            break;
                        case 3:
                            range = Integer.parseInt(linha);
                            numLinha = 1;
                            this.setItemlistaArmas(new SpecialItems(nome, coefDano, range, duration));
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
