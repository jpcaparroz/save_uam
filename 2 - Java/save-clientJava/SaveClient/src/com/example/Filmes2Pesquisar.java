package com.example;

import com.example.models.Usuario;
import javax.swing.JOptionPane;

public class Filmes2Pesquisar extends javax.swing.JFrame {
    
    Usuario user;

    public Filmes2Pesquisar() {
        initComponents();

    }

    public Filmes2Pesquisar(Usuario user){
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
        pesquisarField = new javax.swing.JTextField();
        voltarButton = new javax.swing.JButton();
        pesquisarLabel = new javax.swing.JButton();
        searchBarImg = new javax.swing.JButton();

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

        pesquisarField.setText("Pesquisar...");
        pesquisarField.setBorder(null);
        jPanel1.add(pesquisarField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, 490, 47));

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
        pesquisarLabel.setBorder(null);
        pesquisarLabel.setBorderPainted(false);
        pesquisarLabel.setContentAreaFilled(false);
        pesquisarLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pesquisarLabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarLabelActionPerformed(evt);
            }
        });
        jPanel1.add(pesquisarLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(414, 22, -1, -1));

        searchBarImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/SearchBar.png"))); // NOI18N
        searchBarImg.setBorder(null);
        searchBarImg.setBorderPainted(false);
        searchBarImg.setContentAreaFilled(false);
        searchBarImg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchBarImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBarImgActionPerformed(evt);
            }
        });
        jPanel1.add(searchBarImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 357, -1, -1));

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

    private void pesquisarLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarLabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pesquisarLabelActionPerformed

    private void searchBarImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBarImgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBarImgActionPerformed

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
            java.util.logging.Logger.getLogger(Filmes2Pesquisar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Filmes2Pesquisar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Filmes2Pesquisar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Filmes2Pesquisar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Filmes2Pesquisar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logoMini;
    private javax.swing.JTextField pesquisarField;
    private javax.swing.JButton pesquisarLabel;
    private javax.swing.JButton searchBarImg;
    private javax.swing.JButton voltarButton;
    // End of variables declaration//GEN-END:variables
}