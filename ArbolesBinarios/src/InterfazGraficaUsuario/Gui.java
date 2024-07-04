/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InterfazGraficaUsuario;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Gui {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
       

        System.out.println("\nRecorrido PreOrden: ");
        arbol.recorrerPreOrden();
        System.out.println("\nRecorrido InOrden: ");
        arbol.recorrerInOrden();
        System.out.println("\nRecorrido PostOrden: ");
        arbol.recorrerPostOrden();
        
        System.out.println("Eliminando nodo con valor de 17");
        arbol.borrarNodo(17);
        
        JFrame frame = new JFrame("Árbol Binario");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        
        VistaArbol panel = new VistaArbol(arbol);
        frame.add(panel, BorderLayout.CENTER);


        
        JPanel controlPanel = new JPanel();
        JTextField valorField = new JTextField(5);
        JTextField valorEliminarField = new JTextField(5);
        JButton addButton = new JButton("Añadir Nodo");
        JButton deleteButton = new JButton("Eliminar Nodo");
        
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    int valor = Integer.parseInt(valorField.getText());
                    arbol.agregarNodo(valor);
                    valorField.setText("");
                    panel.repaint();
            }
        });
        
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                int valor = Integer.parseInt(valorEliminarField.getText());
                arbol.borrarNodo(valor);
                valorEliminarField.setText("");
                panel.repaint();
            }
        });
        
        controlPanel.add(new JLabel("Valor:"));
        controlPanel.add(valorField);
        controlPanel.add(addButton);
        controlPanel.add(valorEliminarField);
        controlPanel.add(deleteButton);
        frame.add(controlPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
