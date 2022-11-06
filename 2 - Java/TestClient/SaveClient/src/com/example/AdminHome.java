package com.example;

import com.example.models.Usuario;
import javax.swing.JOptionPane;

public class AdminHome extends javax.swing.JFrame {
    
    Usuario user;

    public AdminHome() {
        initComponents();

    }

    public AdminHome(Usuario user){
        initComponents();
        
        nomeLabel.setText(user.getNome());
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
        olaLabel = new javax.swing.JLabel();
        nomeLabel = new javax.swing.JLabel();
        usuariosButton = new javax.swing.JButton();

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

        olaLabel.setFont(new java.awt.Font("Sansita", 1, 32)); // NOI18N
        olaLabel.setForeground(new java.awt.Color(0, 0, 0));
        olaLabel.setText("olá,");
        jPanel1.add(olaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 143, -1, -1));

        nomeLabel.setFont(new java.awt.Font("Sansita One", 1, 48)); // NOI18N
        nomeLabel.setForeground(new java.awt.Color(0, 0, 0));
        nomeLabel.setText("NOME");
        jPanel1.add(nomeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 490, -1));

        usuariosButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/usersIcon.png"))); // NOI18N
        usuariosButton.setBorder(null);
        usuariosButton.setBorderPainted(false);
        usuariosButton.setContentAreaFilled(false);
        usuariosButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        usuariosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuariosButtonActionPerformed(evt);
            }
        });
        jPanel1.add(usuariosButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(438, 334, -1, -1));

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

    private void usuariosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuariosButtonActionPerformed
        Users users = new Users(user);
        
        users.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_usuariosButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logoMini;
    private javax.swing.JButton logoutButton;
    private javax.swing.JLabel nomeLabel;
    private javax.swing.JLabel olaLabel;
    private javax.swing.JButton usuariosButton;
    // End of variables declaration//GEN-END:variables
}
