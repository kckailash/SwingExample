package com.it.kailash.swing.whitepapers;
/*
	Subject: Swing Whitepaper
 * This class is responsible creating a JLayer and demonstrating the RespondToEvent Feature.
 * Created By - Kailash Chander
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.LayerUI;

public class RespondingToEvent {
  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createUI();
      }
    });
  }

  public static void createUI() {
    JFrame f = new JFrame ("RespondinToEvent");
    
    LayerUI<JPanel> layerUI = new SpotlightLayerUI();
    JPanel panel = createPanel();
    JLayer<JPanel> jlayer = new JLayer<JPanel>(panel, layerUI);
    
    f.add (jlayer);
    
    f.setSize(500, 400);
    f.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    f.setLocationRelativeTo (null);
    f.setVisible (true);
  }

  private static JPanel createPanel() {
    JPanel p = new JPanel();

    ButtonGroup entreeGroup = new ButtonGroup();
    JRadioButton radioButton;
    p.add(radioButton = new JRadioButton("JAVA", true));
    entreeGroup.add(radioButton);
    p.add(radioButton = new JRadioButton(".NET"));
    entreeGroup.add(radioButton);
    p.add(radioButton = new JRadioButton("C++"));
    entreeGroup.add(radioButton);

    p.add(new JCheckBox("JDK"));
    p.add(new JCheckBox("MongoDB"));
    p.add(new JCheckBox("MySQL"));

    p.add(new JLabel("Special requests is below:"));
    p.add(new JTextField(20));

    JButton orderButton = new JButton("Place Software orders");
    p.add(orderButton);

    return p;
  }
}

/*
 * This Method will create a Spotlight when we mouse over the frame.
 */
class SpotlightLayerUI extends LayerUI<JPanel> {
  private boolean mActive;
  private int mX, mY;

  @Override
  public void installUI(JComponent c) {
    super.installUI(c);
    JLayer jlayer = (JLayer)c;
    jlayer.setLayerEventMask(
      AWTEvent.MOUSE_EVENT_MASK |
      AWTEvent.MOUSE_MOTION_EVENT_MASK
    );
  }

  @Override
  public void uninstallUI(JComponent c) {
    JLayer jlayer = (JLayer)c;
    jlayer.setLayerEventMask(0);
    super.uninstallUI(c);
  }

  @Override
  public void paint (Graphics g, JComponent c) {
    Graphics2D g2 = (Graphics2D)g.create();

    // Paint the view.
    super.paint (g2, c);

    if (mActive) {
      // Create a radial gradient, transparent in the middle.
      java.awt.geom.Point2D center = new java.awt.geom.Point2D.Float(mX, mY);
      float radius = 72;
      float[] dist = {0.0f, 1.0f};
      Color[] colors = {new Color(0.0f, 0.0f, 0.0f, 0.0f), Color.BLACK};
      RadialGradientPaint p =
          new RadialGradientPaint(center, radius, dist, colors);
      g2.setPaint(p);
      g2.setComposite(AlphaComposite.getInstance(
          AlphaComposite.SRC_OVER, .6f));
      g2.fillRect(0, 0, c.getWidth(), c.getHeight());
    }

    g2.dispose();
  }

  @Override
  protected void processMouseEvent(MouseEvent e, JLayer l) {
    if (e.getID() == MouseEvent.MOUSE_ENTERED) mActive = true;
    if (e.getID() == MouseEvent.MOUSE_EXITED) mActive = false;
    l.repaint();
  }
  //Actual method where the Mouseover event happens.

  @Override
  protected void processMouseMotionEvent(MouseEvent e, JLayer l) {
    Point p = SwingUtilities.convertPoint(e.getComponent(), e.getPoint(), l);
    mX = p.x;
    mY = p.y;
    l.repaint();
  }
}