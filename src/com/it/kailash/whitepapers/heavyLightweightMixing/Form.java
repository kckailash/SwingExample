package com.it.kailash.whitepapers.heavyLightweightMixing;

import java.awt.Button;
import java.awt.Container;
import java.awt.Window;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Form extends javax.swing.JFrame {
    
    private long memoryR = 0;
    private long screenR = 0;
    private long lastDigit = 0;
    private boolean needNumber = true;    
    enum Operation {
        ADD,
        SUB,
        MUL,
        DIV;
    };
    
    Operation operation = null;
    
    /** Creates new form Form */
    public Form() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        button9 = new java.awt.Button();
        button10 = new java.awt.Button();
        button11 = new java.awt.Button();
        button4 = new java.awt.Button();
        button5 = new java.awt.Button();
        button6 = new java.awt.Button();
        button7 = new java.awt.Button();
        button8 = new java.awt.Button();
        button1 = new java.awt.Button();
        button2 = new java.awt.Button();
        button3 = new java.awt.Button();
        button16 = new java.awt.Button();
        button13 = new java.awt.Button();
        button14 = new java.awt.Button();
        button15 = new java.awt.Button();
        button12 = new java.awt.Button();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calculator");
        getContentPane().setLayout(new java.awt.BorderLayout(0, 10));

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel2.setLayout(new java.awt.BorderLayout(0, 10));

        jTextField1.setEditable(false);
        jPanel2.add(jTextField1, java.awt.BorderLayout.NORTH);

        jPanel1.setLayout(new java.awt.GridLayout(4, 4, 8, 8));

        button9.setLabel("7");
        button9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numericButtonActionPerformed(evt);
            }
        });
        jPanel1.add(button9);

        button10.setLabel("8");
        button10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numericButtonActionPerformed(evt);
            }
        });
        jPanel1.add(button10);

        button11.setLabel("9");
        button11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numericButtonActionPerformed(evt);
            }
        });
        jPanel1.add(button11);

        button4.setLabel("+");
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                operationButtonActionPerformed(evt);
            }
        });
        jPanel1.add(button4);

        button5.setLabel("4");
        button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numericButtonActionPerformed(evt);
            }
        });
        jPanel1.add(button5);

        button6.setLabel("5");
        button6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numericButtonActionPerformed(evt);
            }
        });
        jPanel1.add(button6);

        button7.setLabel("6");
        button7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numericButtonActionPerformed(evt);
            }
        });
        jPanel1.add(button7);

        button8.setLabel("-");
        button8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                operationButtonActionPerformed(evt);
            }
        });
        jPanel1.add(button8);

        button1.setLabel("1");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numericButtonActionPerformed(evt);
            }
        });
        jPanel1.add(button1);

        button2.setLabel("2");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numericButtonActionPerformed(evt);
            }
        });
        jPanel1.add(button2);

        button3.setLabel("3");
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numericButtonActionPerformed(evt);
            }
        });
        jPanel1.add(button3);

        button16.setLabel("x");
        button16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                operationButtonActionPerformed(evt);
            }
        });
        jPanel1.add(button16);

        button13.setLabel("0");
        button13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numericButtonActionPerformed(evt);
            }
        });
        jPanel1.add(button13);

        button14.setLabel("+/-");
        button14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signActionPerformed(evt);
            }
        });
        jPanel1.add(button14);

        button15.setLabel("=");
        button15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equalsActionPerformed(evt);
            }
        });
        jPanel1.add(button15);

        button12.setLabel("/");
        button12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                operationButtonActionPerformed(evt);
            }
        });
        jPanel1.add(button12);

        jPanel2.add(jPanel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jMenu1.setText("Menu");

        jMenuItem2.setText("Calculate");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equalsActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem1.setText("Clear");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem3.setText("Exit");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        setVisible(false);
        dispose();
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        screenR = 0;
        needNumber = true;
        updateScreen();        
    }//GEN-LAST:event_clearActionPerformed
    
    private void equalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equalsActionPerformed
        if (operation != null && !needNumber) {
            switch (operation) {
                case ADD: screenR += memoryR; break;
                case SUB: screenR = memoryR - screenR; break;
                case MUL: screenR = screenR * memoryR; break;
                case DIV:
                    if (screenR != 0) {
                        screenR = memoryR / screenR;
                    } else {
                        JOptionPane.showMessageDialog(this, "Divide by zero. Enter a non-zero divider.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    break;
            }
            operation = null;
            needNumber = true;
            updateScreen();
        } else {
            JOptionPane.showMessageDialog(this, "Nothing to calculate. Enter an expression first.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_equalsActionPerformed
    
    private void operationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_operationButtonActionPerformed
        if (operation != null && !needNumber) {
            equalsActionPerformed(evt);
        }
        if (operation != null && !needNumber) {
            return;
        }
        String strOp = ((Button)evt.getSource()).getLabel();
        if ("+".equals(strOp)) {
            operation = Operation.ADD;
        } else if ("-".equals(strOp)) {
            operation = Operation.SUB;
        } else if ("x".equals(strOp)) {
            operation = Operation.MUL;
        } else if ("/".equals(strOp)) {
            operation = Operation.DIV;
        }
        if (operation != null) {
            memoryR = screenR;
            needNumber = true;
        }
    }//GEN-LAST:event_operationButtonActionPerformed
    
    private void signActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signActionPerformed
        if (operation != null && needNumber) {
            return;
        }
        screenR = -screenR;
        updateScreen();
    }//GEN-LAST:event_signActionPerformed
    
    private void numericButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numericButtonActionPerformed
        if (needNumber) {
            screenR = 0;
        }
        lastDigit = Long.parseLong(((Button)evt.getSource()).getLabel());
        screenR = (screenR * 10) + lastDigit;
        needNumber = false;
        updateScreen();
    }//GEN-LAST:event_numericButtonActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form().setVisible(true);
            }
        });
    }
    
    private void updateScreen() {
        jTextField1.setText("" + screenR);

        // NOTE: Here we need a workaround for the HW/LW Mixing feature to work
        // correctly due to yet unfixed bug 6852592.
        // The JTextField is a validate root, so the revalidate() method called
        // during the setText() operation does not validate the parent of the
        // component. Therefore, we need to force validating its parent here.
        Container parent = jTextField1.getParent();
        if (parent instanceof JComponent) {
            ((JComponent)parent).revalidate();
        }

        // ... and just in case, call validate() on the top-level window as well
        Window window = SwingUtilities.getWindowAncestor(jTextField1);
        if (window != null) {
            window.validate();
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private java.awt.Button button10;
    private java.awt.Button button11;
    private java.awt.Button button12;
    private java.awt.Button button13;
    private java.awt.Button button14;
    private java.awt.Button button15;
    private java.awt.Button button16;
    private java.awt.Button button2;
    private java.awt.Button button3;
    private java.awt.Button button4;
    private java.awt.Button button5;
    private java.awt.Button button6;
    private java.awt.Button button7;
    private java.awt.Button button8;
    private java.awt.Button button9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
    
}