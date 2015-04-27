package com.it.tcs.whitepapers.shapewindow;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 

/* Swing Whitepaper
* This class is to demonstrate the use JSColorChooser in JDK7 , Added feature of HSV color
* Created By - Kailash Chander
*/
public class AbstractColorChooserPanel {
    
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;

   public AbstractColorChooserPanel(){
      prepareGUI();
   }

   public static void main(String[] args){
      AbstractColorChooserPanel  swingControlDemo = new AbstractColorChooserPanel();      
      swingControlDemo.showColorChooserDemo();
   }

   private void prepareGUI(){
      mainFrame = new JFrame("Java Swing Examples");
      mainFrame.setSize(400,400);
      mainFrame.setLayout(new GridLayout(3, 1));
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
      headerLabel = new JLabel("", JLabel.CENTER);        
      statusLabel = new JLabel("",JLabel.CENTER);    

      statusLabel.setSize(350,100);

      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);  
   }

   private void showColorChooserDemo(){
      headerLabel.setText("Control in action: JColorChooser"); 

      JButton chooseButton = new JButton("Choose Background");        
      chooseButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            Color backgroundColor = JColorChooser.showDialog(mainFrame,
               "Choose background color", Color.white);
            if(backgroundColor != null){
               controlPanel.setBackground(backgroundColor);
               mainFrame.getContentPane().setBackground(backgroundColor);
            }
         }
      });

      controlPanel.add(chooseButton);
      mainFrame.setVisible(true);  
   }
}