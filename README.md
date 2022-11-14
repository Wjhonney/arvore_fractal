# Árvore fractal
 A árvore fractal é um exemplo de fractal autossimilar, é uma figura que necessita de uma pilha de processos ou de alguma estrutura de dados auxiliar, similar a pilha de processos.
 
## Como mudar o nível?
 Para mudar o nível máximo da árvore basta mudar a chamada de função na linha 28 da classe Desenho </br>
 `passoRecusrsivo(g, 0, nivelMaximo, abscissa / 2, ordenada - ramo, Math.PI / 2.8, ramo, Math.PI / 3, false, lista);` </br>
 o terceiro argumento diz o nível máximo que será calculado, altere para a quantidade desejada. </br>
