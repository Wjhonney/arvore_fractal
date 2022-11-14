/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author jhonn
 */
public class Ramo {
    
    private int[] pontoInicial = new int[2];
    private int[] pontoFinal = new int[2];
    private int nivel;

    public Ramo(int x1, int y1, int x2 , int y2, int nivel) {
        this.pontoInicial[0] = x1;
        this.pontoInicial[1] = y1;
        this.pontoFinal[0] = x2;
        this.pontoFinal[1] = y2;
        this.nivel = nivel;
    }

    public int[] getPontoInicial() {
        return pontoInicial;
    }

    public int[] getPontoFinal() {
        return pontoFinal;
    }

    public int getNivel() {
        return nivel;
    }
    
}
