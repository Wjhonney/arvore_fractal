/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import javax.swing.JFrame;

/**
 *
 * @author jhonn
 */
public class arvore extends JFrame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        arvore Sp = new arvore();

    }

    public arvore() {
        initGui();
    }

    private void initGui() {
        // titulo
        this.setTitle("Sierpinski");
        // tamanho em pixels altura e largura
        setSize(750, 750);

        // janela aparecer no meio
        setLocationRelativeTo(null);

        // terminar a aplicacao ao fechar a janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Desenho desenho = new Desenho();

        this.add(desenho);
        // tornar a janela visivel
        setVisible(true);
    }

}
