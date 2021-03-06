package com.it.kailash.swing.whitepapers;


/*

Subject: Swing Whitepaper
* This class is responsible is to demonstrate the feature of Animation indicator in swing
* Created By - Kailash
*/


import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import javax.swing.*;
import javax.swing.plaf.LayerUI;
 
public class AnimateIndicatorSample1 {
  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new AnimateIndicatorSample1().createUI();
      }
    });
  }
 
  private JButton mOrderButton;
 
  public void createUI() {
    JFrame f = new JFrame ("AnimateIndicatorSample1");
     
    final WaitLayerUI layerUI = new WaitLayerUI();
    JPanel panel = createPanel();
    JLayer<JPanel> jlayer = new JLayer<JPanel>(panel, layerUI);
     
    final Timer stopper = new Timer(4000, new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        layerUI.stop();
      }
    });
    stopper.setRepeats(false);
 
    mOrderButton.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
          layerUI.start();
          if (!stopper.isRunning()) {
            stopper.start();
          }
        }
      }
    );
 
    f.add (jlayer);
     
    f.setSize(300, 200);
    f.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    f.setLocationRelativeTo (null);
    f.setVisible (true);
  }
 
  private JPanel createPanel() {
    JPanel p = new JPanel();
 
    ButtonGroup entreeGroup = new ButtonGroup();
    JRadioButton radioButton;
    p.add(radioButton = new JRadioButton("JAVA", true));
    entreeGroup.add(radioButton);
    p.add(radioButton = new JRadioButton(".NET"));
    entreeGroup.add(radioButton);
    p.add(radioButton = new JRadioButton("C++"));
    entreeGroup.add(radioButton);
 
    p.add(new JCheckBox("SQL"));
    p.add(new JCheckBox("JDK"));
    p.add(new JCheckBox("MongoDB"));
   // p.add(new JCheckBox("\n"));
    p.add(new JLabel("Special requests is here-->:"));
    p.add(new JTextField(20));
 
    mOrderButton = new JButton("Place Order in submit");
    p.add(mOrderButton);
 
    return p;
  }
}
 
// This is the actual class where in we have the busy indication based on the event
class WaitLayerUI extends LayerUI<JPanel> implements ActionListener {
  private boolean mIsRunning;
  private boolean mIsFadingOut;
  private Timer mTimer;
 
  private int mAngle;
  private int mFadeCount;
  private int mFadeLimit = 15;
 
  @Override
  public void paint (Graphics g, JComponent c) {
    int w = c.getWidth();
    int h = c.getHeight();
 
    // Paint the view.
    super.paint (g, c);
 
    if (!mIsRunning) {
      return;
    }
 
    Graphics2D g2 = (Graphics2D)g.create();
 
    float fade = (float)mFadeCount / (float)mFadeLimit;
    // Gray it out.
    Composite urComposite = g2.getComposite();
    g2.setComposite(AlphaComposite.getInstance(
        AlphaComposite.SRC_OVER, .5f * fade));
    g2.fillRect(0, 0, w, h);
    g2.setComposite(urComposite);
 
    // Paint the wait indicator.
    int s = Math.min(w, h) / 5;
    int cx = w / 2;
    int cy = h / 2;
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
    g2.setStroke(
        new BasicStroke(s / 4, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
    g2.setPaint(Color.white);
    g2.rotate(Math.PI * mAngle / 180, cx, cy);
    for (int i = 0; i < 12; i++) {
      float scale = (11.0f - (float)i) / 11.0f;
      g2.drawLine(cx + s, cy, cx + s * 2, cy);
      g2.rotate(-Math.PI / 6, cx, cy);
      g2.setComposite(AlphaComposite.getInstance(
          AlphaComposite.SRC_OVER, scale * fade));
    }
 
    g2.dispose();
  }
 /*This method uses the firePropertyChange() method to indicate that the internal state was updated. 
  This triggers a call to the applyPropertyChange() method.
  */
  public void actionPerformed(ActionEvent e) {
    if (mIsRunning) {
      firePropertyChange("tick", 0, 1);
      mAngle += 3;
      if (mAngle >= 360) {
        mAngle = 0;
      }
      if (mIsFadingOut) {
        if (--mFadeCount == 0) {
          mIsRunning = false;
          mTimer.stop();
        }
      }
      else if (mFadeCount < mFadeLimit) {
        mFadeCount++;
      }
    }
  }
 
  public void start() {
    if (mIsRunning) {
      return;
    }
     
    // Run a thread for animation.
    mIsRunning = true;
    mIsFadingOut = false;
    mFadeCount = 0;
    int fps = 24;
    int tick = 1000 / fps;
    mTimer = new Timer(tick, this);
    mTimer.start();
  }
 
  public void stop() {
    mIsFadingOut = true;
  }
 // This method repaints the JLayer object, whenever called from the actionPerformed on some event change 
  @Override
  public void applyPropertyChange(PropertyChangeEvent pce, JLayer layer) {
    if ("tick".equals(pce.getPropertyName())) {
      layer.repaint();
    }
  }
}
