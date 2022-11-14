package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Desenho extends Canvas {

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        criaArvore(g);
    }

    private void criaArvore(Graphics g) {
        int abscissa = getWidth() - 5;            // abscissa
        int ordenada = getHeight() - 5;           // ordenada

        int ramo = 100;

        int nivelMaximo = 15;
        // 50 será o tamanho padrao do ramo

        ListaRamos lista = new ListaRamos();

        passoRecusrsivo(g, 0, nivelMaximo, abscissa / 2, ordenada - ramo, Math.PI / 2.8, ramo, Math.PI / 3, false, lista);

        float r = 128;

        float gr = 0;

        Color cor = new Color(128, 0, 0);
        
        float taxaDeDiminuicaoR = 128 / nivelMaximo;

        float taxaDeAumentoG = 250 / nivelMaximo;

        int espera = 0;
        
        for (int j = 0; j <= nivelMaximo; j++) {

            g.setColor(cor);
            
            for (int i = 0; i < lista.size(); i++) {

                if (lista.getItens()[i] != null) {
                    if (lista.getItens()[i].getNivel() == j) {

                        g.drawLine(lista.getItens()[i].getPontoInicial()[0], lista.getItens()[i].getPontoInicial()[1],
                                lista.getItens()[i].getPontoFinal()[0], lista.getItens()[i].getPontoFinal()[1]);

                    }
                }

            }

            
            cor = new Color((int) r, (int) gr, 0);
            
            r -= taxaDeDiminuicaoR;
            
            gr += taxaDeAumentoG;
            
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }

    }

    private void passoRecusrsivo(Graphics g, int nivel, int nivelMax,
            double x1, double y1, double tetha, int ramo, double taxa, boolean esquerda, ListaRamos lista) {

        if (nivel == 0) {
            //g.drawLine((int) x1, (int) (y1 + ramo), (int) x1, (int) y1);
            lista.addRamo((int) x1, (int) (y1 + ramo), (int) x1, (int) y1, nivel);
            passoRecusrsivo(g, nivel + 1, nivelMax, x1, y1, Math.PI / 2 - tetha, ramo, Math.PI / 2 - tetha, false, lista);
        } else if ((nivel == nivelMax)) {

            double x2, y2;

            if (esquerda) {
                x2 = ramo * Math.cos(tetha - 2 * taxa);
                y2 = ramo * Math.sin(tetha - 2 * taxa);

                // g.drawLine(x1, y1, x1 - x2, y1 - y2)
                //g.drawLine((int) x1, (int) y1, (int) (x1 + x2), (int) (y1 - y2));
                lista.addRamo((int) x1, (int) y1, (int) (x1 + x2), (int) (y1 - y2), nivel);

            } else {
                x2 = ramo * Math.cos(tetha);
                y2 = ramo * Math.sin(tetha);

                // g.drawLine(x1, y1, x1 - x2, y1 - y2)
                //g.drawLine((int) x1, (int) y1, (int) (x1 + x2), (int) (y1 - y2));
                lista.addRamo((int) x1, (int) y1, (int) (x1 + x2), (int) (y1 - y2), nivel);

            }

            if (esquerda) {
                x2 = ramo * Math.cos(tetha);
                y2 = ramo * Math.sin(tetha);

                //g.drawLine((int) x1, (int) y1, (int) (x1 + x2), (int) (y1 - y2));
                lista.addRamo((int) x1, (int) y1, (int) (x1 + x2), (int) (y1 - y2), nivel);
            } else {
                x2 = ramo * Math.cos(tetha + 2 * taxa);
                y2 = ramo * Math.sin(tetha + 2 * taxa);

                //g.drawLine((int) x1, (int) y1, (int) (x1 + x2), (int) (y1 - y2));
                lista.addRamo((int) x1, (int) y1, (int) (x1 + x2), (int) (y1 - y2), nivel);
            }
        } else if (nivel == 1) {

            double x2 = ramo * Math.cos(Math.PI / 2 - tetha);
            double y2 = ramo * Math.sin(Math.PI / 2 - tetha);

            // g.drawLine(x1, y1, x1 - x2, y1 - y2)
            //g.drawLine((int) x1, (int) y1, (int) (x1 + x2), (int) (y1 - y2));
            lista.addRamo((int) x1, (int) y1, (int) (x1 + x2), (int) (y1 - y2), nivel);

            // primeiro ramo
            passoRecusrsivo(g, nivel + 1, nivelMax, (x1 + x2), (y1 - y2), (Math.PI / 2 - tetha) - taxa,
                    (int) (ramo - ramo / 3.5), taxa, false, lista);
            x2 = ramo * Math.cos(Math.PI / 2 + tetha);
            y2 = ramo * Math.sin(Math.PI / 2 + tetha);

            //g.drawLine((int) x1, (int) y1, (int) (x1 + x2), (int) (y1 - y2));
            lista.addRamo((int) x1, (int) y1, (int) (x1 + x2), (int) (y1 - y2), nivel);
            // segundo ramo
            passoRecusrsivo(g, nivel + 1, nivelMax, (x1 + x2), (y1 - y2), (Math.PI / 2 + tetha) + taxa,
                    (int) (ramo - ramo / 3.5), taxa, true, lista);
        } else if (nivel < nivelMax) {

            double x2, y2;

            if (esquerda) {
                x2 = ramo * Math.cos(tetha - 2 * taxa);
                y2 = ramo * Math.sin(tetha - 2 * taxa);

                // g.drawLine(x1, y1, x1 - x2, y1 - y2)
                //g.drawLine((int) x1, (int) y1, (int) (x1 + x2), (int) (y1 - y2));
                lista.addRamo((int) x1, (int) y1, (int) (x1 + x2), (int) (y1 - y2), nivel);

                // primeiro ramo
                passoRecusrsivo(g, nivel + 1, nivelMax, (x1 + x2), (y1 - y2), (tetha - 2 * taxa) - taxa,
                        (int) (ramo - ramo / 3.5), taxa, false, lista);

            } else {
                x2 = ramo * Math.cos(tetha);
                y2 = ramo * Math.sin(tetha);

                // g.drawLine(x1, y1, x1 - x2, y1 - y2)
                //g.drawLine((int) x1, (int) y1, (int) (x1 + x2), (int) (y1 - y2));
                lista.addRamo((int) x1, (int) y1, (int) (x1 + x2), (int) (y1 - y2), nivel);

                // primeiro ramo
                passoRecusrsivo(g, nivel + 1, nivelMax, (x1 + x2), (y1 - y2), tetha - taxa,
                        (int) (ramo - ramo / 3.5), taxa, esquerda, lista);
            }

            if (esquerda) {
                x2 = ramo * Math.cos(tetha);
                y2 = ramo * Math.sin(tetha);

                //g.drawLine((int) x1, (int) y1, (int) (x1 + x2), (int) (y1 - y2));
                lista.addRamo((int) x1, (int) y1, (int) (x1 + x2), (int) (y1 - y2), nivel);
                // segundo ramo
                passoRecusrsivo(g, nivel + 1, nivelMax, (x1 + x2), (y1 - y2), tetha + taxa,
                        (int) (ramo - ramo / 3.5), taxa, esquerda, lista);
            } else {
                x2 = ramo * Math.cos(tetha + 2 * taxa);
                y2 = ramo * Math.sin(tetha + 2 * taxa);

                //g.drawLine((int) x1, (int) y1, (int) (x1 + x2), (int) (y1 - y2));
                lista.addRamo((int) x1, (int) y1, (int) (x1 + x2), (int) (y1 - y2), nivel);
                // segundo ramo
                passoRecusrsivo(g, nivel + 1, nivelMax, (x1 + x2), (y1 - y2), tetha + taxa,
                        (int) (ramo - ramo / 3.5), taxa, esquerda, lista);
            }

        }

    }

}
