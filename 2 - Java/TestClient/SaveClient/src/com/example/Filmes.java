package com.example;

import com.example.models.*;
import java.awt.Image;
import java.io.InputStream;
import java.net.URL;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Filmes extends javax.swing.JFrame {
    
    Usuario user;
    List<FilmeUsuario> listaFilme = new ArrayList<>();
    int count = 0;
 
    public Filmes() {
        initComponents();
        
        listarFilmes();
        exibirMenu();
    }
    
    //Construtor recebendo user
    public Filmes(Usuario user) {
        initComponents();
        
        this.user = user;
        
        nomeLabel.setText(user.getNome());
        
        listarFilmes();
        exibirMenu();
    }
    
    //Método para exibir funções da página Filmes
    public void exibirMenu(){
        listaButton.hide();
        filmePoster.hide();
        filmesBox.hide();
        scrollBox.hide();
        filmesTable.hide();
        voltarButton.hide();
        
        listaButton.show();
        filmeButton.show();      
    }
    
    //Método para exibir funções do lista
    public void exibirLista(){
        
        scrollBox.show();
        filmesTable.show();
        voltarButton.show();
        filmesBox.show();
        
        descLabel.hide();
        nomeLabel.hide();
        listaButton.hide();
        filmeButton.hide();
        filmePoster.hide();
    }
    
    //Método para exibir funções do filme
    public void exibirFilme(){
        descLabel.hide();
        nomeLabel.hide();
        listaButton.hide();
        filmeButton.hide();
        
        filmePoster.show();
        voltarButton.show();
        filmesBox.show(); 
    }
    
    //redimensionando poster
    public Icon poster(String imagem) throws Exception{
        InputStream inputStream = new URL(imagem).openStream();
        Image posterImage = ImageIO.read(inputStream);
        
        Image nova = posterImage.getScaledInstance(220, 270, Image.SCALE_SMOOTH);
        
        ImageIcon icon = new ImageIcon(nova);
        return icon;
    }
    
    //Método para listar filmes
    public void listarFilmes(){
        DefaultTableModel defaultFilmes = (DefaultTableModel) filmesTable.getModel();
        defaultFilmes.setRowCount(0);

        try {

            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 18000);

            Save stub = (Save) registry.lookup("Save");
            
            listaFilme = stub.getFilmeUsuario(user.getEmail());
            
            for (FilmeUsuario filme : listaFilme) {
                String tabelaFilmes[] = {filme.getNomeFilme(), Integer.toString(filme.getAnoFilme()), Integer.toString(filme.getNotaFilme())};
                defaultFilmes.addRow(tabelaFilmes);
                
            }

        } catch (Exception e) {
            System.out.println(e);
        }
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
        listaButton = new javax.swing.JButton();
        filmePoster = new javax.swing.JLabel();
        filmeButton = new javax.swing.JButton();
        voltarButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        scrollBox = new javax.swing.JScrollPane();
        filmesTable = new javax.swing.JTable();
        descLabel = new javax.swing.JLabel();
        nomeLabel = new javax.swing.JLabel();
        filmesBox = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1024, 768));
        jPanel1.setMinimumSize(new java.awt.Dimension(1024, 768));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logoMini.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/saveLogoMini.png"))); // NOI18N
        jPanel1.add(logoMini, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        listaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/porListaIcon.png"))); // NOI18N
        listaButton.setBorder(null);
        listaButton.setBorderPainted(false);
        listaButton.setContentAreaFilled(false);
        listaButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        listaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaButtonActionPerformed(evt);
            }
        });
        jPanel1.add(listaButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 401, -1, -1));
        jPanel1.add(filmePoster, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, 220, 270));

        filmeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/porFilmeIcon.png"))); // NOI18N
        filmeButton.setBorder(null);
        filmeButton.setBorderPainted(false);
        filmeButton.setContentAreaFilled(false);
        filmeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        filmeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filmeButtonActionPerformed(evt);
            }
        });
        jPanel1.add(filmeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(578, 384, -1, -1));

        voltarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/voltar2.png"))); // NOI18N
        voltarButton.setBorder(null);
        voltarButton.setBorderPainted(false);
        voltarButton.setContentAreaFilled(false);
        voltarButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        voltarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarButtonActionPerformed(evt);
            }
        });
        jPanel1.add(voltarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 40, -1, -1));

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

        filmesTable.setBackground(new java.awt.Color(255, 255, 255));
        filmesTable.setFont(new java.awt.Font("JetBrains Mono", 1, 12)); // NOI18N
        filmesTable.setForeground(new java.awt.Color(0, 0, 0));
        filmesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Filme", "Ano", "Nota"
            }
        ));
        scrollBox.setViewportView(filmesTable);

        jPanel1.add(scrollBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 810, 400));

        descLabel.setFont(new java.awt.Font("Sansita", 0, 28)); // NOI18N
        descLabel.setForeground(new java.awt.Color(0, 0, 0));
        descLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        descLabel.setText("como deseja ver seus filmes?");
        jPanel1.add(descLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, 330, -1));

        nomeLabel.setFont(new java.awt.Font("Sansita One", 0, 60)); // NOI18N
        nomeLabel.setForeground(new java.awt.Color(0, 0, 0));
        nomeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nomeLabel.setText("NOME");
        jPanel1.add(nomeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 28, 710, -1));

        filmesBox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/filmesBox.png"))); // NOI18N
        jPanel1.add(filmesBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 81, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    //Volta para a visualização inicial do app Filmes
    private void voltarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarButtonActionPerformed
        exibirMenu();
    }//GEN-LAST:event_voltarButtonActionPerformed
    
    //Exibir filmes através de uma lista
    private void listaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaButtonActionPerformed
        exibirLista();
    }//GEN-LAST:event_listaButtonActionPerformed
    
    //Exibe visualização unitaria por filme (com poster)
    private void filmeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filmeButtonActionPerformed
        exibirFilme();
        
        try {
            System.out.println(listaFilme.get(count).getPosterFilme());
            filmePoster.setIcon(poster(listaFilme.get(0).getPosterFilme()));
        } catch (Exception ex) {
            Logger.getLogger(Filmes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_filmeButtonActionPerformed

    // Volta para a página de login
    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        
        Index index = new Index();
        
        index.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Filmes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Filmes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Filmes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Filmes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Filmes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel descLabel;
    private javax.swing.JButton filmeButton;
    private javax.swing.JLabel filmePoster;
    private javax.swing.JLabel filmesBox;
    private javax.swing.JTable filmesTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton listaButton;
    private javax.swing.JLabel logoMini;
    private javax.swing.JButton logoutButton;
    private javax.swing.JLabel nomeLabel;
    private javax.swing.JScrollPane scrollBox;
    private javax.swing.JButton voltarButton;
    // End of variables declaration//GEN-END:variables
}
