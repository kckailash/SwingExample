package com.it.kailash.whitepapers.heavyLightweightMixing;
import javax.swing.SwingUtilities;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


/*
 * Swing Whitepaper
* This class is to demonstrate the feature of Mixing low and Heavy weight component in Swing
* Created By - Kailash Chander
*/

public class HeayLightWtSample {

  public static void main(String[] args) {
    ApplicationWindow window = new ApplicationWindow();
    window.setVisible(true);
  }
}
class ApplicationWindow extends JFrame {
  public ApplicationWindow() {
    this.setSize(200, 100);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new FlowLayout());
    Button exitButton = new Button("Exit");
    exitButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        System.exit(0);
      }
    });
    this.add(exitButton);

    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("Overlapping Menu1");
    JMenu menu2 = new JMenu("Overlapping Menu 2");
    JMenuItem menuItem = new JMenuItem("Menu Item1");
    menu.add(menuItem);
    menu.add("Menu Item2");
    menu.add("Menu Item3");
    menu2.add("Menu Item3");
    menu2.add("Menu Item3");
    menuBar.add(menu);
    menuBar.add(menu2);
   // menuBar.add("Menu2");
    this.setJMenuBar(menuBar);
    this.validate();

  }
}