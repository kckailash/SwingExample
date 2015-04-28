package com.it.tcs.whitepapers.shapewindow;

import java.awt.*;
import javax.swing.*;
import static java.awt.GraphicsDevice.WindowTranslucency.*;
 
/* Swing Whitepaper
* This class is to demonstrate the uniform Translucency on window by defining a uniform opacity
* Created By - Kailash Chander
*/

public class UniformTranslucenySample extends JFrame {
    public UniformTranslucenySample() {
        super("TranslucentWindowTestByKailash");
        setLayout(new GridBagLayout());
 
        setSize(300,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Add a sample button.
        add(new JButton("This is a Button"));
    }
 
    public static void main(String[] args) {
        // Determine if the GraphicsDevice supports translucency.
        GraphicsEnvironment ge = 
            GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
 
        //If translucent windows aren't supported, exit.
        if (!gd.isWindowTranslucencySupported(TRANSLUCENT)) {
            System.err.println(
                "Translucency is not supported");
                System.exit(0);
        }
         
        JFrame.setDefaultLookAndFeelDecorated(true);
 
        // Create the GUI on the event-dispatching thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                UniformTranslucenySample tw = new UniformTranslucenySample();
 
                // Set the window to 80% opaque (20% translucent).
                tw.setOpacity(0.80f);
 
                // Display the window.
                tw.setVisible(true);
            }
        });
    }
}