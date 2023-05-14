/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pt5;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Timer;



/**
 *
 * @author kentl
 */
public class GameFrame extends javax.swing.JFrame {
    
    private Timer timer;
    private List<JLabel> cars;
    private int carSpeed;
    private int carSpacing;
    private int level;

    /**
     * Creates new form GameFrame
     */
    public GameFrame() {
        
        initComponents();
        
        pLabel.addKeyListener(new KeyAdapter() {
    @Override
    public void keyPressed(KeyEvent evt) {
        formKeyPressed(evt);
    }
});
           
        carSpeed = 10; // Adjust the car speed as needed
        carSpacing = 200; // Adjust the spacing between cars as needed
        cars = new ArrayList<>();
        cars.add(carLabel1);
        cars.add(carLabel2);
        cars.add(carLabel3);
        cars.add(carLabel4);
        cars.add(carLabel5);
        cars.add(carLabel6);   
        cars.add(carLabel7);
        cars.add(carLabel8);
        level = 1;
        jLabel1.setText("Current Level: "+ level);

        timer = new Timer(50, new GameActionListener());
        timer.start();
       
}  
        private class GameActionListener implements ActionListener {
           @Override
           public void actionPerformed(ActionEvent e) {
               // Move the cars
               System.out.println("Logged");
               System.out.println(cars.size());

               for (JLabel car : cars) {
                   int x = car.getX();
                   if(cars.indexOf(car) > 3){
                       car.setLocation(x + carSpeed, car.getY());
                                          if (x >= jPanel1.getWidth()) {
                         // Car has reached the right edge, reposition it to the left
                        
                         car.setLocation(-50, car.getY());
                     }
                        
                   }else{
                   car.setLocation(x - carSpeed, car.getY());

                     
                                         if (x + car.getWidth() <= 0) {
                       // Car has reached the left edge, reposition it to the right
                       int newX = jPanel1.getWidth() + carSpacing;
                       car.setLocation(newX, car.getY());
                   }
                   }
                   

                 
                 

               }

               // Check for collision with cars
               checkCollision();
               checkGoal();
           }
       }
        
    private void checkGoal() {
         Rectangle frogBounds = pLabel.getBounds();
         int y = frogBounds.y;
            System.out.println(y <= 160);
            if(y <= 160){
                level++;
                gameComplete();
            }

        
    }
    
    private void checkCollision() {
        Rectangle frogBounds = pLabel.getBounds();

        for (JLabel car : cars) {
            Rectangle carBounds = car.getBounds();

            if (frogBounds.intersects(carBounds)) {
                // Frog collided with a car, implement the game over logic here
                gameOver();
                break;
            }
        }
    }
    private void gameComplete() {
        
        timer.stop();
        int input = JOptionPane.showOptionDialog(null, "Game Complete! \nContinue?", "Winner!", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

        if(input == JOptionPane.OK_OPTION)
        {
            jLabel1.setText("Current Level: "+ level);
              pLabel.setLocation(280, 560);
              carSpeed = carSpeed+5;
              timer.restart();
                // do something
        }else{
            System.exit(0);
        }
                // Add any additional game over logic as needed
            }
   
   
    private void gameOver() {
                timer.stop();
                int input = JOptionPane.showOptionDialog(null, "Restart?", "Game Over", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

        if(input == JOptionPane.OK_OPTION)
        {
              // Reset game state
                carSpeed = 10;
                carSpacing = 200;
                level = 1;
                jLabel1.setText("Current Level: " + level);
                pLabel.setLocation(280, 560);
                timer.restart();
                                 
     
        }else{
            System.exit(0);
        }
                // Add any additional game over logic as needed
            }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pLabel = new javax.swing.JLabel();
        carLabel1 = new javax.swing.JLabel();
        carLabel2 = new javax.swing.JLabel();
        carLabel3 = new javax.swing.JLabel();
        carLabel4 = new javax.swing.JLabel();
        carLabel5 = new javax.swing.JLabel();
        carLabel6 = new javax.swing.JLabel();
        carLabel7 = new javax.swing.JLabel();
        carLabel8 = new javax.swing.JLabel();
        bgLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RoadRunner");
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Current Level: 1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 570, -1, 20));

        pLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pfront2.png"))); // NOI18N
        jPanel1.add(pLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 560, 30, -1));

        carLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/car1 - Copy.png"))); // NOI18N
        carLabel1.setText("jLabel1");
        jPanel1.add(carLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, 90, -1));

        carLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/car3 - Copy.png"))); // NOI18N
        carLabel2.setText("jLabel1");
        jPanel1.add(carLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 510, 90, -1));

        carLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/car2 - Copy.png"))); // NOI18N
        carLabel3.setText("jLabel1");
        jPanel1.add(carLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 460, 90, -1));

        carLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/car4 - Copy.png"))); // NOI18N
        carLabel4.setText("jLabel1");
        jPanel1.add(carLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 420, 90, -1));

        carLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/car3.png"))); // NOI18N
        carLabel5.setText("jLabel1");
        jPanel1.add(carLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 340, 90, -1));

        carLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/car1.png"))); // NOI18N
        carLabel6.setText("jLabel1");
        jPanel1.add(carLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 90, -1));

        carLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/car2.png"))); // NOI18N
        carLabel7.setText("jLabel1");
        jPanel1.add(carLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 250, 90, -1));

        carLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/car4.png"))); // NOI18N
        carLabel8.setText("jLabel1");
        jPanel1.add(carLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 90, -1));

        bgLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bgpng.png"))); // NOI18N
        jPanel1.add(bgLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
    
    // Player
    int x = pLabel.getX();
    int y = pLabel.getY();
    int stepSize = 0; // Adjust this value to control the movement speed
    
    // Step Distance
    if (y >= 350) {
        stepSize = 45; 
    //    } else if (y <= 380) {
    //        step = 40; 
    } else {
        stepSize = 45;
    } 
    
    // Border
    
        int borderX = 5; // Adjust these values as needed
        int borderY = 5;
        int borderW = getWidth() - 2 * 5;
        int borderH = getHeight() - 2 * 5;
    
        
    // Controls
    switch (evt.getKeyCode()) {
        case java.awt.event.KeyEvent.VK_UP -> {
            if (y - stepSize >= borderY) {
                pLabel.setLocation(x, y - stepSize);
                pLabel.setIcon(new ImageIcon(getClass().getResource("/images/pback.png")));
            }
            }
        case java.awt.event.KeyEvent.VK_DOWN -> {
            if (y + stepSize + pLabel.getHeight() <= borderY + borderH) {
                pLabel.setLocation(x, y + stepSize);
                pLabel.setIcon(new ImageIcon(getClass().getResource("/images/pfront2.png")));
            }
            }
        case java.awt.event.KeyEvent.VK_LEFT -> {
            if (x - stepSize >= borderX) {
                pLabel.setLocation(x - stepSize, y);
                pLabel.setIcon(new ImageIcon(getClass().getResource("/images/pleft.png")));
            }
            }
        case java.awt.event.KeyEvent.VK_RIGHT -> {
            if (x + stepSize + pLabel.getWidth() <= borderX + borderW) {
                pLabel.setLocation(x + stepSize, y);
                pLabel.setIcon(new ImageIcon(getClass().getResource("/images/pright.png")));
            }
            }
    }
    
    }//GEN-LAST:event_formKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
            
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
          public void run() {
            GameFrame runnerFrame = new GameFrame();
            runnerFrame.setVisible(true);
          }
    });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bgLabel;
    private javax.swing.JLabel carLabel1;
    private javax.swing.JLabel carLabel2;
    private javax.swing.JLabel carLabel3;
    private javax.swing.JLabel carLabel4;
    private javax.swing.JLabel carLabel5;
    private javax.swing.JLabel carLabel6;
    private javax.swing.JLabel carLabel7;
    private javax.swing.JLabel carLabel8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel pLabel;
    // End of variables declaration//GEN-END:variables

}