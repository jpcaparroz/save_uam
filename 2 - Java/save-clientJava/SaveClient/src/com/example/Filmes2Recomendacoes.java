package com.example;

import com.example.models.Usuario;
import javax.swing.JOptionPane;

public class Filmes2Recomendacoes extends javax.swing.JFrame {
    
    Usuario user;

    public Filmes2Recomendacoes() {
        initComponents();

    }

    public Filmes2Recomendacoes(Usuario user){
        initComponents();
        
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
        voltarButton = new javax.swing.JButton();
        recomendacoesLabel = new javax.swing.JButton();
        top100label = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1024, 768));
        jPanel1.setMinimumSize(new java.awt.Dimension(1024, 768));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logoMini.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/saveLogoMini.png"))); // NOI18N
        logoMini.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoMiniMouseClicked(evt);
            }
        });
        jPanel1.add(logoMini, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        voltarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/voltar.png"))); // NOI18N
        voltarButton.setBorder(null);
        voltarButton.setBorderPainted(false);
        voltarButton.setContentAreaFilled(false);
        voltarButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        voltarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarButtonActionPerformed(evt);
            }
        });
        jPanel1.add(voltarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 10, -1, -1));

        recomendacoesLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/recomendacoes.png"))); // NOI18N
        recomendacoesLabel.setBorder(null);
        recomendacoesLabel.setBorderPainted(false);
        recomendacoesLabel.setContentAreaFilled(false);
        recomendacoesLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        recomendacoesLabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recomendacoesLabelActionPerformed(evt);
            }
        });
        jPanel1.add(recomendacoesLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(371, 22, -1, -1));

        top100label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/top100.png"))); // NOI18N
        top100label.setBorder(null);
        top100label.setBorderPainted(false);
        top100label.setContentAreaFilled(false);
        top100label.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        top100label.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                top100labelActionPerformed(evt);
            }
        });
        jPanel1.add(top100label, new org.netbeans.lib.awtextra.AbsoluteConstraints(407, 70, -1, -1));

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

    private void voltarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarButtonActionPerformed
        Filmes2 filmes2 = new Filmes2(this.user);
        
        filmes2.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_voltarButtonActionPerformed

    private void recomendacoesLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recomendacoesLabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_recomendacoesLabelActionPerformed

    private void top100labelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_top100labelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_top100labelActionPerformed

    private void logoMiniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoMiniMouseClicked
        Home home = new Home(this.user);

        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoMiniMouseClicked

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
            java.util.logging.Logger.getLogger(Filmes2Recomendacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Filmes2Recomendacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Filmes2Recomendacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Filmes2Recomendacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Filmes2Recomendacoes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logoMini;
    private javax.swing.JButton recomendacoesLabel;
    private javax.swing.JButton top100label;
    private javax.swing.JButton voltarButton;
    // End of variables declaration//GEN-END:variables
}
