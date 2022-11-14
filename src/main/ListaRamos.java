/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author jhonn
 */
public class ListaRamos {
    
    private Ramo[] itens;
    
    public ListaRamos(){
        itens = new Ramo[20];
    }
    
    public boolean addRamo(int pontoInicialX, int pontoInicialY , int pontoFinalX, int pontoFinalY, int nivel){
        Ramo aux = new Ramo(pontoInicialX, pontoInicialY, pontoFinalX, pontoFinalY, nivel);
        
        // adiciona sempre no final
        for (int i = 0; i < itens.length; i++) {
            if (itens[i] == null) {
                itens[i] = aux;
                return true;
            }
        }
        
        Ramo novoVetor[] = new Ramo[itens.length + 20];
        
        for (int i = 0; i < itens.length; i++) {
            novoVetor[i] = itens[i];
        }
        
        itens = novoVetor;
        
        for (int i = 0; i < itens.length; i++) {
            if (itens[i] == null) {
                itens[i] = aux;
                return true;
            }
        }
        
        return false;
    }
    
    public int size() {
        return itens.length;
    }
    
    public Ramo[] getItens() {
        return itens;
    }
    
}
