package com.example;

import com.example.models.Usuario;
import javax.swing.JOptionPane;

public class Filmes2PesquisarResultado extends javax.swing.JFrame {
    
    Usuario user;

    public Filmes2PesquisarResultado() {
        initComponents();

    }

    public Filmes2PesquisarResultado(Usuario user){
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
        pesquisarLabel = new javax.swing.JLabel();
        explorarBox2 = new javax.swing.JLabel();
        anoFilme = new javax.swing.JLabel();
        notaFilme = new javax.swing.JLabel();
        nomeFilme = new javax.swing.JLabel();
        filmePoster = new javax.swing.JLabel();
        dirButton = new javax.swing.JButton();
        esqButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();

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

        pesquisarLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Pesquisar.png"))); // NOI18N
        pesquisarLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pesquisarLabelMouseClicked(evt);
            }
        });
        jPanel1.add(pesquisarLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(414, 22, -1, -1));

        explorarBox2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/explorarBox2.png"))); // NOI18N
        explorarBox2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                explorarBox2MouseClicked(evt);
            }
        });
        jPanel1.add(explorarBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(341, 141, -1, -1));

        anoFilme.setFont(new java.awt.Font("Sansita One", 0, 32)); // NOI18N
        anoFilme.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        anoFilme.setText("ANO");
        anoFilme.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(anoFilme, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 206, 320, -1));

        notaFilme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/nota1.png"))); // NOI18N
        jPanel1.add(notaFilme, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 536, -1, -1));

        nomeFilme.setFont(new java.awt.Font("Sansita One", 0, 32)); // NOI18N
        nomeFilme.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nomeFilme.setText("FILME");
        nomeFilme.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(nomeFilme, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 173, 320, -1));
        jPanel1.add(filmePoster, new org.netbeans.lib.awtextra.AbsoluteConstraints(415, 256, 193, 255));

        dirButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/setaD2.png"))); // NOI18N
        dirButton.setBorder(null);
        dirButton.setBorderPainted(false);
        dirButton.setContentAreaFilled(false);
        dirButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dirButtonActionPerformed(evt);
            }
        });
        jPanel1.add(dirButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(726, 366, -1, -1));

        esqButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/setaE2.png"))); // NOI18N
        esqButton.setBorder(null);
        esqButton.setBorderPainted(false);
        esqButton.setContentAreaFilled(false);
        esqButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        esqButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                esqButtonActionPerformed(evt);
            }
        });
        jPanel1.add(esqButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 366, -1, -1));

        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/likeButtonPressed.png"))); // NOI18N
        saveButton.setBorder(null);
        saveButton.setBorderPainted(false);
        saveButton.setContentAreaFilled(false);
        saveButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        jPanel1.add(saveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 654, -1, -1));

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
        Filmes2Pesquisar search2 = new Filmes2Pesquisar(this.user);
        
        search2.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_voltarButtonActionPerformed

    private void logoMiniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoMiniMouseClicked
        Home home = new Home(this.user);

        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoMiniMouseClicked

    private void pesquisarLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pesquisarLabelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_pesquisarLabelMouseClicked

    private void explorarBox2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_explorarBox2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_explorarBox2MouseClicked

    private void dirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dirButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dirButtonActionPerformed

    private void esqButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_esqButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_esqButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Filmes2PesquisarResultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Filmes2PesquisarResultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Filmes2PesquisarResultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Filmes2PesquisarResultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new Filmes2PesquisarResultado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel anoFilme;
    private javax.swing.JButton dirButton;
    private javax.swing.JButton esqButton;
    private javax.swing.JLabel explorarBox2;
    private javax.swing.JLabel filmePoster;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logoMini;
    private javax.swing.JLabel nomeFilme;
    private javax.swing.JLabel notaFilme;
    private javax.swing.JLabel pesquisarLabel;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton voltarButton;
    // End of variables declaration//GEN-END:variables
}
