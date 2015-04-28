package com.it.kailash.whitepapers.shapewindow;


/* Swing Whitepaper
* This class is to demonstrate the WindowTranslucency feature by Varying Translucency by varying the Gradient pixel value
* Created By - Kailash Chander
*/

	import java.awt.Color;
	import java.awt.GradientPaint;
	import java.awt.Graphics;
	import java.awt.Graphics2D;
	import java.awt.GraphicsDevice;
	import java.awt.GraphicsDevice.WindowTranslucency;
	import java.awt.GraphicsEnvironment;
	import java.awt.Paint;

	import javax.swing.JFrame;
	import javax.swing.JPanel;

	public class VaryingGradientWindowTest {

	  public static void main(String[] args) {
	    GraphicsEnvironment envmt = GraphicsEnvironment
	        .getLocalGraphicsEnvironment();
	    GraphicsDevice device = envmt.getDefaultScreenDevice();

	    if (!device
	        .isWindowTranslucencySupported(WindowTranslucency.PERPIXEL_TRANSLUCENT)) {
	      System.out
	          .println("Translucent windows are not supported on your system.");
	      System.exit(0);
	    }
	    JFrame.setDefaultLookAndFeelDecorated(true);
	    ApplicationWindow window = new ApplicationWindow();
	    window.setVisible(true);
	  }
	}

	class ApplicationWindow extends JFrame {

	  public ApplicationWindow() {
	    setBackground(new Color(0, 0, 0, 0));
	    this.setSize(200, 200);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    JPanel panel = new JPanel() {
	      @Override
	      protected void paintComponent(Graphics gradient) {
	        if (gradient instanceof Graphics2D) {
	          final int Red = 150;
	          final int Green = 150;
	          final int Blue = 150;
	          Paint paint = new GradientPaint(0.0f, 0.0f, new Color(Red, Green,
	              Blue, 0), getWidth(), getHeight(), new Color(Red, Green, Blue,
	              255));
	          Graphics2D gradient2d = (Graphics2D) gradient;
	          gradient2d.setPaint(paint);
	          gradient2d.fillRect(0, 0, getWidth(), getHeight());
	        }
	      }
	    };
	    this.setContentPane(panel);
	  }
	}
