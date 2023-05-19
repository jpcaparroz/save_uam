package com.example;

import com.api.server.rmi.modules.Filme;
import com.api.server.rmi.modules.Usuario;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import com.api.server.rmi.SaveService;

public class Filmes2Pesquisar extends javax.swing.JFrame {
    
    Usuario user;
    List<Filme> listaFilme = new ArrayList<>();;

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
        pesquisarButton = new javax.swing.JButton();
        pesquisarField = new javax.swing.JTextField();
        pesquisarBar = new javax.swing.JLabel();
        pesquisarLabel = new javax.swing.JLabel();
        voltarButton = new javax.swing.JButton();

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

        pesquisarButton.setBorder(null);
        pesquisarButton.setBorderPainted(false);
        pesquisarButton.setContentAreaFilled(false);
        pesquisarButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pesquisarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarButtonActionPerformed(evt);
            }
        });
        jPanel1.add(pesquisarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 360, 50, 50));

        pesquisarField.setBackground(new java.awt.Color(255, 255, 255));
        pesquisarField.setFont(new java.awt.Font("Sansita", 0, 12)); // NOI18N
        pesquisarField.setForeground(new java.awt.Color(0, 0, 0));
        pesquisarField.setText("Pesquisar...");
        pesquisarField.setBorder(null);
        pesquisarField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarFieldActionPerformed(evt);
            }
        });
        jPanel1.add(pesquisarField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, 490, 47));

        pesquisarBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/SearchBar.png"))); // NOI18N
        jPanel1.add(pesquisarBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 357, -1, -1));

        pesquisarLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Pesquisar.png"))); // NOI18N
        jPanel1.add(pesquisarLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, -1, -1));

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

    private void logoMiniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoMiniMouseClicked
        Home home = new Home(this.user);

        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoMiniMouseClicked

    private void pesquisarFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pesquisarFieldActionPerformed

    private void pesquisarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarButtonActionPerformed
        String filme = pesquisarField.getText();
        
        try {

            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 18000);

            SaveService stub = (SaveService) registry.lookup("Save");

            listaFilme = stub.getFilme2();

        } catch (Exception e) {
            System.out.println(e);
        }

        Filmes2PesquisarResultado pesquisa = new Filmes2PesquisarResultado(this.user, this.listaFilme);
        
        pesquisa.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_pesquisarButtonActionPerformed

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
    private javax.swing.JLabel pesquisarBar;
    private javax.swing.JButton pesquisarButton;
    private javax.swing.JTextField pesquisarField;
    private javax.swing.JLabel pesquisarLabel;
    private javax.swing.JButton voltarButton;
    // End of variables declaration//GEN-END:variables
}
