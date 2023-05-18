package com.example;

import com.example.models.Usuario;
import javax.swing.JOptionPane;

public class Filmes2 extends javax.swing.JFrame {
    
    Usuario user;

    public Filmes2() {
        initComponents();

    }

    public Filmes2(Usuario user){
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
        pesquisarButton = new javax.swing.JButton();
        recomendacoesButton = new javax.swing.JButton();

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

        pesquisarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search.png"))); // NOI18N
        pesquisarButton.setBorder(null);
        pesquisarButton.setBorderPainted(false);
        pesquisarButton.setContentAreaFilled(false);
        pesquisarButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pesquisarButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/image/searchPressed.png"))); // NOI18N
        pesquisarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarButtonActionPerformed(evt);
            }
        });
        jPanel1.add(pesquisarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(281, 316, -1, -1));

        recomendacoesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/recommend.png"))); // NOI18N
        recomendacoesButton.setBorder(null);
        recomendacoesButton.setBorderPainted(false);
        recomendacoesButton.setContentAreaFilled(false);
        recomendacoesButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        recomendacoesButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/image/recommendPressed.png"))); // NOI18N
        recomendacoesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recomendacoesButtonActionPerformed(evt);
            }
        });
        jPanel1.add(recomendacoesButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(554, 313, -1, -1));

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
        Home home = new Home(this.user);
        
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_voltarButtonActionPerformed

    private void pesquisarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarButtonActionPerformed

        Explorar exp = new Explorar(user);

        exp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_pesquisarButtonActionPerformed

    private void recomendacoesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recomendacoesButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_recomendacoesButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Filmes2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Filmes2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Filmes2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Filmes2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Filmes2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logoMini;
    private javax.swing.JButton pesquisarButton;
    private javax.swing.JButton recomendacoesButton;
    private javax.swing.JButton voltarButton;
    // End of variables declaration//GEN-END:variables
}
