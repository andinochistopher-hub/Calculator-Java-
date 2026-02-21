import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculadoraChris01 extends JFrame {

//componentes visuales (objetos)
private JTextField display; // Donde se muestra los numeros y resultados 
private JPanel panelBotones; // Panel para botones
private JButton[] botonesNumeros; // Botones 0-9
private JButton btnSumar, btnResta, btnMultiplicar, btnDivision, btnIgual, btnLimpiar;

//Variables para logica
private double resultado = 0;
private String operador = "";
private boolean nuevaOperacion= true;

//Constructor - aqui creamos y organizamos los objetivos 
public CalculadoraChris01 (){
   //Configuracion de la ventana
   setTitle ("Calculadora simple");
   setSize (300, 400);
   setLocationRelativeTo(null); //Centrar
   setDefaultCloseOperation (EXIT_ON_CLOSE);
   setLayout (new BorderLayout());
   
   //Display (JTextField)
   display = new JTextField ("0");
   display.setFont(new Font("Arial", Font.BOLD, 24));
   display .setHorizontalAlignment(JTextField.RIGHT);
   display.setEditable(false);
   add(display, BorderLayout.NORTH);
   
   //Panel botones con GridLayout 4x4
   panelBotones = new JPanel();
   panelBotones.setLayout (new GridLayout(4, 4, 5, 5));
   
   //Crear botones de numeris y agregarlos
   botonesNumeros = new JButton[10];
   for (int i = 0; i <=9; i++) {
       botonesNumeros[i] = new JButton(String.valueOf(i));
       botonesNumeros[i].setFont(new Font("Arial", Font.BOLD, 18));
       botonesNumeros[i].addActionListener(new numListener());
   }
   
   
//Crear Botones de operaciones
btnSumar = new JButton("+");
btnResta = new JButton("-");
btnMultiplicar = new JButton("*");
btnDivision = new JButton("/");
btnIgual = new JButton("=");
btnLimpiar = new JButton("C");
   
   //Set fuente para botones de operaciones 
     JButton[] ops = {btnSumar, btnResta, btnMultiplicar, btnDivision, btnIgual, btnLimpiar};
   for (JButton b : ops) {
       b.setFont(new Font("Arial", Font.BOLD,18));
       b.addActionListener (new OpListener()) ;
   }
   
   //Añadir botones al panel en orden logico (4x4)
   panelBotones.add(botonesNumeros[7]);
   panelBotones.add(botonesNumeros[8]);
   panelBotones.add(botonesNumeros[9]);
   panelBotones.add(btnDivision);
   
   panelBotones.add(botonesNumeros[4]);
   panelBotones.add(botonesNumeros[5]);
   panelBotones.add(botonesNumeros[6]);
   panelBotones.add(btnMultiplicar);     
   
   panelBotones.add(botonesNumeros[1]);
   panelBotones.add(botonesNumeros[2]);
   panelBotones.add(botonesNumeros[3]);
   
   panelBotones.add(btnLimpiar);
   panelBotones.add(botonesNumeros[0]);
   panelBotones.add(btnIgual);
   panelBotones.add(btnSumar);
   
   add(panelBotones , BorderLayout.CENTER) ;
}
//Listener para botones numericos 
private class numListener implements ActionListener {
    public void ActionPerformed(ActionEvent e ) {
        String num = e.getActionCommand (); 
        
        if (nuevaOperacion) {
            display.setText(num);
            nuevaOperacion = false;
        } else {
            display.setText(display.getText() + num);
            
        }
        }
    }
}
