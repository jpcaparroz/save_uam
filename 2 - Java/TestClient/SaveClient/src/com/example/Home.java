package com.example;

import com.example.models.Usuario;
import javax.swing.JOptionPane;

public class Home extends javax.swing.JFrame {
    
    Usuario user;

    public Home() {
        initComponents();

    }

    public Home(Usuario user){
        initComponents();
        
        nomeLabel.setText("olá, " + user.getNome());
        
        this.user = user;
    }
    
    //Método para aparecer uma mensagem pop-up
    public void mensagemPopUp(String mensagem){
        JOptionPane.showMessageDialog(null, mensagem);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        logoMini = new javax.swing.JLabel();
        logoutButton = new javax.swing.JButton();
        nomeLabel = new javax.swing.JLabel();
        filmesButton = new javax.swing.JButton();
        explorarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1024, 768));
        jPanel1.setMinimumSize(new java.awt.Dimension(1024, 768));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logoMini.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/saveLogoMini.png"))); // NOI18N
        jPanel1.add(logoMini, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        logoutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logoutIcon.png"))); // NOI18N
        logoutButton.setBorder(null);
        logoutButton.setBorderPainted(false);
        logoutButton.setContentAreaFilled(false);
        logoutButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });
        jPanel1.add(logoutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(986, 10, -1, -1));

        nomeLabel.setFont(new java.awt.Font("Sansita One", 1, 48)); // NOI18N
        nomeLabel.setForeground(new java.awt.Color(0, 0, 0));
        nomeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nomeLabel.setText("NOME");
        jPanel1.add(nomeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 1024, -1));

        filmesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/FilmsIcon.png"))); // NOI18N
        filmesButton.setBorder(null);
        filmesButton.setBorderPainted(false);
        filmesButton.setContentAreaFilled(false);
        filmesButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        filmesButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/image/FilmsIconPressed.png"))); // NOI18N
        filmesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filmesButtonActionPerformed(evt);
            }
        });
        jPanel1.add(filmesButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(346, 357, -1, -1));

        explorarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/mundoIcon.png"))); // NOI18N
        explorarButton.setBorder(null);
        explorarButton.setBorderPainted(false);
        explorarButton.setContentAreaFilled(false);
        explorarButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        explorarButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/image/mundoIconPressed.png"))); // NOI18N
        explorarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                explorarButtonActionPerformed(evt);
            }
        });
        jPanel1.add(explorarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(584, 372, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        Index index = new Index();
        
        index.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void filmesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filmesButtonActionPerformed
        
        Filmes filmes = new Filmes(this.user);
        
        filmes.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_filmesButtonActionPerformed

    private void explorarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_explorarButtonActionPerformed
        
        Explorar exp = new Explorar(user);
        
        exp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_explorarButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton explorarButton;
    private javax.swing.JButton filmesButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logoMini;
    private javax.swing.JButton logoutButton;
    private javax.swing.JLabel nomeLabel;
    // End of variables declaration//GEN-END:variables
}
